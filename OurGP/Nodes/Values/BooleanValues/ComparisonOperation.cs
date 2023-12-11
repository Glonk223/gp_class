using OurGP.Nodes.Values.NumericValues;

namespace OurGP.Nodes.Values.BooleanValues
{
    
    public class ComparisonOperation : BooleanValue
    {
        public enum Operator
        {
            Equal,
            NotEqual,
            LessThan,
            GreaterThan,
            LessThanOrEqual,
            GreaterThanOrEqual,
        }

        internal static new readonly int minDepth = 2;
        private Operator _operator;
        private NumericValue _left;
        private NumericValue _right;


        //! ---------- CONSTRUCTORS ----------
        // TODO: Copy constructor
        // public ComparisonOperation(ComparisonOperation comparisonOperation)
        
        //* Parameterized constructor
        public ComparisonOperation(NumericValue left, NumericValue right, Operator @operator)
        {
            _left = left;
            _right = right;
            _operator = @operator;
        }

        //* Grow constructor
        public ComparisonOperation(int currentDepth, int maxDepth, Node? parent)
            : base(currentDepth, parent)
        {
            // Console.WriteLine($"ComparisonOperation.Grow({currentDepth}, {maxDepth})");
            if (maxDepth - currentDepth < minDepth)
                throw new System.ArgumentException(GrowErrorMessage(currentDepth, maxDepth));

            _left = NumericValue.Random(currentDepth + 1, maxDepth, this);
            _right = NumericValue.Random(currentDepth + 1, maxDepth, this);
            _operator = (Operator)rd.Next(0, 6);
        }

        static string GrowErrorMessage(int currentDepth, int maxDepth)
        {
            return $"From node ComparisonOperation on depth={currentDepth}:\n\tCannot grow ComparisonOperation Node of depth={maxDepth - currentDepth},\n\tMinimum depth is {minDepth}";
        }


        //! ---------- EVALUATION ----------
        public override bool Value => _operator switch
        {
            Operator.Equal              => _left.Value == _right.Value,
            Operator.NotEqual           => _left.Value != _right.Value,
            Operator.LessThan           => _left.Value  < _right.Value,
            Operator.GreaterThan        => _left.Value  > _right.Value,
            Operator.LessThanOrEqual    => _left.Value <= _right.Value,
            Operator.GreaterThanOrEqual => _left.Value >= _right.Value,
            _ => throw new ArgumentException($"Unknown comparison operation type: {_operator}")
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
                Operator.Equal              => "==",
                Operator.NotEqual           => "!=",
                Operator.LessThan           => "<",
                Operator.GreaterThan        => ">",
                Operator.LessThanOrEqual    => "<=",
                Operator.GreaterThanOrEqual => ">=",
                _ => throw new ArgumentException($"Unknown comparison operation type: {@operator}")
            };
        }
    }
}