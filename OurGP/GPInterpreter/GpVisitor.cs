using System.Runtime.InteropServices;
using System.Security.Principal;
using Antlr4.Runtime.Tree;
using GPInterpreter;

namespace GPInterpreter;

public class GpVisitor : GramBaseVisitor<Value>
{
    private List<double> _numVariables = Enumerable.Repeat(0.0, 10).ToList();
    private List<bool> _boolVariables = Enumerable.Repeat(false, 10).ToList();
    public static int operations;
    public  int maxOperations;
    private InOutVector _ioVector;
    public bool printFlag = false;

    public InOutVector ourVisit(IParseTree tree)
    {
        try
        {
            Visit(tree);
        }
        catch (RuntimeInstructions e)
        {
            // Console.WriteLine(e.Message);
            return _ioVector;
        }

        return _ioVector;
    }

    public void handleOperations()
    {
        operations++;
        if (operations > maxOperations)
        {
            throw new RuntimeInstructions("Too many operations!");
        }
    }

    public GpVisitor(List<Value> input, int maxOperations)
    {
        operations = 0;
        this.maxOperations = maxOperations;
        _ioVector = new InOutVector(input);
    }
    
    public override Value VisitIf_statement(GramParser.If_statementContext context)
    {
        if (Visit(context.bool_value()).GetBool())
        {
            handleOperations();
            return Visit(context.expressions());
        }
        else
        {
            return new Value(Visit(context.bool_value()).GetBool());
        }
    }

    public override Value VisitWhile_loop(GramParser.While_loopContext context)
    {
        while (Visit(context.bool_value()).GetBool())
        {
            handleOperations();
            Visit(context.expressions());
        }
        return new Value(Visit(context.bool_value()).GetBool());
    }

    public override Value VisitPrintNum(GramParser.PrintNumContext context)
    {
        handleOperations();
        printFlag = true;
        Value val = Visit(context.numeric_value());
        printFlag = false;
        _ioVector.Add(val);
        return val;
    }

    public override Value VisitPrintBool(GramParser.PrintBoolContext context)
    {
        handleOperations();
        printFlag = true;
        Value val = Visit(context.bool_value());
        printFlag = false;
        _ioVector.Add(val);
        return val;
    }

    public override Value VisitScanNum(GramParser.ScanNumContext context)
    {
        handleOperations();
        if (_ioVector.input.Count == 0)
            return new Value(0);

        string varName = context.NUM_VAR().GetText();
        int varNum = varName[1] - '0';
        _numVariables[varNum] = _ioVector.Read().GetNum();
        _ioVector.scanned[varNum] = true;
        return new Value(_numVariables[varNum]);
    }

    public override Value VisitScanBool(GramParser.ScanBoolContext context)
    {
        handleOperations();
        if (_ioVector.input.Count == 0)
            return new Value(0);
        
        string varName = context.BOOL_VAR().GetText();
        int varNum = varName[1] - '0';
        _boolVariables[varNum] = _ioVector.Read().GetBool();
        // _ioVector.scanned[varNum+10] = true;
        return new Value(_numVariables[varNum]);
    }

    public override Value VisitAssignNum(GramParser.AssignNumContext context)
    {
        handleOperations();
        string varName = context.NUM_VAR().GetText();
        int varNum = varName[1] - '0';
        _numVariables[varNum] = Visit(context.numeric_value()).GetNum();
        // _ioVector.scanned[varNum] = true;
        return new Value(_numVariables[varNum]);
    }

    public override Value VisitAssignBool(GramParser.AssignBoolContext context)
    {
        handleOperations();
        string varName = context.BOOL_VAR().GetText();
        int varNum = varName[1] - '0';
        _boolVariables[varNum] = Visit(context.bool_value()).GetBool();
        // _ioVector.scanned[varNum] = true;
        return new Value(_boolVariables[varNum]);
    }
    
