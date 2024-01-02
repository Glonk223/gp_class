using OurGP.Nodes.Values.BooleanValues;

namespace OurGP.Nodes.Expressions
{
    public class WhileStatement : Expression
    {
        internal static new readonly int minDepth = 4;
        private BooleanValue Condition
        {
            get => (BooleanValue)_children[0];
            set => _children[0] = value;
        }
        private ExpressionList Block
        {
            get => (ExpressionList)_children[1];
            set => _children[1] = value;
        }

        
        //! ---------- CONSTRUCTORS ----------
        //* Depth constructor
        public WhileStatement(int depth, Node? parent)
            : base(2, depth, parent) { }

        //* Parameterized constructor
        public WhileStatement(BooleanValue condition, ExpressionList block)
            : base(2)
        {
            Condition = condition;
            Block = block;
        }

        //* Grow constructor
        public static new WhileStatement Grow(int maxDepth, int currentDepth = 0, Node? parent = null)
        {
            // Console.WriteLine($"IfStatement.Grow({currentDepth}, {maxDepth})");
            if (maxDepth - currentDepth < minDepth)
                throw new System.ArgumentException(GrowErrorMessage(maxDepth, currentDepth));
            
            var node = new WhileStatement(currentDepth, parent);
            node.Condition = BooleanValue.Grow(maxDepth, currentDepth + 1, node);
            node.Block = ExpressionList.Grow(maxDepth, currentDepth + 1, node);
            return node;
        }
        static string GrowErrorMessage(int maxDepth, int currentDepth)
        {
            return $"From node WhileStatement on depth={currentDepth}:\n\tCannot grow WhileStatement Node of depth={maxDepth - currentDepth},\n\tMinimum depth is {minDepth}";
        }

        //* Copy constructor
        public new WhileStatement DeepCopy()
        {
            return new WhileStatement(Condition.DeepCopy(), Block.DeepCopy());
        }


        //! ---------- PROPERTIES ----------
        public override int MinDepth => Math.Min(Condition.MinDepth, Block.MinDepth) + 1;
        public override int MaxDepth => Math.Max(Condition.MaxDepth, Block.MaxDepth) + 1;


        //! ---------- METHODS ----------
        public override string ToString(string indent = "")
        {
            return $"{indent}while ({Condition}) {{\n{Block.ToString(indent + "  ")}{indent}}}";
        }

        public override Type GetReplacementType(Node child)
        {
            if (child == Condition)
                return typeof(BooleanValue);
            else if (child == Block)
                return typeof(ExpressionList);
            else
                throw new System.ArgumentException($"Node {child} is not a child of {this}");
        }
    }
}