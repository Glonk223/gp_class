using System.Runtime.InteropServices;
using OurGP.Nodes.Values.BooleanValues;

namespace OurGP.Nodes.Expressions
{
    public class IfStatement : Expression
    {
        internal static new readonly int minDepthToLeaf = 4;
        internal static new readonly int maxDepthToLeaf = int.MaxValue;
        private BooleanValue Condition
        {
            get => (BooleanValue)_children[0];
            set => _children[0] = value;
        }
        private ExpressionList Expressions
        {
            get => (ExpressionList)_children[1];
            set => _children[1] = value;
        }


        //! ---------- CONSTRUCTORS ----------
        //* Depth constructor
        public IfStatement(int depth, Node? parent)
            : base(2, depth, parent) { }

        //* Parameterized constructor
        public IfStatement(BooleanValue condition, ExpressionList expressions)
            : base(2)
        {
            Condition = condition;
            Expressions = expressions;
        }

        //* Grow constructor
        public static new IfStatement Grow(int maxDepth, int minDepth = 0, int currentDepth = 0, Node? parent = null)
        {
            // Console.WriteLine($"IfStatement.Grow({currentDepth}, {maxDepth})");
            if (maxDepth - currentDepth < minDepthToLeaf)
                throw new System.ArgumentException(GrowErrorMessage(maxDepth, currentDepth));

            var node = new IfStatement(currentDepth, parent);
            node.Condition = BooleanValue.Grow(maxDepth, minDepth, currentDepth + 1, node);
            node.Expressions = ExpressionList.Grow(maxDepth, minDepth, currentDepth + 1, node);
            return node;
        }
        static string GrowErrorMessage(int maxDepth, int currentDepth)
        {
            return $"From node IfStatement on depth={currentDepth}:\n\tCannot grow IfStatement Node of depth={maxDepth - currentDepth},\n\tMinimum depth is {minDepthToLeaf}";
        }

        //* Copy constructor
        public new IfStatement DeepCopy()
        {
            return new IfStatement(Condition.DeepCopy(), Expressions.DeepCopy());
        }


        //! ---------- PROPERTIES ----------
        public override int MinDepth => Math.Min(Condition.MinDepth, Expressions.MinDepth) + 1;
        public override int MaxDepth => Math.Max(Condition.MaxDepth, Expressions.MaxDepth) + 1;


        //! ---------- METHODS ----------
        public override string ToString(string indent = "")
        {
            return $"{indent}if ({Condition}) {{\n{Expressions.ToString(indent + "  ")}{indent}}}";
        }

        public override Type GetReplacementType(Node child)
        {
            if (child == Condition)
                return typeof(BooleanValue);
            else if (child == Expressions)
                return typeof(ExpressionList);
            else
                throw new System.ArgumentException($"Node {child} is not a child of {this}");
        }
    }
}