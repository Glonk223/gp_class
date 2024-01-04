namespace OurGP.Nodes.Values.NumericValues
{
    public class ArithmeticOperation : NumericValue, IOperation
    {
        public enum Operator
        {
            Addition,
            Subtraction,
            Multiplication,
            Division,
            Modulo,
        }

        internal static new readonly int minDepthToLeaf = 2;
        internal static new readonly int maxDepthToLeaf = int.MaxValue;
        private Operator _operator;
        private NumericValue Left
        {
            get => (NumericValue)_children[0];
            set => _children[0] = value;
        }
        private NumericValue Right
        {
            get => (NumericValue)_children[1];
            set => _children[1] = value;
        }


        //! ---------- CONSTRUCTORS ----------
        //* Depth constructor
        public ArithmeticOperation(int depth, Node? parent)
            : base(2, depth, parent) { }

        //* Parameterized constructor
        public ArithmeticOperation(NumericValue left, NumericValue right, Operator @operator)
            : base(2)
        {
            Left = left;
            Right = right;
            _operator = @operator;
        }

        //* Grow constructor
        public static new ArithmeticOperation Grow(int maxDepth, int minDepth = 0, int currentDepth = 0, Node? parent = null)
        {
            // Console.WriteLine($"ArithmeticOperation.Grow({currentDepth}, {maxDepth})");
            if (maxDepth - currentDepth < minDepthToLeaf)
                throw new System.ArgumentException(GrowErrorMessage(maxDepth, currentDepth));

            var node = new ArithmeticOperation(currentDepth, parent)
            {
                _operator = (Operator)GP.rd.Next(0, 5)
            };
            node.Left  = NumericValue.Grow(maxDepth, minDepth, currentDepth + 1, node);
            node.Right = NumericValue.Grow(maxDepth, minDepth, currentDepth + 1, node);
            return node;
        }
        static string GrowErrorMessage(int maxDepth, int currentDepth)
        {
            return $"From node ArithmeticOperation on depth={currentDepth}:\n\tCannot grow ArithmeticOperation Node of depth={maxDepth - currentDepth},\n\tMinimum depth is {minDepthToLeaf}";
        }

        //* Copy constructor
        public new ArithmeticOperation DeepCopy()
        {
            return new ArithmeticOperation(Left.DeepCopy(), Right.DeepCopy(), _operator);
        }


        //! ---------- PROPERTIES ----------
        public override double Value => _operator switch
        {
            Operator.Addition        => Left.Value + Right.Value,
            Operator.Subtraction     => Left.Value - Right.Value,
            Operator.Multiplication  => Left.Value * Right.Value,
            Operator.Division        => Left.Value / Right.Value,
            Operator.Modulo          => Left.Value % Right.Value,
            _ => throw new ArgumentException($"Unknown arithmetic operation type: {_operator}")
        };

        public override int MinDepth => Math.Min(Left.MinDepth, Right.MinDepth) + 1;
        public override int MaxDepth => Math.Max(Left.MaxDepth, Right.MaxDepth) + 1;


        //! ---------- METHODS ----------
        public override string ToString() =>
            (Left is IOperation  ? $"({Left})"  : $"{Left}" ) +
            $" {OperatorString(_operator)} " +
            (Right is IOperation ? $"({Right})" : $"{Right}");
        private static string OperatorString(Operator @operator) =>
            @operator switch
            {
                Operator.Addition        => "+",
                Operator.Subtraction     => "-",
                Operator.Multiplication  => "*",
                Operator.Division        => "/",
                Operator.Modulo          => "%",
                _ => throw new ArgumentException($"Unknown arithmetic operation type: {@operator}")
            };

        public override Type GetReplacementType(Node child)
        {
            if (child == Left || child == Right)
                return typeof(NumericValue);
            else
                throw new ArgumentException($"Node {child} is not a child of {this}");
        }
    }
}