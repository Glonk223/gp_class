namespace OurGP.Nodes.Values.NumericValues
{
    public class ArithmeticOperation : NumericValue
    {
        public enum Operator
        {
            Addition,
            Subtraction,
            Multiplication,
            Division,
            Modulo,
        }

        internal static new readonly int minDepth = 2;
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
        public static new ArithmeticOperation Grow(int maxDepth, int currentDepth = 0, Node? parent = null)
        {
            // Console.WriteLine($"ArithmeticOperation.Grow({currentDepth}, {maxDepth})");
            if (maxDepth - currentDepth < minDepth)
                throw new System.ArgumentException(GrowErrorMessage(maxDepth, currentDepth));

            var node = new ArithmeticOperation(currentDepth, parent)
            {
                _operator = (Operator)GP.rd.Next(0, 5)
            };
            node.Left = NumericValue.Grow(maxDepth, currentDepth + 1, node);
            node.Right = NumericValue.Grow(maxDepth, currentDepth + 1, node);
            return node;
        }
        static string GrowErrorMessage(int maxDepth, int currentDepth)
        {
            return $"From node ArithmeticOperation on depth={currentDepth}:\n\tCannot grow ArithmeticOperation Node of depth={maxDepth - currentDepth},\n\tMinimum depth is {minDepth}";
        }

        //* Copy constructor
        public static ArithmeticOperation DeepCopy(ArithmeticOperation other)
        {
            return new ArithmeticOperation(NumericValue.DeepCopy(other.Left),
                                           NumericValue.DeepCopy(other.Right),
                                           other._operator);
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
        public override string ToString()
        {
            return $"({Left} {OperatorString(_operator)} {Right})";
        }
        private static string OperatorString(Operator @operator)
        {
            return @operator switch
            {
                Operator.Addition        => "+",
                Operator.Subtraction     => "-",
                Operator.Multiplication  => "*",
                Operator.Division        => "/",
                Operator.Modulo          => "%",
                _ => throw new ArgumentException($"Unknown arithmetic operation type: {@operator}")
            };
        }
    }
}