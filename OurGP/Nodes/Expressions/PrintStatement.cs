using OurGP.Nodes.Values;

namespace OurGP.Nodes.Expressions
{
    public class PrintStatement : Expression
    {
        internal static new readonly int minDepthToLeaf = 2;
        internal static new readonly int maxDepthToLeaf = int.MaxValue;
        private Value Value
        {
            get => (Value)_children[0];
            set => _children[0] = value;
        }


        //! ---------- CONSTRUCTORS ----------
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
        public static new PrintStatement Grow(int maxDepth, int minDepth = 0, int currentDepth = 0, Node? parent = null)
        {
            // Console.WriteLine($"PrintStatement.Grow({currentDepth}, {maxDepth})");
            if (maxDepth - currentDepth < minDepthToLeaf)
                throw new System.ArgumentException(GrowErrorMessage(maxDepth, currentDepth));

            var node = new PrintStatement(currentDepth, parent);
            node.Value = Value.Grow(maxDepth, minDepth, currentDepth + 1, node);
            return node;
        }
        static string GrowErrorMessage(int maxDepth, int currentDepth)
        {
            return $"From node PrintStatement on depth={currentDepth}:\n\tCannot grow PrintStatement Node of depth={maxDepth - currentDepth},\n\tMinimum depth is {minDepthToLeaf}";
        }

        //* Copy constructor
        public new PrintStatement DeepCopy()
        {
            return new PrintStatement(Value.DeepCopy());
        }


        //! ---------- PROPERTIES ----------
        public override int MinDepth => Value.MinDepth + 1;
        public override int MaxDepth => Value.MaxDepth + 1;


        //! ---------- METHODS ----------
        public override string ToString(string indent = "")
        {
            return $"{indent}print({Value})";
        }

        public override Type GetReplacementType(Node child)
        {
            if (child == Value)
                return typeof(Value);
            else
                throw new System.ArgumentException($"Node {child} is not a child of {this}");
        }
    }
}