namespace OurGP.Nodes.Values.BooleanValues
{
    public class BooleanVariable : BooleanValue, IVariable
    {
        internal static new readonly int minDepth = 1;
        private static readonly int _size = 10;
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
        
        //* Depth constructor
        public BooleanVariable(int depth, Node? parent)
            : base(0, depth, parent) { }

        //* Parameterized constructor
        public BooleanVariable(int index)
            : base(0)
        {
            _index = index;
        }

        //* Grow constructor
        public static new BooleanVariable Grow(int maxDepth, int currentDepth = 0, Node? parent = null)
        {
            // Console.WriteLine($"BooleanVariable.Grow({currentDepth}, {maxDepth})");
            if (maxDepth - currentDepth < minDepth)
                throw new System.ArgumentException(GrowErrorMessage(maxDepth, currentDepth));
            
            return new BooleanVariable(currentDepth, parent)
            {
                _index = GP.rd.Next(_size)
            };
        }
        static string GrowErrorMessage(int maxDepth, int currentDepth)
        {
            return $"From node BooleanVariable on depth={currentDepth}:\n\tCannot grow BooleanVariable Node of depth={maxDepth - currentDepth},\n\tMinimum depth is {minDepth}";
        }

        //* Copy constructor
        public new BooleanVariable DeepCopy()
        {
            return new BooleanVariable(_index);
        }


        //! ---------- PROPERTIES ----------
        public override bool Value => _variables[_index];

        public override int MinDepth => 1;
        public override int MaxDepth => 1;


        //! ---------- METHODS ----------
        public void Assign(Value value)
        {
            if (value is BooleanValue booleanValue)
                _variables[_index] = booleanValue.Value;
            else
                throw new System.Exception("Cannot assign a non-boolean value to a boolean variable.");
        }

        public override string ToString()
        {
            return $"L{_index}";
        }
    }
}