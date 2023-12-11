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
        private NumericValue _left;
        private NumericValue _right;


        //! ---------- CONSTRUCTORS ----------
        // TODO: Copy constructor
        // public ArithmeticOperation(ArithmeticOperation arithmeticOperation)

        //* Parameterized constructor
        public ArithmeticOperation(NumericValue left, NumericValue right, Operator @operator)
        {
            _left = left;
            _right = right;
            _operator = @operator;
        }

        //* Grow constructor
        public ArithmeticOperation(int currentDepth, int maxDepth, Node? parent)
            : base(currentDepth, parent)
        {
            // Console.WriteLine($"ArithmeticOperation.Grow({currentDepth}, {maxDepth})");
            if (maxDepth - currentDepth < minDepth)
                throw new System.ArgumentException(GrowErrorMessage(currentDepth, maxDepth));

            _left = NumericValue.Random(currentDepth + 1, maxDepth, this);
            _right = NumericValue.Random(currentDepth + 1, maxDepth, this);
            _operator = (Operator)rd.Next(0, 5);
        }

        static string GrowErrorMessage(int currentDepth, int maxDepth)
        {
            return $"From node ArithmeticOperation on depth={currentDepth}:\n\tCannot grow ArithmeticOperation Node of depth={maxDepth - currentDepth},\n\tMinimum depth is {minDepth}";
        }


        //! ---------- EVALUATION ----------
        public override double Value => _operator switch
        {
            Operator.Addition        => _left.Value + _right.Value,
            Operator.Subtraction     => _left.Value - _right.Value,
            Operator.Multiplication  => _left.Value * _right.Value,
            Operator.Division        => _left.Value / _right.Value,
            Operator.Modulo          => _left.Value % _right.Value,
            _ => throw new ArgumentException($"Unknown arithmetic operation type: {_operator}")
        };


        //! ---------- TO STRING ----------
        public override string ToString()
        {
            return $"({_left} {OperatorString(_operator)} {_right})";
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