namespace OurGP.Nodes.Values.NumericValues
{
    public class NumericNegation : NumericValue
    {
        internal static new readonly int minDepth = 2;
        private NumericValue NValue
        {
            get => (NumericValue)_children[0];
            set => _children[0] = value;
        }


        //! ---------- CONSTRUCTORS ----------
        //* Depth constructor
        public NumericNegation(int depth, Node? parent)
            : base(1, depth, parent) { }
        
        //* Parameterized constructor
        public NumericNegation(NumericValue value)
            : base(1)
        {
            NValue = value;
        }

        //* Grow constructor
        public static new NumericNegation Grow(int maxDepth, int currentDepth = 0, Node? parent = null)
        {
            // Console.WriteLine($"ArithmeticOperation.Grow({currentDepth}, {maxDepth})");
            if (maxDepth - currentDepth < minDepth)
                throw new System.ArgumentException(GrowErrorMessage(maxDepth, currentDepth));
                
            var node = new NumericNegation(currentDepth, parent);
            node.NValue = NumericValue.Grow(maxDepth, currentDepth + 1, node);
            return node;
        }
        static string GrowErrorMessage(int maxDepth, int currentDepth)
        {
            return $"From node NumericNegation on depth={currentDepth}:\n\tCannot grow NumericNegation Node of depth={maxDepth - currentDepth},\n\tMinimum depth is {minDepth}";
        }

        //* Copy constructor
        public static NumericNegation DeepCopy(NumericNegation other)
        {
            return new NumericNegation(NumericValue.DeepCopy(other.NValue));
        }


        //! ---------- PROPERTIES ----------
        public override double Value => -NValue.Value;

        public override int MinDepth => NValue.MinDepth + 1;
        public override int MaxDepth => NValue.MaxDepth + 1;


        //! ---------- METHODS ----------
        public override string ToString()
        {
            return $"-({NValue})";
        }
    }
}