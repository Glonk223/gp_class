using OurGP.Nodes.Values;

namespace OurGP.Nodes.Expressions
{
    public class PrintStatement : Expression
    {
        internal static new readonly int minDepth = 2;
        private Value Value
        {
            get => (Value)_children[0];
            set => _children[0] = value;
        }
        // TODO: Create IOut interface and implement it in ConsoleOut
        // private static IOut output;


        //! ---------- CONSTRUCTORS ----------
        //* Static constructor
        static PrintStatement()
        {
            // TODO: Make this configurable
            // output = 
        }

        //* Depth constructor
        public PrintStatement(int depth, Node? parent)
            : base(1, depth, parent) { }

        //* Parameterized constructor
        public PrintStatement(Value value)
            : base(1)
        {
            Value = value;
        }

        //* Grow constructor
        public static new PrintStatement Grow(int maxDepth, int currentDepth = 0, Node? parent = null)
        {
            // Console.WriteLine($"PrintStatement.Grow({currentDepth}, {maxDepth})");
            if (maxDepth - currentDepth < minDepth)
                throw new System.ArgumentException(GrowErrorMessage(maxDepth, currentDepth));

            var node = new PrintStatement(currentDepth, parent);
            node.Value = Value.Grow(maxDepth, currentDepth + 1, node);
            return node;
        }
        static string GrowErrorMessage(int maxDepth, int currentDepth)
        {
            return $"From node PrintStatement on depth={currentDepth}:\n\tCannot grow PrintStatement Node of depth={maxDepth - currentDepth},\n\tMinimum depth is {minDepth}";
        }

        //* Copy constructor
        public static PrintStatement DeepCopy(PrintStatement other)
        {
            return new PrintStatement(Value.DeepCopy(other.Value));
        }


        //! ---------- PROPERTIES ----------
        public override int MinDepth => Value.MinDepth + 1;
        public override int MaxDepth => Value.MaxDepth + 1;


        //! ---------- METHODS ----------
        public override void Run()
        {
            // output.Write(_value.IOPrint());
        }

        public override string ToString(string indent = "")
        {
            return $"{indent}print({Value})";
        }
    }
}