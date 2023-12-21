namespace GPInterpreter;

public class RuntimeInstructions : Exception
{
    public RuntimeInstructions()
    {
    }

    public RuntimeInstructions(string message)
        : base(message)
    {
    }

    public RuntimeInstructions(string message, Exception inner)
        : base(message, inner)
    {
    }
}