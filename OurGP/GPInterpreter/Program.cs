using Antlr4.Runtime;
using GPInterpreter;

string programStr = "while(True) {\n    X0 = 3\n}";
AntlrInputStream inputStream = new AntlrInputStream(programStr);
GramLexer gramLexer = new GramLexer(inputStream);
CommonTokenStream commonTokenStream = new CommonTokenStream(gramLexer);
GramParser gramParser = new GramParser(commonTokenStream);

GramParser.ProgramContext progContext = gramParser.program();
GpVisitor visitor = new GpVisitor(new List<Value>{new Value(true)}, 100);
List<Value> output = visitor.ourVisit(progContext);
