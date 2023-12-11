namespace OurGP.Nodes.Values.NumericValues
{
    public class NumericVariable : NumericValue, IVariable
    {
        internal static new readonly int minDepth = 1;
        private static readonly int _size = 10; // TODO: _size = VarNum
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

        // TODO: Copy constructor
        // public NumericVariable(NumericVariable numericVariable)

        //* Parameterized constructor
        public NumericVariable(int index)
        {
            _index = index;
        }

        //* Grow constructor
        public NumericVariable(int currentDepth, int maxDepth, Node? parent)
            : base(currentDepth, parent)
        {
            // Console.WriteLine($"NumericVariable.Grow({currentDepth}, {maxDepth})");
            if (maxDepth - currentDepth < minDepth)
                throw new System.ArgumentException(GrowErrorMessage(currentDepth, maxDepth));

            _index = rd.Next(_size);
        }

        static string GrowErrorMessage(int currentDepth, int maxDepth)
        {
            return $"From node NumericVariable on depth={currentDepth}:\n\tCannot grow NumericVariable Node of depth={maxDepth - currentDepth},\n\tMinimum depth is {minDepth}";
        }


        //! ---------- EVALUATION ----------
        public override double Value => _variables[_index];


        //! ---------- VARIABLE INTERFACE ----------
        public void Assign(Value value)
        {
            if (value is NumericValue numericValue)
                _variables[_index] = numericValue.Value;
            else
                throw new System.Exception("Cannot assign a non-numeric value to a numeric variable.");
        }


        //! ---------- TO STRING ----------
        public override string ToString()
        {
            return $"X{_index}";
        }
    }
}