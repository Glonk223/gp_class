
namespace OurGP.Nodes.Values.BooleanValues
{
    public class BooleanConstant : BooleanValue, IConstant
    {
        internal static new readonly int minDepthToLeaf = 1;
        internal static new readonly int maxDepthToLeaf = 1;
        private static readonly bool[] _constants = {true, false};
        private int _index;


        //! ---------- CONSTRUCTORS ----------
        //* Depth constructor
        public BooleanConstant(int depth, Node? parent)
            : base(0, depth, parent) { }

        //* Parameterized constructor
        public BooleanConstant(bool constant)
            : base(0)
        {
            _index = constant ? 0 : 1;
        }
        public BooleanConstant(int index)
            : base(0)
        {
            _index = index;
        }

        //* Grow constructor
        public static new BooleanConstant Grow(int maxDepth, int minDepth = 0, int currentDepth = 0, Node? parent = null)
        {
            // Console.WriteLine($"BooleanConstant.Grow({currentDepth}, {maxDepth})");
            if (maxDepth - currentDepth < minDepthToLeaf)
                throw new System.ArgumentException(GrowErrorMessage(maxDepth, currentDepth));

            return new BooleanConstant(currentDepth, parent)
            {
                _index = GP.rd.Next(2)
            };
        }
        static string GrowErrorMessage(int maxDepth, int currentDepth)
        {
            return $"From node BooleanConstant on depth={currentDepth}:\n\tCannot grow BooleanConstant Node of depth={maxDepth - currentDepth},\n\tMinimum depth is {minDepthToLeaf}";
        }
        
        //* Copy constructor
        public new BooleanConstant DeepCopy()
        {
            return new BooleanConstant(_index);
        }


        //! ---------- PROPERTIES ----------
        public override bool Value => _constants[_index];

        public override int MinDepth => 1;
        public override int MaxDepth => 1;


        //! ---------- METHODS ----------
        public override string ToString()
        {
            return $"{_constants[_index]}";
        }

        public override Type GetReplacementType(Node child)
        {
            throw new System.ArgumentException($"Node {child} is not a child of {this}");
        }
    }
}