using System.Collections.ObjectModel;
using System.Data;
using GPInterpreter;

namespace Fitness;

class FitnessFunction
{
    static readonly double _outputLenghtPunishment = 1e9;
    static readonly double _valuePunishment        = 1e1;
    static readonly double _inputNotReadPunishment = 1e9;
    static readonly double _usedInputPunishment    = 1e3;
    readonly bool restrictOutputLength   = true;
    readonly bool restrictOutputPosition = true;
    readonly bool checkIfReadInput       = true;
    readonly bool checkUsedInput         = true;
    readonly List<Target> targets;
    InOutVector? ioVector;


    //! ---------- CONSTRUCTORS ----------
    public FitnessFunction(List<Target> targets,
        bool restrictOutputLength=false,
        bool restrictOutputPosition=false,
        bool checkIfReadInput=false,
        bool checkUsedInput=false)
    {
        this.targets = targets;
        this.restrictOutputLength = restrictOutputLength;
        this.restrictOutputPosition = restrictOutputPosition;
        this.checkIfReadInput = checkIfReadInput;
        this.checkUsedInput = checkUsedInput;
    }

    public FitnessFunction(string filename,
        bool restrictOutputLength=false,
        bool restrictOutputPosition=false,
        bool checkIfReadInput=false,
        bool checkUsedInput=false)
    {
        targets = new List<Target>();
        this.restrictOutputLength = restrictOutputLength;
        this.restrictOutputPosition = restrictOutputPosition;
        this.checkIfReadInput = checkIfReadInput;
        this.checkUsedInput = checkUsedInput;

        var lines = System.IO.File.ReadAllLines(filename);
        foreach (var line in lines)
        {
            var target = new Target();
            var parts = line.Split(":");

            target.Inputs = new();
            foreach (var input in parts[0].Trim().Split(" "))
                target.Inputs.Add(new(input));
            
            target.ExpectedOutputs = new();
            foreach (var output in parts[1].Trim().Split(" "))
                target.ExpectedOutputs.Add(new(output));

            targets.Add(target);
        }
    }


    //! ---------- EVALUATION ----------
    public double Evaluate(Individual individual)
    {
        double fitness = 0;
        foreach (var target in targets)
        {
            ioVector = individual.Run(target.Inputs);
            fitness -= EvaluateTarget(target.ExpectedOutputs);
        }
        return fitness;
    }

    public double EvaluateTarget(List<Value> expectedOutput)
    {
        if (!restrictOutputPosition && expectedOutput.Count == 1)
        {
            if (ioVector!.output.Count == 0)
                return _outputLenghtPunishment;
            
            double minRes = double.MaxValue;
            foreach (var val in ioVector.output)
            {
                double _res = Math.Abs(val.GetNum() - expectedOutput[0].GetNum());
                if (_res < minRes)
                    minRes = _res;
            }
            
            return minRes;
        }

        double res = 0;
        for (int i = 0; i < expectedOutput.Count; i++)
        {
            if (i >= ioVector!.output.Count)
                res += _outputLenghtPunishment;
            else
                res += PunishValue(ioVector.output[i].GetNum(), expectedOutput[i].GetNum());
        }

        if (restrictOutputLength)
            res += PunichLength(ioVector!.output.Count, expectedOutput.Count);

        if (checkIfReadInput)
            res += PunishNotReadInput();

        if (checkUsedInput)
            res += PunishUsedInput();

        return res;
    }

    private static double PunishValue(double value, double expectedValue)
    {
        return _valuePunishment * Math.Abs(value - expectedValue);
    }

    private static double PunichLength(int length, int expectedLength)
    {
        return _outputLenghtPunishment * Math.Abs(length - expectedLength);
    }

    private double PunishNotReadInput()
    {
        var read = ioVector!.scanned.Where(x => x == true).Count();
        if (read < ioVector.input.Count)
            return _inputNotReadPunishment * (ioVector.input.Count - read);
        return 0;
    }

    private double PunishUsedInput()
    {
        return -_usedInputPunishment * ioVector!.used.Sum();
    }
}
