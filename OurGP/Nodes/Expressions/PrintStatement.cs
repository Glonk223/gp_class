using OurGP.Nodes.Values;

namespace OurGP.Nodes.Expressions
{
    public class PrintStatement : Expression
    {
        internal static new readonly int minDepth = 2;
        private Value _value;
        // TODO: Create IOut interface and implement it in ConsoleOut
        // private static IOut output;


        //! ---------- CONSTRUCTORS ----------
        //* Static constructor
        static PrintStatement()
        {
            // TODO: Make this configurable
            // output = 
        }

        // TODO: Copy constructor
        // public PrintStatement(PrintStatement printStatement)

        //* Parameterized constructor
        public PrintStatement(Value value)
        {
            _value = value;
        }

        //* Grow constructor
        public PrintStatement(int currentDepth, int maxDepth, Node? parent)
            : base(currentDepth, parent)
        {
            // Console.WriteLine($"PrintStatement.Grow({currentDepth}, {maxDepth})");
            if (maxDepth - currentDepth < minDepth)
                throw new System.ArgumentException(GrowErrorMessage(currentDepth, maxDepth));

            _value = Value.Random(currentDepth + 1, maxDepth, this);
        }

        static string GrowErrorMessage(int currentDepth, int maxDepth)
        {
            return $"From node PrintStatement on depth={currentDepth}:\n\tCannot grow PrintStatement Node of depth={maxDepth - currentDepth},\n\tMinimum depth is {minDepth}";
        }


        //! ---------- RUN ----------
        public override void Run()
        {
            // output.Write(_value.IOPrint());
        }


        //! ---------- TO STRING ----------
        public override string ToString(string indent = "")
        {
            return $"{indent}print({_value})";
        }
    }
}