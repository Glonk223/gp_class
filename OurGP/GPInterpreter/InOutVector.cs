namespace GPInterpreter;


public class InOutVector {
    public List<Value> input = new();
    public List<Value> output = new();
    public List<bool> scanned = Enumerable.Repeat(false, 20).ToList();
    public List<int> used = Enumerable.Repeat(0, 20).ToList();
    public int counter;

    public InOutVector(List<Value>? values = null)
    {
        input = values ?? new();
        counter = 0;
    }

    public Value Read()
    {
        return input[counter++ % input.Count];
    }

    public void Add(Value value)
    {
        output.Add(value);
    }
}