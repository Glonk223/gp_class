using GPInterpreter;

namespace Fitness;

class Target
{
    public List<Value> Inputs = new();
    public List<Value> ExpectedOutputs = new();
    public int Length => Inputs.Count;
}
