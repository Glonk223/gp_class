namespace OurGP.Nodes.Values.NumericValues
{
    public class NumericVariable : NumericValue, IVariable
    {
        internal static new readonly int minDepth = 1;
        private static readonly int _size = 10;
        private static double[] _variables;
        private int _index;


        //! ---------- CONSTRUCTORS ----------
        //* Static constructor
        static NumericVariable()
        {
            _variables = new double[_size];
            for (int i = 0; i < _size; i++)
                _variables[i] = 0;
        }

        //* Depth constructor
        public NumericVariable(int depth, Node? parent)
            : base(0, depth, parent) { }
        
        //* Parameterized constructor
        public NumericVariable(int index)
            : base(0)
        {
            _index = index;
        }

        //* Grow constructor
        public static new NumericVariable Grow(int maxDepth, int currentDepth = 0, Node? parent = null)
        {
            // Console.WriteLine($"NumericVariable.Grow({currentDepth}, {maxDepth})");
            if (maxDepth - currentDepth < minDepth)
                throw new System.ArgumentException(GrowErrorMessage(maxDepth, currentDepth));

            return new NumericVariable(currentDepth, parent)
            {
                _index = GP.rd.Next(_size)
            };
        }
        static string GrowErrorMessage(int maxDepth, int currentDepth)
        {
            return $"From node NumericVariable on depth={currentDepth}:\n\tCannot grow NumericVariable Node of depth={maxDepth - currentDepth},\n\tMinimum depth is {minDepth}";
        }

        //* Copy constructor
        public new NumericVariable DeepCopy()
        {
            return new NumericVariable(_index);
        }


        //! ---------- PROPERTIES ----------
        public override double Value => _variables[_index];

        public override int MinDepth => 1;
        public override int MaxDepth => 1;


        //! ---------- METHODS ----------
        public void Assign(Value value)
        {
            if (value is NumericValue numericValue)
                _variables[_index] = numericValue.Value;
            else
                throw new System.Exception("Cannot assign a non-numeric value to a numeric variable.");
        }

        public override string ToString()
        {
            return $"X{_index}";
        }
    }
}
