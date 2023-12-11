using OurGP.Nodes.Values.BooleanValues;

namespace OurGP.Nodes.Expressions
{
    public class IfStatement : Expression
    {
        internal static new readonly int minDepth = 4;
        private BooleanValue _condition;
        private ExpressionList _expressions;


        //! ---------- CONSTRUCTORS ----------
        // TODO: Copy constructor
        // public IfStatement(IfStatement ifStatement)

        //* Parameterized constructor
        public IfStatement(BooleanValue condition, ExpressionList expressions)
        {
            _condition = condition;
            _expressions = expressions;
        }

        //* Grow constructor
        public IfStatement(int currentDepth, int maxDepth, Node? parent)
            : base(currentDepth, parent)
        {
            // Console.WriteLine($"IfStatement.Grow({currentDepth}, {maxDepth})");
            if (maxDepth - currentDepth < minDepth)
                throw new System.ArgumentException(GrowErrorMessage(currentDepth, maxDepth));

            _condition = BooleanValue.Random(currentDepth + 1, maxDepth, this);
            _expressions = new ExpressionList(currentDepth + 1, maxDepth, this);
        }

        static string GrowErrorMessage(int currentDepth, int maxDepth)
        {
            return $"From node IfStatement on depth={currentDepth}:\n\tCannot grow IfStatement Node of depth={maxDepth - currentDepth},\n\tMinimum depth is {minDepth}";
        }


        //! ---------- RUN ----------
        public override void Run()
        {
            if (_condition.Value)
            {
                _expressions.Run();
            }
        }


        //! ---------- TO STRING ----------
        public override string ToString(string indent = "")
        {
            return $"{indent}if ({_condition}) {{\n{_expressions.ToString(indent + "  ")}{indent}}}";
        }
    }
}