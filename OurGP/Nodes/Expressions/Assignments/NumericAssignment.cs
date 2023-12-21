using OurGP.Nodes.Values.NumericValues;

namespace OurGP.Nodes.Expressions.Assignments
{
    public class NumericAssignment : Assignment
    {
        internal static new readonly int minDepth = 2;
        private NumericVariable Variable
        {
            get => (NumericVariable)_children[0];
            set => _children[0] = value;
        }
        private NumericValue Value
        {
            get => (NumericValue)_children[1];
            set => _children[1] = value;
        }

        
        //! ---------- CONSTRUCTORS ----------
        //* Depth constructor
        public NumericAssignment(int depth, Node? parent)
            : base(depth, parent) { }

        //* Parameterized constructor
        public NumericAssignment(NumericVariable variable, NumericValue value)
        {
            Variable = variable;
            Value = value;
        }

        //* Grow constructor
        public static new NumericAssignment Grow(int maxDepth, int currentDepth = 0, Node? parent = null)
        {
            // Console.WriteLine($"BooleanAssignment: {currentDepth} {maxDepth}");
            if (maxDepth - currentDepth < minDepth)
                throw new System.ArgumentException(GrowErrorMessage(maxDepth, currentDepth));

            var node = new NumericAssignment(currentDepth, parent);
            node.Variable = NumericVariable.Grow(maxDepth, currentDepth + 1, node);
            node.Value = NumericValue.Grow(maxDepth, currentDepth + 1, node);
            return node;
        }
        static string GrowErrorMessage(int maxDepth, int currentDepth)
        {
            return $"From node NumericAssignment on depth={currentDepth}:\n\tCannot grow NumericAssignment Node of depth={maxDepth - currentDepth},\n\tMinimum depth is {minDepth}";
        }

        //* Copy constructor
        public new NumericAssignment DeepCopy()
        {
            return new NumericAssignment(Variable.DeepCopy(), Value.DeepCopy());
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

        public override Type GetReplacementType(Node child)
        {
            if (child == Variable)
                return typeof(NumericVariable);
            else if (child == Value)
                return typeof(NumericValue);
            else
                throw new ArgumentException($"Node {child} is not a child of {this}");
        }
    }
}