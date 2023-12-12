namespace OurGP.Nodes.Values.NumericValues
{
    public class NumericConstant : NumericValue, IConstant
    {
        internal static new readonly int minDepth = 1;
        private static readonly int _size = 100; // TODO: _size = ConstNum
        private static readonly double[] _constants;
        private int _index;


        //! ---------- CONSTRUCTORS ----------
        //* Static constructor
        static NumericConstant()
        {
            _constants = new double[_size];
            for (int i = 0; i < _size; i++)
                _constants[i] = i; // TODO: _constants[i] = ranodm double in range [0 - RandomMax]
        }

        //* Depth constructor
        public NumericConstant(int depth, Node? parent)
            : base(0, depth, parent) { }

        //* Parameterized constructor
        public NumericConstant(double constant)
            : base(0)
        {
            // TODO
        }
        
        //* Grow constructor
        public static new NumericConstant Grow(int maxDepth, int currentDepth = 0, Node? parent = null)
        {
            // Console.WriteLine($"NumericConstant.Grow({currentDepth}, {maxDepth})");
            if (maxDepth - currentDepth < minDepth)
                throw new System.ArgumentException(GrowErrorMessage(maxDepth, currentDepth));

            return new NumericConstant(currentDepth, parent)
            {
                _index = GP.rd.Next(_size)
            };
        }
        static string GrowErrorMessage(int maxDepth, int currentDepth)
        {
            return $"From node NumericConstant on depth={currentDepth}:\n\tCannot grow NumericConstant Node of depth={maxDepth - currentDepth},\n\tMinimum depth is {minDepth}";
        }

        //* Copy constructor
        public static NumericConstant DeepCopy(NumericConstant other)
        {
            return new NumericConstant(_constants[other._index]);
        }


        //! ---------- PROPERTIES ----------
        public override double Value => _constants[_index];

        public override int MinDepth => 1;
        public override int MaxDepth => 1;


        //! ---------- METHODS ----------
        public override string ToString()
        {
            return $"{_constants[_index]}";
        }
    }
}