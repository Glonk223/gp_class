namespace OurGP.Nodes.Expressions.Assignments
{
    public abstract class Assignment : Expression
    {
        static readonly Dictionary<string, int> possibleTransformations = new(){
            ["BooleanAssignment"] = BooleanAssignment.minDepth,
            ["NumericAssignment"] = NumericAssignment.minDepth,
        };

        internal static new readonly int minDepth = possibleTransformations.Values.Min();


        //! ---------- CONSTRUCTORS ----------
        //* Depth constructor
        protected Assignment(int depth = 0, Node? parent = null)
            : base(depth, parent) { }

        //* Grow constructor
        public static new Assignment Random(int currentDepth, int maxDepth, Node? parent)
        {
            // Console.WriteLine($"Assignment.Grow({currentDepth}, {maxDepth})");
            if (maxDepth - currentDepth < minDepth)
                throw new System.ArgumentException(GrowErrorMessage(currentDepth, maxDepth));

            return GetTransformationType(maxDepth - currentDepth) switch
            {
                "BooleanAssignment" => new BooleanAssignment(currentDepth, maxDepth, parent),
                "NumericAssignment" => new NumericAssignment(currentDepth, maxDepth, parent),
                _ => throw new System.ArgumentException(GrowErrorMessage(currentDepth, maxDepth))
            };
        }

        static string GetTransformationType(int requiredDepth)
        {
            return possibleTransformations.Keys.ToList()[rd.Next(possibleTransformations.Count)];
        }

        static string GrowErrorMessage(int currentDepth, int maxDepth)
        {
            return $"From node Assignment on depth={currentDepth}:\n\tCannot grow Assignment Node of depth={maxDepth - currentDepth},\n\tMinimum depth is {minDepth}";
        }
    }
}