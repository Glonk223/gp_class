using OurGP.Nodes.Expressions;

namespace OurGP.Nodes
{
    public class ExpressionList : Node
    {
        internal static new readonly int minDepthToLeaf = 3;
        internal static new readonly int maxDepthToLeaf = int.MaxValue;
        private Expression Expression
        {
            get => (Expression)_children[0];
            set => _children[0] = value;
        }
        private ExpressionList? Expressions
        {
            get => _children.Length > 1 ? (ExpressionList)_children[1] : null;
            set
            {
                if (_children.Length > 1)
                    _children[1] = value!;
                else if (value != null)
                    throw new ArgumentException("Cannot set Expressions (grammar right recursion) when _children.Length == 1");
            }
        }


        //! ---------- CONSTRUCTORS ----------
        //* Depth constructor
        public ExpressionList(int childrenCount, int depth, Node? parent)
            : base(childrenCount, depth, parent) { }

        //* Parameterized constructor
        public ExpressionList(Expression expression, ExpressionList? expressions = null)
            : base(expressions != null ? 2 : 1)
        {
            Expression = expression;
            Expressions = expressions;
        }

        //* Grow constructor
        public static new ExpressionList Grow(int maxDepth, int minDepth = 0, int currentDepth = 0, Node? parent = null)
        {
            // Console.WriteLine($"ExpressionList.Grow({currentDepth}, {maxDepth})")
            if (maxDepth - currentDepth < minDepthToLeaf)
                throw new System.ArgumentException(GrowErrorMessage(maxDepth, currentDepth));

            ExpressionList node;
            if (minDepthToLeaf < maxDepth - currentDepth && 0.5 > GP.rd.NextDouble())
            {
                node = new ExpressionList(2, currentDepth, parent);
                node.Expression = Expression.Grow(maxDepth, minDepth, currentDepth + 1, node);
                node.Expressions = ExpressionList.Grow(maxDepth, minDepth, currentDepth + 1, node);
            }
            else
            {
                node = new ExpressionList(1, currentDepth, parent);
                node.Expression = Expression.Grow(maxDepth, minDepth, currentDepth + 1, node);
            }
            return node;
        }
        static string GrowErrorMessage(int maxDepth, int currentDepth)
        {
            return $"From node ExpressionList on depth={currentDepth}:\n\tCannot grow ExpressionList Node of depth={maxDepth - currentDepth},\n\tMinimum depth is {minDepthToLeaf}";
        }

        //* Copy constructor
        public ExpressionList DeepCopy()
        {
            return new ExpressionList(Expression.DeepCopy(), Expressions?.DeepCopy());
        }


        //! ---------- PROPERTIES ----------
        // if _expressions is null, then consider it to py one child node and calculate only the depth of _expression then the MinDepth and MaxDepth are the same
        public override int MinDepth => Math.Min(Expression.MinDepth, Expressions?.MinDepth ?? int.MaxValue) + 1;
        public override int MaxDepth => Math.Max(Expression.MaxDepth, Expressions?.MaxDepth ?? int.MinValue) + 1;


        //! ---------- METHODS ----------
        public override string ToString(string indent = "")
        {
            return Expression.ToString(indent) + ("\n" + Expressions?.ToString(indent) ?? "");
        }

        public override Type GetReplacementType(Node child)
        {
            if (child == Expression)
                return typeof(Expression);
            else if (child == Expressions)
                return typeof(ExpressionList);
            else
                throw new ArgumentException($"Node {child} is not a child of {this}");
        }
    }
}