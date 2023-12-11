using OurGP.Nodes.Expressions.Assignments;

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

        // TODO: Copy constructor
        // public NumericConstant(NumericConstant numericConstant)

        //* Parameterized constructor
        public NumericConstant(int index)
        {
            _index = index;
        }
        
        //* Grow constructor
        public NumericConstant(int currentDepth, int maxDepth, Node? parent)
            : base(currentDepth, parent)
        {
            // Console.WriteLine($"NumericConstant.Grow({currentDepth}, {maxDepth})");
            if (maxDepth - currentDepth < minDepth)
                throw new System.ArgumentException(GrowErrorMessage(currentDepth, maxDepth));

            _index = rd.Next(_size);
        }

        static string GrowErrorMessage(int currentDepth, int maxDepth)
        {
            return $"From node NumericConstant on depth={currentDepth}:\n\tCannot grow NumericConstant Node of depth={maxDepth - currentDepth},\n\tMinimum depth is {minDepth}";
        }


        //! ---------- EVALUATION ----------
        public override double Value => _constants[_index];


        //! ---------- TO STRING ----------
        public override string ToString()
        {
            return $"{_constants[_index]}";
        }
    }
}