// Generated from /Users/jakubwadrzyk/Documents/Studia/Semestr5/Programowanie Genetyczne/gp_class/grammar/Lexer.g4 by ANTLR 4.13.1
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
		WS=1, LPAREN=2, RPAREN=3, LBRACE=4, RBRACE=5, ADD=6, SUB=7, MUL=8, DIV=9, 
		MOD=10, ASS=11, EQ=12, NEQ=13, LE=14, LEQ=15, GE=16, GEQ=17, AND=18, OR=19, 
		NOT=20, TRUE=21, FALSE=22, IF=23, WHILE=24, PRINT=25, SCAN=26, NUMBER=27, 
		NUM_VAR=28, BOOL_VAR=29;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"WS", "LPAREN", "RPAREN", "LBRACE", "RBRACE", "ADD", "SUB", "MUL", "DIV", 
			"MOD", "ASS", "EQ", "NEQ", "LE", "LEQ", "GE", "GEQ", "AND", "OR", "NOT", 
			"TRUE", "FALSE", "IF", "WHILE", "PRINT", "SCAN", "NUMBER", "NUM_VAR", 
			"BOOL_VAR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'('", "')'", "'{'", "'}'", "'+'", "'-'", "'*'", "'/'", "'%'", 
			"'='", "'=='", "'!='", "'<'", "'<='", "'>'", "'>='", "'&&'", "'||'", 
			"'!'", "'True'", "'False'", "'if'", "'while'", "'print'", "'scan'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WS", "LPAREN", "RPAREN", "LBRACE", "RBRACE", "ADD", "SUB", "MUL", 
			"DIV", "MOD", "ASS", "EQ", "NEQ", "LE", "LEQ", "GE", "GEQ", "AND", "OR", 
			"NOT", "TRUE", "FALSE", "IF", "WHILE", "PRINT", "SCAN", "NUMBER", "NUM_VAR", 
			"BOOL_VAR"
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
		"\u0004\u0000\u001d\u00a0\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a"+
		"\u0002\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0001\u0000\u0004\u0000"+
		"=\b\u0000\u000b\u0000\f\u0000>\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0004\u001a"+
		"\u008f\b\u001a\u000b\u001a\f\u001a\u0090\u0001\u001a\u0001\u001a\u0004"+
		"\u001a\u0095\b\u001a\u000b\u001a\f\u001a\u0096\u0003\u001a\u0099\b\u001a"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0000\u0000\u001d\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005"+
		"\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019"+
		"\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015"+
		"+\u0016-\u0017/\u00181\u00193\u001a5\u001b7\u001c9\u001d\u0001\u0000\u0002"+
		"\u0003\u0000\t\n\r\r  \u0001\u000009\u00a3\u0000\u0001\u0001\u0000\u0000"+
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
		"\u0001<\u0001\u0000\u0000\u0000\u0003B\u0001\u0000\u0000\u0000\u0005D"+
		"\u0001\u0000\u0000\u0000\u0007F\u0001\u0000\u0000\u0000\tH\u0001\u0000"+
		"\u0000\u0000\u000bJ\u0001\u0000\u0000\u0000\rL\u0001\u0000\u0000\u0000"+
		"\u000fN\u0001\u0000\u0000\u0000\u0011P\u0001\u0000\u0000\u0000\u0013R"+
		"\u0001\u0000\u0000\u0000\u0015T\u0001\u0000\u0000\u0000\u0017V\u0001\u0000"+
		"\u0000\u0000\u0019Y\u0001\u0000\u0000\u0000\u001b\\\u0001\u0000\u0000"+
		"\u0000\u001d^\u0001\u0000\u0000\u0000\u001fa\u0001\u0000\u0000\u0000!"+
		"c\u0001\u0000\u0000\u0000#f\u0001\u0000\u0000\u0000%i\u0001\u0000\u0000"+
		"\u0000\'l\u0001\u0000\u0000\u0000)n\u0001\u0000\u0000\u0000+s\u0001\u0000"+
		"\u0000\u0000-y\u0001\u0000\u0000\u0000/|\u0001\u0000\u0000\u00001\u0082"+
		"\u0001\u0000\u0000\u00003\u0088\u0001\u0000\u0000\u00005\u008e\u0001\u0000"+
		"\u0000\u00007\u009a\u0001\u0000\u0000\u00009\u009d\u0001\u0000\u0000\u0000"+
		";=\u0007\u0000\u0000\u0000<;\u0001\u0000\u0000\u0000=>\u0001\u0000\u0000"+
		"\u0000><\u0001\u0000\u0000\u0000>?\u0001\u0000\u0000\u0000?@\u0001\u0000"+
		"\u0000\u0000@A\u0006\u0000\u0000\u0000A\u0002\u0001\u0000\u0000\u0000"+
		"BC\u0005(\u0000\u0000C\u0004\u0001\u0000\u0000\u0000DE\u0005)\u0000\u0000"+
		"E\u0006\u0001\u0000\u0000\u0000FG\u0005{\u0000\u0000G\b\u0001\u0000\u0000"+
		"\u0000HI\u0005}\u0000\u0000I\n\u0001\u0000\u0000\u0000JK\u0005+\u0000"+
		"\u0000K\f\u0001\u0000\u0000\u0000LM\u0005-\u0000\u0000M\u000e\u0001\u0000"+
		"\u0000\u0000NO\u0005*\u0000\u0000O\u0010\u0001\u0000\u0000\u0000PQ\u0005"+
		"/\u0000\u0000Q\u0012\u0001\u0000\u0000\u0000RS\u0005%\u0000\u0000S\u0014"+
		"\u0001\u0000\u0000\u0000TU\u0005=\u0000\u0000U\u0016\u0001\u0000\u0000"+
		"\u0000VW\u0005=\u0000\u0000WX\u0005=\u0000\u0000X\u0018\u0001\u0000\u0000"+
		"\u0000YZ\u0005!\u0000\u0000Z[\u0005=\u0000\u0000[\u001a\u0001\u0000\u0000"+
		"\u0000\\]\u0005<\u0000\u0000]\u001c\u0001\u0000\u0000\u0000^_\u0005<\u0000"+
		"\u0000_`\u0005=\u0000\u0000`\u001e\u0001\u0000\u0000\u0000ab\u0005>\u0000"+
		"\u0000b \u0001\u0000\u0000\u0000cd\u0005>\u0000\u0000de\u0005=\u0000\u0000"+
		"e\"\u0001\u0000\u0000\u0000fg\u0005&\u0000\u0000gh\u0005&\u0000\u0000"+
		"h$\u0001\u0000\u0000\u0000ij\u0005|\u0000\u0000jk\u0005|\u0000\u0000k"+
		"&\u0001\u0000\u0000\u0000lm\u0005!\u0000\u0000m(\u0001\u0000\u0000\u0000"+
		"no\u0005T\u0000\u0000op\u0005r\u0000\u0000pq\u0005u\u0000\u0000qr\u0005"+
		"e\u0000\u0000r*\u0001\u0000\u0000\u0000st\u0005F\u0000\u0000tu\u0005a"+
		"\u0000\u0000uv\u0005l\u0000\u0000vw\u0005s\u0000\u0000wx\u0005e\u0000"+
		"\u0000x,\u0001\u0000\u0000\u0000yz\u0005i\u0000\u0000z{\u0005f\u0000\u0000"+
		"{.\u0001\u0000\u0000\u0000|}\u0005w\u0000\u0000}~\u0005h\u0000\u0000~"+
		"\u007f\u0005i\u0000\u0000\u007f\u0080\u0005l\u0000\u0000\u0080\u0081\u0005"+
		"e\u0000\u0000\u00810\u0001\u0000\u0000\u0000\u0082\u0083\u0005p\u0000"+
		"\u0000\u0083\u0084\u0005r\u0000\u0000\u0084\u0085\u0005i\u0000\u0000\u0085"+
		"\u0086\u0005n\u0000\u0000\u0086\u0087\u0005t\u0000\u0000\u00872\u0001"+
		"\u0000\u0000\u0000\u0088\u0089\u0005s\u0000\u0000\u0089\u008a\u0005c\u0000"+
		"\u0000\u008a\u008b\u0005a\u0000\u0000\u008b\u008c\u0005n\u0000\u0000\u008c"+
		"4\u0001\u0000\u0000\u0000\u008d\u008f\u0007\u0001\u0000\u0000\u008e\u008d"+
		"\u0001\u0000\u0000\u0000\u008f\u0090\u0001\u0000\u0000\u0000\u0090\u008e"+
		"\u0001\u0000\u0000\u0000\u0090\u0091\u0001\u0000\u0000\u0000\u0091\u0098"+
		"\u0001\u0000\u0000\u0000\u0092\u0094\u0005.\u0000\u0000\u0093\u0095\u0007"+
		"\u0001\u0000\u0000\u0094\u0093\u0001\u0000\u0000\u0000\u0095\u0096\u0001"+
		"\u0000\u0000\u0000\u0096\u0094\u0001\u0000\u0000\u0000\u0096\u0097\u0001"+
		"\u0000\u0000\u0000\u0097\u0099\u0001\u0000\u0000\u0000\u0098\u0092\u0001"+
		"\u0000\u0000\u0000\u0098\u0099\u0001\u0000\u0000\u0000\u00996\u0001\u0000"+
		"\u0000\u0000\u009a\u009b\u0005X\u0000\u0000\u009b\u009c\u0007\u0001\u0000"+
		"\u0000\u009c8\u0001\u0000\u0000\u0000\u009d\u009e\u0005L\u0000\u0000\u009e"+
		"\u009f\u0007\u0001\u0000\u0000\u009f:\u0001\u0000\u0000\u0000\u0005\u0000"+
		">\u0090\u0096\u0098\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}