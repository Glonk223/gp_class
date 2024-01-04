namespace OurGP.Nodes.Expressions.Assignments
{
    public abstract class Assignment : Expression
    {
        static readonly Dictionary<string, (int, int)> possibleTransformations = new(){
            ["BooleanAssignment"] = (BooleanAssignment.minDepthToLeaf, BooleanAssignment.maxDepthToLeaf),
            ["NumericAssignment"] = (NumericAssignment.minDepthToLeaf, NumericAssignment.maxDepthToLeaf),
        };

        internal static new readonly int minDepthToLeaf = possibleTransformations.Values.Min(x => x.Item1);
        internal static new readonly int maxDepthToLeaf = possibleTransformations.Values.Max(x => x.Item2);


        //! ---------- CONSTRUCTORS ----------
        //* Depth constructor
        protected Assignment(int depth = 0, Node? parent = null)
            : base(2, depth, parent) { }

        //* Grow constructor
        public static new Assignment Grow(int maxDepth, int minDepth = 0, int currentDepth = 0, Node? parent = null)
        {
            int requiredMaxDepth = maxDepth - currentDepth;
            int requiredMinDepth = minDepth - currentDepth;

            // Console.WriteLine($"Assignment.Grow({currentDepth}, {maxDepth})");
            if (requiredMaxDepth < minDepthToLeaf)
                throw new System.ArgumentException(GrowErrorMessage(maxDepth, currentDepth));

            return GetTransformationType(requiredMaxDepth, requiredMinDepth) switch
            {
                "BooleanAssignment" => BooleanAssignment.Grow(maxDepth, minDepth, currentDepth, parent),
                "NumericAssignment" => NumericAssignment.Grow(maxDepth, minDepth, currentDepth, parent),
                _ => throw new System.ArgumentException(GrowErrorMessage(maxDepth, currentDepth))
            };
        }
        static string GetTransformationType(int requiredMaxDepth, int requiredMinDepth)
        {
            var ptFiltered = possibleTransformations
                .Where(x => x.Value.Item1 <= requiredMaxDepth && x.Value.Item2 >= requiredMinDepth)
                .ToDictionary(x => x.Key, x => x.Value).Keys.ToList();
            
            return ptFiltered[GP.rd.Next(ptFiltered.Count)];
        }
        static string GrowErrorMessage(int maxDepth, int currentDepth)
        {
            return $"From node Assignment on depth={currentDepth}:\n\tCannot grow Assignment Node of depth={maxDepth - currentDepth},\n\tMinimum depth is {minDepthToLeaf}";
        }
    
        //* Copy constructor
        public new Assignment DeepCopy()
        {
            return this switch
            {
                BooleanAssignment booleanAssignment => booleanAssignment.DeepCopy(),
                NumericAssignment numericAssignment => numericAssignment.DeepCopy(),
                _ => throw new System.ArgumentException($"Cannot copy Assignment of type {GetType().Name}")
            };
        }
    }
}