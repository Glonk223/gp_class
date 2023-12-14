namespace OurGP.Nodes.Values.NumericValues
{
    public class NumericConstant : NumericValue, IConstant
    {
        internal static new readonly int minDepth = 1;
        private static readonly int _size = 100;
        private static readonly double[] _constants;
        private static int _assignmentCounter = 0;
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
            _index = Array.IndexOf(_constants, constant);
            
            if (_index == -1)
            {
                _index = _assignmentCounter++;
                _constants[_index] = constant;
            }
        }
        public NumericConstant(int index)
            : base(0)
        {
            _index = index;
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
        public new NumericConstant DeepCopy()
        {
            return new NumericConstant(_index);
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