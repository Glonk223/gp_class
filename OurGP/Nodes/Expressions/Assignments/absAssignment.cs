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
            : base(2, depth, parent) { }

        //* Grow constructor
        public static new Assignment Grow(int maxDepth, int currentDepth = 0, Node? parent = null)
        {
            // Console.WriteLine($"Assignment.Grow({currentDepth}, {maxDepth})");
            if (maxDepth - currentDepth < minDepth)
                throw new System.ArgumentException(GrowErrorMessage(maxDepth, currentDepth));

            return GetTransformationType(maxDepth - currentDepth) switch
            {
                "BooleanAssignment" => BooleanAssignment.Grow(maxDepth, currentDepth, parent),
                "NumericAssignment" => NumericAssignment.Grow(maxDepth, currentDepth, parent),
                _ => throw new System.ArgumentException(GrowErrorMessage(maxDepth, currentDepth))
            };
        }
        static string GetTransformationType(int requiredDepth)
        {
            return possibleTransformations.Keys.ToList()[GP.rd.Next(possibleTransformations.Count)];
        }
        static string GrowErrorMessage(int maxDepth, int currentDepth)
        {
            return $"From node Assignment on depth={currentDepth}:\n\tCannot grow Assignment Node of depth={maxDepth - currentDepth},\n\tMinimum depth is {minDepth}";
        }
    
        //* Copy constructor
        public static Assignment DeepCopy(Assignment other)
        {
            return other switch
            {
                BooleanAssignment => BooleanAssignment.DeepCopy((BooleanAssignment)other),
                NumericAssignment => NumericAssignment.DeepCopy((NumericAssignment)other),
                _ => throw new System.ArgumentException($"Cannot copy Assignment of type {other.GetType()}")
            };
        }
    }
}