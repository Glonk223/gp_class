using OurGP.Nodes.Expressions.Assignments;

namespace OurGP.Nodes.Expressions
{
    public abstract class Expression : Node
    {
        static readonly Dictionary<string, (int, int)> possibleTransformations = new(){
            ["Assignment"]     = (    Assignment.minDepthToLeaf,     Assignment.maxDepthToLeaf),
            ["IfStatement"]    = (   IfStatement.minDepthToLeaf,    IfStatement.maxDepthToLeaf),
            ["WhileStatement"] = (WhileStatement.minDepthToLeaf, WhileStatement.maxDepthToLeaf),
            ["PrintStatement"] = (PrintStatement.minDepthToLeaf, PrintStatement.maxDepthToLeaf),
            ["ScanStatement"]  = ( ScanStatement.minDepthToLeaf,  ScanStatement.maxDepthToLeaf),
        };

        internal static new readonly int minDepthToLeaf = possibleTransformations.Values.Min(x => x.Item1);
        internal static new readonly int maxDepthToLeaf = possibleTransformations.Values.Max(x => x.Item2);


        //! ---------- CONSTRUCTORS ----------
        //* Depth constructor
        protected Expression(int childrenCount, int depth = 0, Node? parent = null)
            : base(childrenCount, depth, parent) { }

        //* Grow constructor
        public static new Expression Grow(int maxDepth, int minDepth = 0, int currentDepth = 0, Node? parent = null)
        {
            int requiredMaxDepth = maxDepth - currentDepth;
            int requiredMinDepth = minDepth - currentDepth;

            // Console.WriteLine($"Expression.Grow({currentDepth}, {maxDepth})");
            if (requiredMaxDepth < minDepthToLeaf)
                throw new System.ArgumentException(GrowErrorMessage(maxDepth, currentDepth));

            return GetTransformationType(requiredMaxDepth, requiredMinDepth) switch
            {
                "Assignment"     =>     Assignment.Grow(maxDepth, minDepth, currentDepth, parent),
                "IfStatement"    =>    IfStatement.Grow(maxDepth, minDepth, currentDepth, parent),
                "WhileStatement" => WhileStatement.Grow(maxDepth, minDepth, currentDepth, parent),
                "PrintStatement" => PrintStatement.Grow(maxDepth, minDepth, currentDepth, parent),
                "ScanStatement"  =>  ScanStatement.Grow(maxDepth, minDepth, currentDepth, parent),
                _ => throw new System.ArgumentException(GrowErrorMessage(maxDepth, currentDepth))
            };
        }
        static string GetTransformationType(int requiredMaxDepth, int requiredMinDepth)
        {
            var psFiltered = possibleTransformations
                .Where(x => x.Value.Item1 <= requiredMaxDepth && x.Value.Item2 >= requiredMinDepth)
                .ToDictionary(x => x.Key, x => x.Value).Keys.ToList();
            
            return psFiltered[GP.rd.Next(psFiltered.Count)];
        }
        static string GrowErrorMessage(int maxDepth, int currentDepth)
        {
            return $"From node Expression on depth={currentDepth}:\n\tCannot grow Expression Node of depth={maxDepth - currentDepth},\n\tMinimum depth is {minDepthToLeaf}";
        }

        //* Copy constructor
        public Expression DeepCopy()
        {
            return this switch
            {
                Assignment         assignment =>     assignment.DeepCopy(),
                IfStatement       ifStatement =>    ifStatement.DeepCopy(),
                WhileStatement whileStatement => whileStatement.DeepCopy(),
                PrintStatement printStatement => printStatement.DeepCopy(),
                ScanStatement   scanStatement =>  scanStatement.DeepCopy(),
                _ => throw new System.ArgumentException($"Cannot copy Expression of type {GetType().Name}")
            };
        }
    }
}