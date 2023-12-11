namespace OurGP.Nodes.Values.NumericValues
{
    public class NumericNegation : NumericValue
    {
        internal static new readonly int minDepth = 2;
        private NumericValue _value;


        //! ---------- CONSTRUCTORS ----------
        // TODO: Copy constructor
        // public ArithmeticOperation(ArithmeticOperation arithmeticOperation)

        //* Parameterized constructor
        public NumericNegation(NumericValue value)
        {
            _value = value;
        }

        //* Grow constructor
        public NumericNegation(int currentDepth, int maxDepth, Node? parent)
            : base(currentDepth, parent)
        {
            // Console.WriteLine($"ArithmeticOperation.Grow({currentDepth}, {maxDepth})");
            if (maxDepth - currentDepth < minDepth)
                throw new System.ArgumentException(GrowErrorMessage(currentDepth, maxDepth));

            _value = NumericValue.Random(currentDepth + 1, maxDepth, this);
        }

        static string GrowErrorMessage(int currentDepth, int maxDepth)
        {
            return $"From node NumericNegation on depth={currentDepth}:\n\tCannot grow NumericNegation Node of depth={maxDepth - currentDepth},\n\tMinimum depth is {minDepth}";
        }


        //! ---------- EVALUATION ----------
        public override double Value => -_value.Value;


        //! ---------- TO STRING ----------
        public override string ToString()
        {
            return $"-({_value})";
        }
    }
}