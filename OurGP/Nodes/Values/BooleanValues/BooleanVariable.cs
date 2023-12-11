namespace OurGP.Nodes.Values.BooleanValues
{
    public class BooleanVariable : BooleanValue, IVariable
    {
        internal static new readonly int minDepth = 1;
        private static readonly int _size = 10; // TODO: _size = VarNum
        private static bool[] _variables;
        private int _index;


        //! ---------- CONSTRUCTORS ----------
        //* Static constructor
        static BooleanVariable()
        {
            _variables = new bool[_size];
            for (int i = 0; i < _size; i++)
                _variables[i] = false;
        }

        // TODO: Copy constructor
        // public BooleanVariable(BooleanVariable booleanVariable)
        
        //* Parameterized constructor
        public BooleanVariable(int index)
        {
            _index = index;
        }

        //* Grow constructor
        public BooleanVariable(int currentDepth, int maxDepth, Node? parent)
            : base(currentDepth, parent)
        {
            // Console.WriteLine($"BooleanVariable.Grow({currentDepth}, {maxDepth})");
            if (maxDepth - currentDepth < minDepth)
                throw new System.ArgumentException(GrowErrorMessage(currentDepth, maxDepth));

            _index = rd.Next(_size);
        }

        static string GrowErrorMessage(int currentDepth, int maxDepth)
        {
            return $"From node BooleanVariable on depth={currentDepth}:\n\tCannot grow BooleanVariable Node of depth={maxDepth - currentDepth},\n\tMinimum depth is {minDepth}";
        }

        
        //! ---------- EVALUATION ----------
        public override bool Value => _variables[_index];


        //! ---------- VARIABLE INTERFACE ----------
        public void Assign(Value value)
        {
            if (value is BooleanValue booleanValue)
                _variables[_index] = booleanValue.Value;
            else
                throw new System.Exception("Cannot assign a non-boolean value to a boolean variable.");
        }


        //! ---------- TO STRING ----------
        public override string ToString()
        {
            return $"L{_index}";
        }
    }
}