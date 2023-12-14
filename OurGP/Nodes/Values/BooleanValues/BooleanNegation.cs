namespace OurGP.Nodes.Values.BooleanValues
{
    public class BooleanNegation : BooleanValue
    {
        internal static new readonly int minDepth = 2;
        private BooleanValue BValue
        {
            get => (BooleanValue)_children[0];
            set => _children[0] = value;
        }


        //! ---------- CONSTRUCTORS ----------
        //* Depth constructor
        public BooleanNegation(int depth, Node? parent)
            : base(1, depth, parent) { }

        //* Parameterized constructor
        public BooleanNegation(BooleanValue bValue)
            : base(1)
        {
            BValue = bValue;
        }

        //* Grow constructor
        public static new BooleanNegation Grow(int maxDepth, int currentDepth = 0, Node? parent = null)
        {
            // Console.WriteLine($"ArithmeticOperation.Grow({currentDepth}, {maxDepth})");
            if (maxDepth - currentDepth < minDepth)
                throw new System.ArgumentException(GrowErrorMessage(maxDepth, currentDepth));
            
            var node = new BooleanNegation(currentDepth, parent);
            node.BValue = BooleanValue.Grow(maxDepth, currentDepth + 1, node);
            return node;
        }
        static string GrowErrorMessage(int maxDepth, int currentDepth)
        {
            return $"From node NumericNegation on depth={currentDepth}:\n\tCannot grow NumericNegation Node of depth={maxDepth - currentDepth},\n\tMinimum depth is {minDepth}";
        }

        //* Copy constructor
        public new BooleanNegation DeepCopy()
        {
            return new BooleanNegation(BValue.DeepCopy());
        }


        //! ---------- PROPERTIES ----------
        public override bool Value => !BValue.Value;

        public override int MinDepth => BValue.MinDepth + 1;
        public override int MaxDepth => BValue.MaxDepth + 1;


        //! ---------- METHODS ----------
        public override string ToString() =>
            BValue is IOperation ? $"!({BValue})" : $"!{BValue}";
    }
}