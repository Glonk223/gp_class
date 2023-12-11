namespace OurGP.Nodes.Values.BooleanValues
{
    public abstract class BooleanValue : Value
    {
        static readonly Dictionary<string, int> possibleTransformations = new(){
            ["BooleanConstant"] = BooleanConstant.minDepth,
            ["BooleanNegation"] = BooleanNegation.minDepth,
            ["BooleanVariable"] = BooleanVariable.minDepth,
            ["ComparisonOperation"] = ComparisonOperation.minDepth,
            ["LogicOperation"] = LogicOperation.minDepth,
        };

        internal static new readonly int minDepth = possibleTransformations.Values.Min();

        //! ---------- CONSTRUCTORS ----------
        //* Depth constructor
        protected BooleanValue(int depth = 0, Node? parent = null)
            : base(depth, parent) { }
        //* Grow constructor
        public static new BooleanValue Random(int currentDepth, int maxDepth, Node? parent)
        {
            // Console.WriteLine($"BooleanValue.Grow({currentDepth}, {maxDepth})");
            if (maxDepth - currentDepth < minDepth)
                throw new System.ArgumentException(GrowErrorMessage(currentDepth, maxDepth));

            return GetTransformationType(maxDepth - currentDepth) switch
            {
                "BooleanConstant"     => new BooleanConstant(currentDepth, maxDepth, parent),
                "BooleanNegation"     => new BooleanNegation(currentDepth, maxDepth, parent),
                "BooleanVariable"     => new BooleanVariable(currentDepth, maxDepth, parent),
                "ComparisonOperation" => new ComparisonOperation(currentDepth, maxDepth, parent),
                "LogicOperation"      => new LogicOperation(currentDepth, maxDepth, parent),
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
            return $"From node BooleanValue on depth={currentDepth}:\n\tCannot grow BooleanValue Node of depth={maxDepth - currentDepth},\n\tMinimum depth is {minDepth}";
        }
        
        
        //! ---------- EVALUATION ----------
        public abstract bool Value { get; }


        //! ---------- RUN ----------
        public override void Run()
        {
            // Do nothing
        }
    }
}