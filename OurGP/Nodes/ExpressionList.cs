using System.Reflection.Metadata.Ecma335;
using OurGP.Nodes.Expressions;

namespace OurGP.Nodes
{
    public class ExpressionList : Node
    {
        internal static new readonly int minDepth = 3;
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
        public static new ExpressionList Grow(int maxDepth, int currentDepth = 0, Node? parent = null)
        {
            // Console.WriteLine($"ExpressionList.Grow({currentDepth}, {maxDepth})")
            if (maxDepth-currentDepth < minDepth)
                throw new System.ArgumentException(GrowErrorMessage(maxDepth, currentDepth));
            
            ExpressionList node;
            if (minDepth < maxDepth-currentDepth && 0.5 > GP.rd.NextDouble())
            {
                node = new ExpressionList(2, currentDepth, parent);
                node.Expression = Expression.Grow(maxDepth, currentDepth+1, node);
                node.Expressions = ExpressionList.Grow(maxDepth, currentDepth+1, node);
            }
            else
            {
                node = new ExpressionList(1, currentDepth, parent);
                node.Expression = Expression.Grow(maxDepth, currentDepth+1, node);
            }
            return node;
        }
        static string GrowErrorMessage(int maxDepth, int currentDepth)
        {
            return $"From node ExpressionList on depth={currentDepth}:\n\tCannot grow ExpressionList Node of depth={maxDepth-currentDepth},\n\tMinimum depth is {minDepth}";
        }

        //* Copy constructor
        public static ExpressionList DeepCopy(ExpressionList other)
        {
            return new ExpressionList(Expression.DeepCopy(other.Expression),
                                      other.Expressions == null ? null : DeepCopy(other.Expressions));
        }
        

        //! ---------- PROPERTIES ----------
        // if _expressions is null, then consider it to py one child node and calculate only the depth of _expression then the MinDepth and MaxDepth are the same
        public override int MinDepth => Math.Min(Expression.MinDepth, Expressions?.MinDepth ?? int.MaxValue) + 1;
        public override int MaxDepth => Math.Max(Expression.MaxDepth, Expressions?.MaxDepth ?? int.MinValue) + 1;


        //! ---------- METHODS ----------
        public override void Run()
        {
            Expression.Run();
            Expressions?.Run();
        }

        public override string ToString(string indent = "")
        {
            return Expression.ToString(indent) + ("\n" + Expressions?.ToString(indent) ?? "");
        }
    }
}