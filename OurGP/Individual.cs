using GPInterpreter;
using OurGP.Nodes;
class Individual
{
    public Programm Program;
    private double fitness = 1;
    // Fitness is negative, bigger (closer to 0) is better
    public double Fitness
    {
        get
        {
            if (fitness > 0)
                fitness = GP.fitnessFunction.Evaluate(this);
            return fitness;
        }
    }


    //! ---------- CONSTRUCTORS ----------
    public Individual(int initialDepth)
    {
        Program = Programm.Grow(initialDepth);
        fitness = GP.fitnessFunction.Evaluate(this);
    }

    public Individual(Programm program)
    {
        Program = program;
        fitness = GP.fitnessFunction.Evaluate(this);
    }


    //! ---------- RUN ----------
    public InOutVector Run(List<Value> inputs) => Program.Run(inputs);
}
