namespace OutInterface;

public interface IOutInterface
{
    void Print(string s);
    void PrintLine(string s)
    {
        Print(s + "\n");
    }

    void Print() { }
    void PrintLine() { }
    
    void Print(object o)
    {
        Print(o.ToString()!);
    }
    void PrintLine(object o)
    {
        PrintLine(o.ToString()!);
    }
}

public class FileOutputInterface : IOutInterface
{
    private readonly StreamWriter writer;

    public FileOutputInterface(StreamWriter writer)
    {
        this.writer = writer;
    }

    public void Print(string s)
    {
        try
        {
            writer.Write(s);
            writer.Flush();
        }
        catch (IOException)
        {
            Console.WriteLine("Error while writing to file.");
            Environment.Exit(1);
        }
    }

    public void Close()
    {
        try
        {
            writer.Close();
        }
        catch (IOException)
        {
            Console.WriteLine("Error while closing file writer.");
            Environment.Exit(1);
        }
    }
}

public class ConsoleOutputInterface : IOutInterface
{
    public void Print(string s)
    {
        Console.Write(s);
    }
}

public static class OutInterfaceFactory
{
    public static IOutInterface CreateOutputToFile(string filename)
    {
        try
        {
            if (File.Exists(filename))
            {
                Console.WriteLine("File already exists: " + filename);
                Console.Write("Overwrite? [y/n] ");
                var input = Console.ReadLine();
                if (input != "y" && input != "Y")
                {
                    Console.WriteLine("Exiting...");
                    Environment.Exit(0);
                }
                File.Delete(filename);
            }

            var file = new StreamWriter(filename);
            return new FileOutputInterface(file);
        }
        catch (IOException)
        {
            Console.WriteLine("Error while creating output to file: " + filename);
            Environment.Exit(1);
            return null;
        }
    }

    public static IOutInterface CreateOutputToConsole()
    {
        return new ConsoleOutputInterface();
    }
}