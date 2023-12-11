using OurGP.Nodes.Expressions.Assignments;

namespace OurGP.Nodes.Expressions
{
    public abstract class Expression : Node
    {
        static readonly Dictionary<string, int> possibleTransformations = new(){
            ["Assignment"]     = Assignment.minDepth,
            ["IfStatement"]    = IfStatement.minDepth,
            ["WhileStatement"] = WhileStatement.minDepth,
            ["PrintStatement"] = PrintStatement.minDepth,
            ["ScanStatement"]  = ScanStatement.minDepth,
        };

        internal static new readonly int minDepth = possibleTransformations.Values.Min();

        //! ---------- CONSTRUCTORS ----------
        //* Depth constructor
        protected Expression(int depth = 0, Node? parent = null)
            : base(depth, parent) { }

        //* Grow constructor
        public static new Expression Random(int currentDepth, int maxDepth, Node? parent)
        {
            // Console.WriteLine($"Expression.Grow({currentDepth}, {maxDepth})");
            if (maxDepth - currentDepth < minDepth)
                throw new System.ArgumentException(GrowErrorMessage(currentDepth, maxDepth));

            return GetTransformationType(maxDepth - currentDepth) switch
            {
                "Assignment"     => Assignment.Random(currentDepth, maxDepth, parent),
                "IfStatement"    => new IfStatement(currentDepth, maxDepth, parent),
                "WhileStatement" => new WhileStatement(currentDepth, maxDepth, parent),
                "PrintStatement" => new PrintStatement(currentDepth, maxDepth, parent),
                "ScanStatement"  => new ScanStatement(currentDepth, maxDepth, parent),
                _ => throw new System.ArgumentException(GrowErrorMessage(currentDepth, maxDepth))
            };
        }

        static string GetTransformationType(int requiredDepth)
        {
            var possibleTransformationsFiltered = possibleTransformations.Where(x => x.Value <= requiredDepth).ToDictionary(x => x.Key, x => x.Value).Keys.ToList();
            return possibleTransformationsFiltered[rd.Next(possibleTransformationsFiltered.Count)];
        }

        static string GrowErrorMessage(int currentDepth, int maxDepth)
        {
            return $"From node Expression on depth={currentDepth}:\n\tCannot grow Expression Node of depth={maxDepth - currentDepth},\n\tMinimum depth is {minDepth}";
        }
    }
}