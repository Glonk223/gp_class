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
        protected Expression(int childrenCount, int depth = 0, Node? parent = null)
            : base(childrenCount, depth, parent) { }

        //* Grow constructor
        public static new Expression Grow(int maxDepth, int currentDepth = 0, Node? parent = null)
        {
            // Console.WriteLine($"Expression.Grow({currentDepth}, {maxDepth})");
            if (maxDepth - currentDepth < minDepth)
                throw new System.ArgumentException(GrowErrorMessage(maxDepth, currentDepth));

            return GetTransformationType(maxDepth - currentDepth) switch
            {
                "Assignment"     =>     Assignment.Grow(maxDepth, currentDepth, parent),
                "IfStatement"    =>    IfStatement.Grow(maxDepth, currentDepth, parent),
                "WhileStatement" => WhileStatement.Grow(maxDepth, currentDepth, parent),
                "PrintStatement" => PrintStatement.Grow(maxDepth, currentDepth, parent),
                "ScanStatement"  =>  ScanStatement.Grow(maxDepth, currentDepth, parent),
                _ => throw new System.ArgumentException(GrowErrorMessage(maxDepth, currentDepth))
            };
        }
        static string GetTransformationType(int requiredDepth)
        {
            var possibleTransformationsFiltered = possibleTransformations.Where(x => x.Value <= requiredDepth).ToDictionary(x => x.Key, x => x.Value).Keys.ToList();
            return possibleTransformationsFiltered[GP.rd.Next(possibleTransformationsFiltered.Count)];
        }
        static string GrowErrorMessage(int maxDepth, int currentDepth)
        {
            return $"From node Expression on depth={currentDepth}:\n\tCannot grow Expression Node of depth={maxDepth - currentDepth},\n\tMinimum depth is {minDepth}";
        }

        //* Copy constructor
        public static Expression DeepCopy(Expression other)
        {
            return other switch
            {
                Assignment     =>     Assignment.DeepCopy((Assignment)    other),
                IfStatement    =>    IfStatement.DeepCopy((IfStatement)   other),
                WhileStatement => WhileStatement.DeepCopy((WhileStatement)other),
                PrintStatement => PrintStatement.DeepCopy((PrintStatement)other),
                ScanStatement  =>  ScanStatement.DeepCopy((ScanStatement) other),
                _ => throw new System.ArgumentException($"Cannot copy Expression of type {other.GetType().Name}")
            };
        }
    }
}