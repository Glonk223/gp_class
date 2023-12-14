using OurGP.Nodes.Values.BooleanValues;

namespace OurGP.Nodes.Expressions.Assignments
{
    public class BooleanAssignment : Assignment
    {
        internal static new readonly int minDepth = 2;
        private BooleanVariable Variable
        {
            get => (BooleanVariable)_children[0];
            set => _children[0] = value;
        }
        private BooleanValue Value
        {
            get => (BooleanValue)_children[1];
            set => _children[1] = value;
        }


        //! ---------- CONSTRUCTORS ----------
        //* Depth constructor
        public BooleanAssignment(int depth, Node? parent)
            : base(depth, parent) { }

        //* Parameterized constructor
        public BooleanAssignment(BooleanVariable variable, BooleanValue value)
        {
            Variable = variable;
            Value = value;
        }

        //* Grow constructor
        public static new BooleanAssignment Grow(int maxDepth, int currentDepth = 0, Node? parent = null)
        {
            // Console.WriteLine($"BooleanAssignment: {currentDepth} {maxDepth}");
            if (maxDepth - currentDepth < minDepth)
                throw new System.ArgumentException(GrowErrorMessage(maxDepth, currentDepth));

            var node = new BooleanAssignment(currentDepth, parent);
            node.Variable = BooleanVariable.Grow(maxDepth, currentDepth + 1, node);
            node.Value = BooleanValue.Grow(maxDepth, currentDepth + 1, node);
            return node;
        }
        static string GrowErrorMessage(int maxDepth, int currentDepth)
        {
            return $"From node BooleanAssignment on depth={currentDepth}:\n\tCannot grow BooleanAssignment Node of depth={maxDepth - currentDepth},\n\tMinimum depth is {minDepth}";
        }

        //* Copy constructor
        public new BooleanAssignment DeepCopy()
        {
            return new BooleanAssignment(Variable.DeepCopy(), Value.DeepCopy());
        }


        //! ---------- PROPERTIES ----------
        public override int MinDepth => Math.Min(Variable.MinDepth, Value.MinDepth) + 1;
        public override int MaxDepth => Math.Max(Variable.MaxDepth, Value.MaxDepth) + 1;


        //! ---------- METHODS ----------
        public override void Run()
        {
            Variable.Assign(Value);
        }

        public override string ToString(string indent = "")
        {
            return $"{indent}{Variable} = {Value}";
        }
    }
}