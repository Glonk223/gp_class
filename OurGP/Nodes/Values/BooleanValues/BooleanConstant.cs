namespace OurGP.Nodes.Values.BooleanValues
{
    public class BooleanConstant : BooleanValue, IConstant
    {
        internal static new readonly int minDepth = 1;
        private static readonly bool[] _constants = {true, false};
        private int _index;


        //! ---------- CONSTRUCTORS ----------
        // TODO: Copy constructor
        // public BooleanConstant(BooleanConstant booleanConstant)
        
        //* Parameterized constructor
        public BooleanConstant(int index)
        {
            _index = index;
        }

        //* Grow constructor
        public BooleanConstant(int currentDepth, int maxDepth, Node? parent)
            : base(currentDepth, parent)
        {
            // Console.WriteLine($"BooleanConstant.Grow({currentDepth}, {maxDepth})");
            if (maxDepth - currentDepth < minDepth)
                throw new System.ArgumentException(GrowErrorMessage(currentDepth, maxDepth));

            _index = rd.Next(2);
        }

        static string GrowErrorMessage(int currentDepth, int maxDepth)
        {
            return $"From node BooleanConstant on depth={currentDepth}:\n\tCannot grow BooleanConstant Node of depth={maxDepth - currentDepth},\n\tMinimum depth is {minDepth}";
        }
        
        
        //! ---------- EVALUATION ----------
        public override bool Value => _constants[_index];


        //! ---------- TO STRING ----------
        public override string ToString()
        {
            return $"{_constants[_index]}";
        }
    }
}