    public override Value VisitBoolVarVal(GramParser.BoolVarValContext context)
    {
        string varName = context.BOOL_VAR().GetText();
        int varNum = varName[1] - '0';
        // if(printFlag && _ioVector.scanned[varNum+10])
        //     _ioVector.used[varNum+10]++;
        // else if(printFlag)
        //     _ioVector.used[varNum+10]--;

        // if(printFlag && !_ioVector.scanned[varNum+10])
        //     _ioVector.used[varNum+10]--;

        if(!_ioVector.scanned[varNum+10])
            _ioVector.used[varNum+10]--;

        return new Value(_boolVariables[varNum]);
    }
    
    public override Value VisitTrueVal(GramParser.TrueValContext context)
    {
        return new Value(true);
    }

    public override Value VisitFalseVal(GramParser.FalseValContext context)
    {
        return new Value(false);
    }

    public override Value VisitNotVal(GramParser.NotValContext context)
    {
        return Value.Not(Visit(context.bool_value()));
    }

    public override Value VisitNumVal(GramParser.NumValContext context)
    {
        return new Value(Double.Parse(context.NUMBER().GetText()));
    }

    public override Value VisitCompVal(GramParser.CompValContext context)
    {
        Value left = Visit(context.numeric_value(0));
        Value right = Visit(context.numeric_value(1));
        
        if (context.comparisson_type().EQ() != null)
        {
            return Value.Equal(left, right);
        }
        else if (context.comparisson_type().NEQ() != null)
        {
            return Value.NotEqual(left, right);
        }
        else if (context.comparisson_type().LE() != null)
        {
            return Value.Less(left, right);
        }
        else if (context.comparisson_type().LEQ() != null)
        {
            return Value.LessOrEqual(left, right);
        }
        else if (context.comparisson_type().GE() != null)
        {
            return Value.Greater(left, right);
        }
        else
        {
            return Value.GreaterOrEqual(left, right);
        }
    }

    public override Value VisitLogicVal(GramParser.LogicValContext context)
    {
        Value left = Visit(context.bool_value(0));
        Value right = Visit(context.bool_value(1));
        
        if (context.logic_operator().OR() != null)
        {
            return Value.Or(left, right);
        }
        else
        {
            return Value.And(left, right);
        }
    }
    
    public override Value VisitParenBoolVal(GramParser.ParenBoolValContext context)
    {
        return Visit(context.bool_value());
    }

    public override Value VisitNumVarVal(GramParser.NumVarValContext context)
    {
        string varName = context.NUM_VAR().GetText();
        int varNum = varName[1] - '0';
        // if(printFlag && _ioVector.scanned[varNum])
        //     _ioVector.used[varNum]++;
        // else if(printFlag)
        //     _ioVector.used[varNum]--;

        // if(printFlag && !_ioVector.scanned[varNum])
        //     _ioVector.used[varNum]--;

        if(!_ioVector.scanned[varNum])
            _ioVector.used[varNum]--;

        return new Value(_numVariables[varNum]);
    }
    
    public override Value VisitSubVal(GramParser.SubValContext context)
    {
        Value val = Visit(context.numeric_value());
        return new Value(-val.GetNum());
    }

    public override Value VisitAritStrongVal(GramParser.AritStrongValContext context)
    {
        Value left = Visit(context.numeric_value(0));
        Value right = Visit(context.numeric_value(1));

        if (context.aritmetic_operator_strong().MUL() != null)
        {
            return Value.Multiply(left, right);
        }
        else if (context.aritmetic_operator_strong().DIV() != null)
        {
            return Value.Divide(left, right);
        }
        else
        {
            return Value.Modulo(left, right);
        }
    }
    
    public override Value VisitAritWeakVal(GramParser.AritWeakValContext context)
    {
        Value left = Visit(context.numeric_value(0));
        Value right = Visit(context.numeric_value(1));
        
        if (context.aritmetic_operator_weak().ADD() != null)
        {
            return Value.Add(left, right);
        }
        else
        {
            return Value.Substract(left, right);
        }
    }

    public override Value VisitParenNumVal(GramParser.ParenNumValContext context)
    {
        return Visit(context.numeric_value());
    }
}