using GPInterpreter;

namespace Fitness;

class FitnessFunction
{
    static double _punishment = 1e12;
    static double _mult_punishment = 1e6;
    readonly bool _restrictOutputLength;
    readonly List<Target> _targets;


    //! ---------- CONSTRUCTORS ----------
    public FitnessFunction(List<Target> targets, bool restrictOutputLength=false)
    {
        _targets = targets;
        _restrictOutputLength = restrictOutputLength;
    }

    public FitnessFunction(string filename, bool restrictOutputLength=false)
    {
        _targets = new List<Target>();
        _restrictOutputLength = restrictOutputLength;

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

            _targets.Add(target);
        }
    }


    //! ---------- EVALUATION ----------
    public double Evaluate(Individual individual)
    {
        double fitness = 0;
        foreach (var target in _targets)
        {
            var output = individual.Run(target.Inputs);
            fitness -= EvaluateTarget(output, target.ExpectedOutputs);
        }
        return fitness;
    }

    public double EvaluateTarget(List<Value> output, List<Value> expectedOutput)
    {
        double res = 0;
        for (int i = 0; i < expectedOutput.Count; i++)
        {
            if (i >= output.Count)
                res += _punishment;
            else
                res += _mult_punishment * Math.Abs(output[i].GetNum() - expectedOutput[i].GetNum());
        }

        if (_restrictOutputLength)
            res += _punishment * Math.Abs(output.Count - expectedOutput.Count);
        return res;
    }
}
