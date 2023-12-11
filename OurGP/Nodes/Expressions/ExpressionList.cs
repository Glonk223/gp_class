namespace OurGP.Nodes.Expressions
{
    public class ExpressionList : Expression
    {
        internal static new readonly int minDepth = 3;
        private Expression _expression;
        private ExpressionList? _expressions = null;


        //! ---------- CONSTRUCTORS ----------
        // TODO: Copy constructor
        // public ExpressionList(ExpressionList expressionList)

        //* Parameterized constructor
        public ExpressionList(Expression expression, ExpressionList? expressions = null)
        {
            _expression = expression;
            _expressions = expressions;
        }

        //* Grow constructor
        public ExpressionList(int currentDepth, int maxDepth, Node? parent)
            : base(currentDepth, parent)
        {
            // Console.WriteLine($"ExpressionList.Grow({currentDepth}, {maxDepth})")
            if (maxDepth-currentDepth < minDepth)
                throw new System.ArgumentException(GrowErrorMessage(currentDepth, maxDepth));
            
            _expression = Expression.Random(currentDepth+1, maxDepth, this);
            
            if (minDepth < maxDepth-currentDepth && 0.5 > rd.NextDouble())
                _expressions = new ExpressionList(currentDepth+1, maxDepth, this);
            else
                _expressions = null;
        }

        static string GrowErrorMessage(int currentDepth, int maxDepth)
        {
            return $"From node ExpressionList on depth={currentDepth}:\n\tCannot grow ExpressionList Node of depth={maxDepth-currentDepth},\n\tMinimum depth is {minDepth}";
        }

        public void Add(Expression expression)
        {
            if (_expressions == null)
                _expressions = new ExpressionList(expression);
            else
                _expressions.Add(expression);
        }


        //! ---------- RUN ----------
        public override void Run()
        {
            _expression.Run();
            _expressions?.Run();
        }


        //! ---------- TO STRING ----------
        public override string ToString(string indent = "")
        {
            return _expression.ToString(indent) + ("\n" + _expressions?.ToString(indent) ?? "");
        }
    }
}