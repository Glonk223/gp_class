namespace OurGP.Nodes.Values.BooleanValues
{
    public class BooleanNegation : BooleanValue
    {
        internal static new readonly int minDepth = 2;
        private BooleanValue _value;


        //! ---------- CONSTRUCTORS ----------
        // TODO: Copy constructor
        // public ArithmeticOperation(ArithmeticOperation arithmeticOperation)

        //* Parameterized constructor
        public BooleanNegation(BooleanValue value)
        {
            _value = value;
        }

        //* Grow constructor
        public BooleanNegation(int currentDepth, int maxDepth, Node? parent)
            : base(currentDepth, parent)
        {
            // Console.WriteLine($"ArithmeticOperation.Grow({currentDepth}, {maxDepth})");
            if (maxDepth - currentDepth < minDepth)
                throw new System.ArgumentException(GrowErrorMessage(currentDepth, maxDepth));

            _value = BooleanValue.Random(currentDepth + 1, maxDepth, this);
        }

        static string GrowErrorMessage(int currentDepth, int maxDepth)
        {
            return $"From node NumericNegation on depth={currentDepth}:\n\tCannot grow NumericNegation Node of depth={maxDepth - currentDepth},\n\tMinimum depth is {minDepth}";
        }


        //! ---------- EVALUATION ----------
        public override bool Value => !_value.Value;


        //! ---------- TO STRING ----------
        public override string ToString()
        {
            return $"!({_value})";
        }
    }
}