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
        private BooleanValue _left;
        private BooleanValue _right;
        

        //! ---------- CONSTRUCTORS ----------
        // TODO: Copy constructor
        // public LogicOperation(LogicOperation logicOperation)
        
        //* Parameterized constructor
        public LogicOperation(BooleanValue left, BooleanValue right, Operator @operator)
        {
            _left = left;
            _right = right;
            _operator = @operator;
        }

        //* Grow constructor
        public LogicOperation(int currentDepth, int maxDepth, Node? parent)
            : base(currentDepth, parent)
        {
            // Console.WriteLine($"ComparisonOperation.Grow({currentDepth}, {maxDepth})");
            if (maxDepth - currentDepth < minDepth)
                throw new System.ArgumentException(GrowErrorMessage(currentDepth, maxDepth));

            _left = BooleanValue.Random(currentDepth + 1, maxDepth, parent);
            _right = BooleanValue.Random(currentDepth + 1, maxDepth, parent);
            _operator = (Operator)rd.Next(0, 2);
        }

        static string GrowErrorMessage(int currentDepth, int maxDepth)
        {
            return $"From node LogicOperation on depth={currentDepth}:\n\tCannot grow LogicOperation Node of depth={maxDepth - currentDepth},\n\tMinimum depth is {minDepth}";
        }


        //! ---------- EVALUATION ----------
        public override bool Value => _operator switch
        {
            Operator.And => _left.Value && _right.Value,
            Operator.Or  => _left.Value || _right.Value,
            _ => throw new ArgumentException($"Unknown logic operation type: {_operator}")
        };


        //! ---------- TO STRING ----------
        public override string ToString()
        {
            return $"{_left} {OperatorString(_operator)} {_right}";
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