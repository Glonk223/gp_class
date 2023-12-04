// Generated from /Users/jakubwadrzyk/Documents/Studia/Semestr 5/Programowanie Genetyczne/gp_class/grammar/Lexer.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class Lexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, NEWLINE=2, LPAREN=3, RPAREN=4, LBRACE=5, RBRACE=6, SEMICOLON=7, 
		ADD=8, SUB=9, MUL=10, DIV=11, MOD=12, SIN=13, COS=14, ASS=15, EQ=16, NEQ=17, 
		LE=18, LEQ=19, GE=20, GEQ=21, AND=22, OR=23, NOT=24, TRUE=25, FALSE=26, 
		IF=27, WHILE=28, PRINT=29, SCAN=30, NUMBER=31, NUM_VAR=32, BOOL_VAR=33;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"WS", "NEWLINE", "LPAREN", "RPAREN", "LBRACE", "RBRACE", "SEMICOLON", 
			"ADD", "SUB", "MUL", "DIV", "MOD", "SIN", "COS", "ASS", "EQ", "NEQ", 
			"LE", "LEQ", "GE", "GEQ", "AND", "OR", "NOT", "TRUE", "FALSE", "IF", 
			"WHILE", "PRINT", "SCAN", "NUMBER", "NUM_VAR", "BOOL_VAR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'\\n'", "'('", "')'", "'{'", "'}'", "';'", "'+'", "'-'", 
			"'*'", "'/'", "'%'", "'sin'", "'cos'", "'='", "'=='", "'!='", "'<'", 
			"'<='", "'>'", "'>='", "'&&'", "'||'", "'!'", "'true'", "'false'", "'if'", 
			"'while'", "'print'", "'scan'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WS", "NEWLINE", "LPAREN", "RPAREN", "LBRACE", "RBRACE", "SEMICOLON", 
			"ADD", "SUB", "MUL", "DIV", "MOD", "SIN", "COS", "ASS", "EQ", "NEQ", 
			"LE", "LEQ", "GE", "GEQ", "AND", "OR", "NOT", "TRUE", "FALSE", "IF", 
			"WHILE", "PRINT", "SCAN", "NUMBER", "NUM_VAR", "BOOL_VAR"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public Lexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Lexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000!\u00b4\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0001\u0000\u0004"+
		"\u0000E\b\u0000\u000b\u0000\f\u0000F\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001e\u0004\u001e\u00a3\b\u001e"+
		"\u000b\u001e\f\u001e\u00a4\u0001\u001e\u0001\u001e\u0004\u001e\u00a9\b"+
		"\u001e\u000b\u001e\f\u001e\u00aa\u0003\u001e\u00ad\b\u001e\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001 \u0000\u0000!\u0001\u0001"+
		"\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f"+
		"\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f"+
		"\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/\u0018"+
		"1\u00193\u001a5\u001b7\u001c9\u001d;\u001e=\u001f? A!\u0001\u0000\u0002"+
		"\u0003\u0000\t\t\r\r  \u0001\u000009\u00b7\u0000\u0001\u0001\u0000\u0000"+
		"\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000"+
		"\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000"+
		"\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000"+
		"\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000"+
		"\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000"+
		"\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000"+
		"\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000"+
		"\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001"+
		"\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000"+
		"\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000"+
		"\u0000-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00001"+
		"\u0001\u0000\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u00005\u0001\u0000"+
		"\u0000\u0000\u00007\u0001\u0000\u0000\u0000\u00009\u0001\u0000\u0000\u0000"+
		"\u0000;\u0001\u0000\u0000\u0000\u0000=\u0001\u0000\u0000\u0000\u0000?"+
		"\u0001\u0000\u0000\u0000\u0000A\u0001\u0000\u0000\u0000\u0001D\u0001\u0000"+
		"\u0000\u0000\u0003J\u0001\u0000\u0000\u0000\u0005L\u0001\u0000\u0000\u0000"+
		"\u0007N\u0001\u0000\u0000\u0000\tP\u0001\u0000\u0000\u0000\u000bR\u0001"+
		"\u0000\u0000\u0000\rT\u0001\u0000\u0000\u0000\u000fV\u0001\u0000\u0000"+
		"\u0000\u0011X\u0001\u0000\u0000\u0000\u0013Z\u0001\u0000\u0000\u0000\u0015"+
		"\\\u0001\u0000\u0000\u0000\u0017^\u0001\u0000\u0000\u0000\u0019`\u0001"+
		"\u0000\u0000\u0000\u001bd\u0001\u0000\u0000\u0000\u001dh\u0001\u0000\u0000"+
		"\u0000\u001fj\u0001\u0000\u0000\u0000!m\u0001\u0000\u0000\u0000#p\u0001"+
		"\u0000\u0000\u0000%r\u0001\u0000\u0000\u0000\'u\u0001\u0000\u0000\u0000"+
		")w\u0001\u0000\u0000\u0000+z\u0001\u0000\u0000\u0000-}\u0001\u0000\u0000"+
		"\u0000/\u0080\u0001\u0000\u0000\u00001\u0082\u0001\u0000\u0000\u00003"+
		"\u0087\u0001\u0000\u0000\u00005\u008d\u0001\u0000\u0000\u00007\u0090\u0001"+
		"\u0000\u0000\u00009\u0096\u0001\u0000\u0000\u0000;\u009c\u0001\u0000\u0000"+
		"\u0000=\u00a2\u0001\u0000\u0000\u0000?\u00ae\u0001\u0000\u0000\u0000A"+
		"\u00b1\u0001\u0000\u0000\u0000CE\u0007\u0000\u0000\u0000DC\u0001\u0000"+
		"\u0000\u0000EF\u0001\u0000\u0000\u0000FD\u0001\u0000\u0000\u0000FG\u0001"+
		"\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000HI\u0006\u0000\u0000\u0000"+
		"I\u0002\u0001\u0000\u0000\u0000JK\u0005\n\u0000\u0000K\u0004\u0001\u0000"+
		"\u0000\u0000LM\u0005(\u0000\u0000M\u0006\u0001\u0000\u0000\u0000NO\u0005"+
		")\u0000\u0000O\b\u0001\u0000\u0000\u0000PQ\u0005{\u0000\u0000Q\n\u0001"+
		"\u0000\u0000\u0000RS\u0005}\u0000\u0000S\f\u0001\u0000\u0000\u0000TU\u0005"+
		";\u0000\u0000U\u000e\u0001\u0000\u0000\u0000VW\u0005+\u0000\u0000W\u0010"+
		"\u0001\u0000\u0000\u0000XY\u0005-\u0000\u0000Y\u0012\u0001\u0000\u0000"+
		"\u0000Z[\u0005*\u0000\u0000[\u0014\u0001\u0000\u0000\u0000\\]\u0005/\u0000"+
		"\u0000]\u0016\u0001\u0000\u0000\u0000^_\u0005%\u0000\u0000_\u0018\u0001"+
		"\u0000\u0000\u0000`a\u0005s\u0000\u0000ab\u0005i\u0000\u0000bc\u0005n"+
		"\u0000\u0000c\u001a\u0001\u0000\u0000\u0000de\u0005c\u0000\u0000ef\u0005"+
		"o\u0000\u0000fg\u0005s\u0000\u0000g\u001c\u0001\u0000\u0000\u0000hi\u0005"+
		"=\u0000\u0000i\u001e\u0001\u0000\u0000\u0000jk\u0005=\u0000\u0000kl\u0005"+
		"=\u0000\u0000l \u0001\u0000\u0000\u0000mn\u0005!\u0000\u0000no\u0005="+
		"\u0000\u0000o\"\u0001\u0000\u0000\u0000pq\u0005<\u0000\u0000q$\u0001\u0000"+
		"\u0000\u0000rs\u0005<\u0000\u0000st\u0005=\u0000\u0000t&\u0001\u0000\u0000"+
		"\u0000uv\u0005>\u0000\u0000v(\u0001\u0000\u0000\u0000wx\u0005>\u0000\u0000"+
		"xy\u0005=\u0000\u0000y*\u0001\u0000\u0000\u0000z{\u0005&\u0000\u0000{"+
		"|\u0005&\u0000\u0000|,\u0001\u0000\u0000\u0000}~\u0005|\u0000\u0000~\u007f"+
		"\u0005|\u0000\u0000\u007f.\u0001\u0000\u0000\u0000\u0080\u0081\u0005!"+
		"\u0000\u0000\u00810\u0001\u0000\u0000\u0000\u0082\u0083\u0005t\u0000\u0000"+
		"\u0083\u0084\u0005r\u0000\u0000\u0084\u0085\u0005u\u0000\u0000\u0085\u0086"+
		"\u0005e\u0000\u0000\u00862\u0001\u0000\u0000\u0000\u0087\u0088\u0005f"+
		"\u0000\u0000\u0088\u0089\u0005a\u0000\u0000\u0089\u008a\u0005l\u0000\u0000"+
		"\u008a\u008b\u0005s\u0000\u0000\u008b\u008c\u0005e\u0000\u0000\u008c4"+
		"\u0001\u0000\u0000\u0000\u008d\u008e\u0005i\u0000\u0000\u008e\u008f\u0005"+
		"f\u0000\u0000\u008f6\u0001\u0000\u0000\u0000\u0090\u0091\u0005w\u0000"+
		"\u0000\u0091\u0092\u0005h\u0000\u0000\u0092\u0093\u0005i\u0000\u0000\u0093"+
		"\u0094\u0005l\u0000\u0000\u0094\u0095\u0005e\u0000\u0000\u00958\u0001"+
		"\u0000\u0000\u0000\u0096\u0097\u0005p\u0000\u0000\u0097\u0098\u0005r\u0000"+
		"\u0000\u0098\u0099\u0005i\u0000\u0000\u0099\u009a\u0005n\u0000\u0000\u009a"+
		"\u009b\u0005t\u0000\u0000\u009b:\u0001\u0000\u0000\u0000\u009c\u009d\u0005"+
		"s\u0000\u0000\u009d\u009e\u0005c\u0000\u0000\u009e\u009f\u0005a\u0000"+
		"\u0000\u009f\u00a0\u0005n\u0000\u0000\u00a0<\u0001\u0000\u0000\u0000\u00a1"+
		"\u00a3\u0007\u0001\u0000\u0000\u00a2\u00a1\u0001\u0000\u0000\u0000\u00a3"+
		"\u00a4\u0001\u0000\u0000\u0000\u00a4\u00a2\u0001\u0000\u0000\u0000\u00a4"+
		"\u00a5\u0001\u0000\u0000\u0000\u00a5\u00ac\u0001\u0000\u0000\u0000\u00a6"+
		"\u00a8\u0005.\u0000\u0000\u00a7\u00a9\u0007\u0001\u0000\u0000\u00a8\u00a7"+
		"\u0001\u0000\u0000\u0000\u00a9\u00aa\u0001\u0000\u0000\u0000\u00aa\u00a8"+
		"\u0001\u0000\u0000\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000\u00ab\u00ad"+
		"\u0001\u0000\u0000\u0000\u00ac\u00a6\u0001\u0000\u0000\u0000\u00ac\u00ad"+
		"\u0001\u0000\u0000\u0000\u00ad>\u0001\u0000\u0000\u0000\u00ae\u00af\u0005"+
		"X\u0000\u0000\u00af\u00b0\u0007\u0001\u0000\u0000\u00b0@\u0001\u0000\u0000"+
		"\u0000\u00b1\u00b2\u0005L\u0000\u0000\u00b2\u00b3\u0007\u0001\u0000\u0000"+
		"\u00b3B\u0001\u0000\u0000\u0000\u0005\u0000F\u00a4\u00aa\u00ac\u0001\u0006"+
		"\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}