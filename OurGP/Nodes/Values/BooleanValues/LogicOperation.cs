namespace OurGP.Nodes.Values.BooleanValues
{
    public class LogicOperation : BooleanValue
    {
        public enum Operator
        {
            And,
            Or,
        }

        internal static new readonly int minDepth = 2;
        private Operator _operator;
        private BooleanValue Left
        {
            get => (BooleanValue)_children[0];
            set => _children[0] = value;
        }
        private BooleanValue Right
        {
            get => (BooleanValue)_children[1];
            set => _children[1] = value;
        }
        

        //! ---------- CONSTRUCTORS ----------
        //* Depth constructor
        public LogicOperation(int depth, Node? parent)
            : base(2, depth, parent) { }

        //* Parameterized constructor
        public LogicOperation(BooleanValue left, BooleanValue right, Operator @operator)
            : base(2)
        {
            Left = left;
            Right = right;
            _operator = @operator;
        }

        //* Grow constructor
        public static new LogicOperation Grow(int maxDepth, int currentDepth = 0, Node? parent = null)
        {
            // Console.WriteLine($"ComparisonOperation.Grow({currentDepth}, {maxDepth})");
            if (maxDepth - currentDepth < minDepth)
                throw new System.ArgumentException(GrowErrorMessage(maxDepth, currentDepth));

            var node = new LogicOperation(currentDepth, parent)
            {
                _operator = (Operator)GP.rd.Next(0, 2)
            };
            node.Left = BooleanValue.Grow(maxDepth, currentDepth + 1, node);
            node.Right = BooleanValue.Grow(maxDepth, currentDepth + 1, node);
            return node;
        }
        static string GrowErrorMessage(int maxDepth, int currentDepth)
        {
            return $"From node LogicOperation on depth={currentDepth}:\n\tCannot grow LogicOperation Node of depth={maxDepth - currentDepth},\n\tMinimum depth is {minDepth}";
        }

        //* Copy constructor
        public static LogicOperation DeepCopy(LogicOperation other)
        {
            return new LogicOperation(BooleanValue.DeepCopy(other.Left),
                                      BooleanValue.DeepCopy(other.Right),
                                      other._operator);
        }


        //! ---------- PROPERTIES ----------
        public override bool Value => _operator switch
        {
            Operator.And => Left.Value && Right.Value,
            Operator.Or  => Left.Value || Right.Value,
            _ => throw new ArgumentException($"Unknown logic operation type: {_operator}")
        };

        public override int MinDepth => Math.Min(Left.MinDepth, Right.MinDepth) + 1;
        public override int MaxDepth => Math.Max(Left.MaxDepth, Right.MaxDepth) + 1;


        //! ---------- METHODS ----------
        public override string ToString()
        {
            return $"{Left} {OperatorString(_operator)} {Right}";
        }
        public static string OperatorString(Operator @operator)
        {
            return @operator switch
            {
                Operator.And => "&&",
                Operator.Or  => "||",
                _ => throw new ArgumentException($"Unknown comparison operation type: {@operator}")
            };
        }
    }
}