namespace OurGP.Nodes.Values.NumericValues
{
    public abstract class NumericValue : Value
    {
        static readonly Dictionary<string, int> possibleTransformations = new(){
            ["ArithmeticOperation"] = ArithmeticOperation.minDepth,
            ["NumericConstant"] = NumericConstant.minDepth,
            ["NumericNegation"] = NumericNegation.minDepth,
            ["NumericVariable"] = NumericVariable.minDepth,
        };

        internal static new readonly int minDepth = possibleTransformations.Values.Min();


        //! ---------- CONSTRUCTORS ----------
        //* Depth constructor
        protected NumericValue(int depth = 0, Node? parent = null)
            : base(depth, parent) { }

        //* Grow constructor
        public static new NumericValue Random(int currentDepth, int maxDepth, Node? parent)
        {
            // Console.WriteLine($"NumericValue.Grow({currentDepth}, {maxDepth})");
            if (maxDepth-currentDepth < minDepth)
                throw new System.ArgumentException(GrowErrorMessage(currentDepth, maxDepth));

            return GetTransformationType(maxDepth-currentDepth) switch
            {
                "ArithmeticOperation" => new ArithmeticOperation(currentDepth, maxDepth, parent),
                "NumericConstant"     => new NumericConstant(currentDepth, maxDepth, parent),
                "NumericNegation"     => new NumericNegation(currentDepth, maxDepth, parent),
                "NumericVariable"     => new NumericVariable(currentDepth, maxDepth, parent),
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
            return $"From node NumericValue on depth={currentDepth}:\n\tCannot grow NumericValue Node of depth={maxDepth - currentDepth},\n\tMinimum depth is {minDepth}";
        }


        //! ---------- EVALUATION ----------
        public abstract double Value { get; }


        //! ---------- METHODS ----------
        public override void Run()
        {
            // Do nothing
        }
    }
}