using OurGP.Nodes.Values.NumericValues;

namespace OurGP.Nodes.Values.BooleanValues
{
    public abstract class BooleanValue : Value
    {
        static readonly Dictionary<string, (int, int)> possibleTransformations = new(){
            ["BooleanConstant"]     = (    BooleanConstant.minDepthToLeaf,     BooleanConstant.maxDepthToLeaf),
            ["BooleanNegation"]     = (    BooleanNegation.minDepthToLeaf,     BooleanNegation.maxDepthToLeaf),
            ["BooleanVariable"]     = (    BooleanVariable.minDepthToLeaf,     BooleanVariable.maxDepthToLeaf),
            ["ComparisonOperation"] = (ComparisonOperation.minDepthToLeaf, ComparisonOperation.maxDepthToLeaf),
            ["LogicOperation"]      = (     LogicOperation.minDepthToLeaf,      LogicOperation.maxDepthToLeaf),
        };

        internal static new readonly int minDepthToLeaf = possibleTransformations.Values.Min(x => x.Item1);
        internal static new readonly int maxDepthToLeaf = possibleTransformations.Values.Max(x => x.Item2);


        //! ---------- CONSTRUCTORS ----------
        //* Depth constructor
        protected BooleanValue(int childrenCount, int depth = 0, Node? parent = null)
            : base(childrenCount, depth, parent) { }
        
        //* Grow constructor
        public static new BooleanValue Grow(int maxDepth, int minDepth = 0, int currentDepth = 0, Node? parent = null)
        {
            int requiredMaxDepth = maxDepth - currentDepth;
            int requiredMinDepth = minDepth - currentDepth;

            // Console.WriteLine($"BooleanValue.Grow({currentDepth}, {maxDepth})");
            if (requiredMaxDepth < minDepthToLeaf)
                throw new System.ArgumentException(GrowErrorMessage(maxDepth, currentDepth));

            return GetTransformationType(requiredMaxDepth, requiredMinDepth, parent) switch
            {
                "BooleanConstant"     =>     BooleanConstant.Grow(maxDepth, minDepth, currentDepth, parent),
                "BooleanNegation"     =>     BooleanNegation.Grow(maxDepth, minDepth, currentDepth, parent),
                "BooleanVariable"     =>     BooleanVariable.Grow(maxDepth, minDepth, currentDepth, parent),
                "ComparisonOperation" => ComparisonOperation.Grow(maxDepth, minDepth, currentDepth, parent),
                "LogicOperation"      =>      LogicOperation.Grow(maxDepth, minDepth, currentDepth, parent),
                _ => throw new System.ArgumentException(GrowErrorMessage(maxDepth, currentDepth))
            };
        }
        static string GetTransformationType(int requiredMaxDepth, int requiredMinDepth, Node? parent = null)
        {
            var ptFiltered = possibleTransformations
                    .Where(x => x.Value.Item1 <= requiredMaxDepth && x.Value.Item2 >= requiredMinDepth)
                    .ToDictionary(x => x.Key, x => x.Value).Keys.ToList();
            
            if (parent is not BooleanNegation)
                return ptFiltered[GP.rd.Next(ptFiltered.Count)];
            return ptFiltered.Where(x => x != "BooleanNegation").ToList()[GP.rd.Next(ptFiltered.Count - 1)];
        }
        static string GrowErrorMessage(int maxDepth, int currentDepth)
        {
            return $"From node BooleanValue on depth={currentDepth}:\n\tCannot grow BooleanValue Node of depth={maxDepth - currentDepth},\n\tMinimum depth is {minDepthToLeaf}";
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