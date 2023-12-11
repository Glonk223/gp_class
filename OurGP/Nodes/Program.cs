using System.Runtime.InteropServices;
using OurGP.Nodes.Expressions;
using OurGP.Nodes.Expressions.Assignments;
using OurGP.Nodes.Values;
using OurGP.Nodes.Values.BooleanValues;
using OurGP.Nodes.Values.NumericValues;

namespace OurGP.Nodes
{
    public class Program : Node
    {
        internal static new readonly int minDepth = 4;
        private ExpressionList _expressions;


        //! ---------- CONSTRUCTORS ----------
        //* Copy constructor
        // public Program(Program program)
        // {
        //     return program.DeepCopy();
        // }

        //* Parameterized constructor
        public Program(ExpressionList expressions)
        {
            _expressions = expressions;
        }

        //* Grow constructor
        public Program(int maxDepth)
            : this(0, maxDepth, null) { }

        public Program(int currentDepth, int maxDepth, Node? parent)
            : base(currentDepth, parent)
        {
            // Console.WriteLine($"Program.Grow({currentDepth}, {maxDepth})");
            if (maxDepth-currentDepth < minDepth)
                throw new System.ArgumentException(GrowErrorMessage(currentDepth, maxDepth));
            
            _expressions = new ExpressionList(currentDepth+1, maxDepth, this);
        }

        static string GrowErrorMessage(int currentDepth, int maxDepth)
        {
            return $"From node Program on depth={currentDepth}:\n\tCannot grow Program Node of depth={maxDepth-currentDepth},\n\tMinimum depth is {minDepth}";
        }


        public static void PrintMinDepth()
        {
            Console.WriteLine($"abs Node.minDepth = {Node.minDepth}");
            Console.WriteLine($"  Program.minDepth = {Program.minDepth}");
            Console.WriteLine($"  ExpressionList.minDepth = {ExpressionList.minDepth}");
            Console.WriteLine($"  abs Expression.minDepth = {Expression.minDepth}");
            Console.WriteLine($"    IfStatement.minDepth = {IfStatement.minDepth}");
            Console.WriteLine($"    WhileStatement.minDepth = {WhileStatement.minDepth}");
            Console.WriteLine($"    abs Assignment.minDepth = {Assignment.minDepth}");
            Console.WriteLine($"      NumericAssignment.minDepth = {NumericAssignment.minDepth}");
            Console.WriteLine($"      BooleanAssignment.minDepth = {BooleanAssignment.minDepth}");
            Console.WriteLine($"    PrintStatement.minDepth = {PrintStatement.minDepth}");
            Console.WriteLine($"    ScanStatement.minDepth = {ScanStatement.minDepth}");
            Console.WriteLine($"  abs Value.minDepth = {Value.minDepth}");
            Console.WriteLine($"    abs BooleanValue.minDepth = {BooleanValue.minDepth}");
            Console.WriteLine($"      ComparisonOperation.minDepth = {ComparisonOperation.minDepth}");
            Console.WriteLine($"      LogicOperation.minDepth = {LogicOperation.minDepth}");
            Console.WriteLine($"      BooleanNegation.minDepth = {BooleanNegation.minDepth}");
            Console.WriteLine($"      BooleanConstant.minDepth = {BooleanConstant.minDepth}");
            Console.WriteLine($"      BooleanVariable.minDepth = {BooleanVariable.minDepth}");
            Console.WriteLine($"    abs NumericValue.minDepth = {NumericValue.minDepth}");
            Console.WriteLine($"      ArithmeticOperation.minDepth = {ArithmeticOperation.minDepth}");
            Console.WriteLine($"      NumericNegation.minDepth = {NumericNegation.minDepth}");
            Console.WriteLine($"      NumericConstant.minDepth = {NumericConstant.minDepth}");
            Console.WriteLine($"      NumericVariable.minDepth = {NumericVariable.minDepth}");
        }


        //! ---------- RUN ----------
        public override void Run()
        {
            _expressions.Run();
        }


        //! ---------- TO STRING ----------
        public override string ToString(string indent = "")
        {
            return _expressions.ToString(indent);
        }
    }
}