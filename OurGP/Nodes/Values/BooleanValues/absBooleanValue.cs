using OurGP.Nodes.Values.NumericValues;

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
        protected BooleanValue(int childrenCount, int depth = 0, Node? parent = null)
            : base(childrenCount, depth, parent) { }
        
        //* Grow constructor
        public static new BooleanValue Grow(int maxDepth, int currentDepth = 0, Node? parent = null)
        {
            // Console.WriteLine($"BooleanValue.Grow({currentDepth}, {maxDepth})");
            if (maxDepth - currentDepth < minDepth)
                throw new System.ArgumentException(GrowErrorMessage(maxDepth, currentDepth));

            return GetTransformationType(maxDepth - currentDepth, parent) switch
            {
                "BooleanConstant"     =>     BooleanConstant.Grow(maxDepth, currentDepth, parent),
                "BooleanNegation"     =>     BooleanNegation.Grow(maxDepth, currentDepth, parent),
                "BooleanVariable"     =>     BooleanVariable.Grow(maxDepth, currentDepth, parent),
                "ComparisonOperation" => ComparisonOperation.Grow(maxDepth, currentDepth, parent),
                "LogicOperation"      =>      LogicOperation.Grow(maxDepth, currentDepth, parent),
                _ => throw new System.ArgumentException(GrowErrorMessage(maxDepth, currentDepth))
            };
        }
        static string GetTransformationType(int requiredDepth, Node? parent = null)
        {
            var psFiltered =
                possibleTransformations
                    .Where(x => x.Value <= requiredDepth)
                    .ToDictionary(x => x.Key, x => x.Value)
                    .Keys.ToList();
            
            if (parent is not BooleanNegation)
                return psFiltered[GP.rd.Next(psFiltered.Count)];
            return psFiltered.Where(x => x != "BooleanNegation").ToList()[GP.rd.Next(psFiltered.Count - 1)];
        }
        static string GrowErrorMessage(int maxDepth, int currentDepth)
        {
            return $"From node BooleanValue on depth={currentDepth}:\n\tCannot grow BooleanValue Node of depth={maxDepth - currentDepth},\n\tMinimum depth is {minDepth}";
        }

        //* Copy constructor
        public new BooleanValue DeepCopy()
        {
            return this switch
            {
                BooleanConstant         booleanConstant =>     booleanConstant.DeepCopy(),
                BooleanNegation         booleanNegation =>     booleanNegation.DeepCopy(),
                BooleanVariable         booleanVariable =>     booleanVariable.DeepCopy(),
                ComparisonOperation comparisonOperation => comparisonOperation.DeepCopy(),
                LogicOperation           logicOperation =>      logicOperation.DeepCopy(),
                _ => throw new System.ArgumentException($"Cannot copy BooleanValue of type {GetType().Name}")
            };
        }

        
        //! ---------- PROPERTIES ----------
        public abstract bool Value { get; }
    }
}