using OurGP.Nodes.Values.BooleanValues;

namespace OurGP.Nodes.Expressions
{
    public class WhileStatement : Expression
    {
        internal static new readonly int minDepth = 4;
        private BooleanValue _condition;
        private ExpressionList _block;

        
        //! ---------- CONSTRUCTORS ----------
        // TODO: Copy constructor
        // public WhileStatement(WhileStatement whileStatement)

        //* Parameterized constructor
        public WhileStatement(BooleanValue condition, ExpressionList block, int depth = 0) : base(depth)
        {
            _condition = condition;
            _block = block;
        }

        //* Grow constructor
        public WhileStatement(int currentDepth, int maxDepth, Node? parent)
            : base(currentDepth, parent)
        {
            // Console.WriteLine($"IfStatement.Grow({currentDepth}, {maxDepth})");
            if (maxDepth - currentDepth < minDepth)
                throw new System.ArgumentException(GrowErrorMessage(currentDepth, maxDepth));

            _condition = BooleanValue.Random(currentDepth + 1, maxDepth, this);
            _block = new ExpressionList(currentDepth + 1, maxDepth, this);
        }

        static string GrowErrorMessage(int currentDepth, int maxDepth)
        {
            return $"From node WhileStatement on depth={currentDepth}:\n\tCannot grow WhileStatement Node of depth={maxDepth - currentDepth},\n\tMinimum depth is {minDepth}";
        }


        //! ---------- RUN ----------
        public override void Run()
        {
            while (_condition.Value)
                _block.Run();
        }


        //! ---------- TO STRING ----------
        public override string ToString(string indent = "")
        {
            return $"{indent}while ({_condition}) {{\n{_block.ToString(indent + "  ")}{indent}}}";
        }
    }
}