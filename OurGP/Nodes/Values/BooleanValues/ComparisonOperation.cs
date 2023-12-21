using OurGP.Nodes.Values.NumericValues;

namespace OurGP.Nodes.Values.BooleanValues
{
    
    public class ComparisonOperation : BooleanValue, IOperation
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
        public ComparisonOperation(int depth, Node? parent)
            : base(2, depth, parent) { }

        //* Parameterized constructor
        public ComparisonOperation(NumericValue left, NumericValue right, Operator @operator)
            : base(2)
        {
            Left = left;
            Right = right;
            _operator = @operator;
        }

        //* Grow constructor
        public static new ComparisonOperation Grow(int maxDepth, int currentDepth = 0, Node? parent = null)
        {
            // Console.WriteLine($"ComparisonOperation.Grow({currentDepth}, {maxDepth})");
            if (maxDepth - currentDepth < minDepth)
                throw new System.ArgumentException(GrowErrorMessage(maxDepth, currentDepth));

            var node = new ComparisonOperation(currentDepth, parent)
            {
                _operator = (Operator)GP.rd.Next(0, 6)
            };
            node.Left = NumericValue.Grow(maxDepth, currentDepth + 1, node);
            node.Right = NumericValue.Grow(maxDepth, currentDepth + 1, node);
            return node;
        }
        static string GrowErrorMessage(int maxDepth, int currentDepth)
        {
            return $"From node ComparisonOperation on depth={currentDepth}:\n\tCannot grow ComparisonOperation Node of depth={maxDepth - currentDepth},\n\tMinimum depth is {minDepth}";
        }

        //* Copy constructor
        public new ComparisonOperation DeepCopy()
        {
            return new ComparisonOperation(Left.DeepCopy(), Right.DeepCopy(), _operator);
        }


        //! ---------- PROPERTIES ----------
        public override bool Value => _operator switch
        {
            Operator.Equal              => Left.Value == Right.Value,
            Operator.NotEqual           => Left.Value != Right.Value,
            Operator.LessThan           => Left.Value  < Right.Value,
            Operator.GreaterThan        => Left.Value  > Right.Value,
            Operator.LessThanOrEqual    => Left.Value <= Right.Value,
            Operator.GreaterThanOrEqual => Left.Value >= Right.Value,
            _ => throw new ArgumentException($"Unknown comparison operation type: {_operator}")
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
                Operator.Equal              => "==",
                Operator.NotEqual           => "!=",
                Operator.LessThan           => "<",
                Operator.GreaterThan        => ">",
                Operator.LessThanOrEqual    => "<=",
                Operator.GreaterThanOrEqual => ">=",
                _ => throw new ArgumentException($"Unknown comparison operation type: {@operator}")
            };

        public override Type GetReplacementType(Node child)
        {
            if (child == Left || child == Right)
                return typeof(NumericValue);
            else
                throw new System.ArgumentException($"Node {child} is not a child of {this}");
        }
    }
}