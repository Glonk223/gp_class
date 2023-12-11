// Generated from /Users/jakubwadrzyk/Documents/Studia/Semestr5/Programowanie Genetyczne/gp_class/grammar/Gram.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class GramParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, LPAREN=2, RPAREN=3, LBRACE=4, RBRACE=5, ADD=6, SUB=7, MUL=8, DIV=9, 
		MOD=10, ASS=11, EQ=12, NEQ=13, LE=14, LEQ=15, GE=16, GEQ=17, AND=18, OR=19, 
		NOT=20, TRUE=21, FALSE=22, IF=23, WHILE=24, PRINT=25, SCAN=26, NUMBER=27, 
		NUM_VAR=28, BOOL_VAR=29;
	public static final int
		RULE_program = 0, RULE_expressions = 1, RULE_if_statement = 2, RULE_while_loop = 3, 
		RULE_print_call = 4, RULE_scan_call = 5, RULE_assignment = 6, RULE_comparisson_type = 7, 
		RULE_logic_operator = 8, RULE_aritmetic_operator_strong = 9, RULE_aritmetic_operator_weak = 10, 
		RULE_bool_value = 11, RULE_numeric_value = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "expressions", "if_statement", "while_loop", "print_call", 
			"scan_call", "assignment", "comparisson_type", "logic_operator", "aritmetic_operator_strong", 
			"aritmetic_operator_weak", "bool_value", "numeric_value"
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

	@Override
	public String getGrammarFileName() { return "Gram.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GramParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			expressions();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionsContext extends ParserRuleContext {
		public If_statementContext if_statement() {
			return getRuleContext(If_statementContext.class,0);
		}
		public While_loopContext while_loop() {
			return getRuleContext(While_loopContext.class,0);
		}
		public Print_callContext print_call() {
			return getRuleContext(Print_callContext.class,0);
		}
		public Scan_callContext scan_call() {
			return getRuleContext(Scan_callContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public ExpressionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressions; }
	}

	public final ExpressionsContext expressions() throws RecognitionException {
		ExpressionsContext _localctx = new ExpressionsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_expressions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				{
				setState(28);
				if_statement();
				}
				break;
			case WHILE:
				{
				setState(29);
				while_loop();
				}
				break;
			case PRINT:
				{
				setState(30);
				print_call();
				}
				break;
			case SCAN:
				{
				setState(31);
				scan_call();
				}
				break;
			case NUM_VAR:
			case BOOL_VAR:
				{
				setState(32);
				assignment();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(37);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
			case WHILE:
			case PRINT:
			case SCAN:
			case NUM_VAR:
			case BOOL_VAR:
				{
				setState(35);
				expressions();
				}
				break;
			case EOF:
			case RBRACE:
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class If_statementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(GramParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(GramParser.LPAREN, 0); }
		public Bool_valueContext bool_value() {
			return getRuleContext(Bool_valueContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(GramParser.RPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(GramParser.LBRACE, 0); }
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(GramParser.RBRACE, 0); }
		public If_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_statement; }
	}

	public final If_statementContext if_statement() throws RecognitionException {
		If_statementContext _localctx = new If_statementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_if_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			match(IF);
			setState(40);
			match(LPAREN);
			setState(41);
			bool_value(0);
			setState(42);
			match(RPAREN);
			setState(43);
			match(LBRACE);
			setState(44);
			expressions();
			setState(45);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class While_loopContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(GramParser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(GramParser.LPAREN, 0); }
		public Bool_valueContext bool_value() {
			return getRuleContext(Bool_valueContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(GramParser.RPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(GramParser.LBRACE, 0); }
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(GramParser.RBRACE, 0); }
		public While_loopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_loop; }
	}

	public final While_loopContext while_loop() throws RecognitionException {
		While_loopContext _localctx = new While_loopContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_while_loop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			match(WHILE);
			setState(48);
			match(LPAREN);
			setState(49);
			bool_value(0);
			setState(50);
			match(RPAREN);
			setState(51);
			match(LBRACE);
			setState(52);
			expressions();
			setState(53);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Print_callContext extends ParserRuleContext {
		public TerminalNode PRINT() { return getToken(GramParser.PRINT, 0); }
		public TerminalNode LPAREN() { return getToken(GramParser.LPAREN, 0); }
		public Numeric_valueContext numeric_value() {
			return getRuleContext(Numeric_valueContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(GramParser.RPAREN, 0); }
		public Bool_valueContext bool_value() {
			return getRuleContext(Bool_valueContext.class,0);
		}
		public Print_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print_call; }
	}

	public final Print_callContext print_call() throws RecognitionException {
		Print_callContext _localctx = new Print_callContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_print_call);
		try {
			setState(65);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(55);
				match(PRINT);
				setState(56);
				match(LPAREN);
				setState(57);
				numeric_value(0);
				setState(58);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(60);
				match(PRINT);
				setState(61);
				match(LPAREN);
				setState(62);
				bool_value(0);
				setState(63);
				match(RPAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Scan_callContext extends ParserRuleContext {
		public TerminalNode SCAN() { return getToken(GramParser.SCAN, 0); }
		public TerminalNode LPAREN() { return getToken(GramParser.LPAREN, 0); }
		public TerminalNode NUM_VAR() { return getToken(GramParser.NUM_VAR, 0); }
		public TerminalNode RPAREN() { return getToken(GramParser.RPAREN, 0); }
		public TerminalNode BOOL_VAR() { return getToken(GramParser.BOOL_VAR, 0); }
		public Scan_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scan_call; }
	}

	public final Scan_callContext scan_call() throws RecognitionException {
		Scan_callContext _localctx = new Scan_callContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_scan_call);
		try {
			setState(75);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(67);
				match(SCAN);
				setState(68);
				match(LPAREN);
				setState(69);
				match(NUM_VAR);
				setState(70);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(71);
				match(SCAN);
				setState(72);
				match(LPAREN);
				setState(73);
				match(BOOL_VAR);
				setState(74);
				match(RPAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode NUM_VAR() { return getToken(GramParser.NUM_VAR, 0); }
		public TerminalNode ASS() { return getToken(GramParser.ASS, 0); }
		public Numeric_valueContext numeric_value() {
			return getRuleContext(Numeric_valueContext.class,0);
		}
		public TerminalNode BOOL_VAR() { return getToken(GramParser.BOOL_VAR, 0); }
		public Bool_valueContext bool_value() {
			return getRuleContext(Bool_valueContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_assignment);
		try {
			setState(83);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUM_VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				match(NUM_VAR);
				setState(78);
				match(ASS);
				setState(79);
				numeric_value(0);
				}
				break;
			case BOOL_VAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(80);
				match(BOOL_VAR);
				setState(81);
				match(ASS);
				setState(82);
				bool_value(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Comparisson_typeContext extends ParserRuleContext {
		public TerminalNode EQ() { return getToken(GramParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(GramParser.NEQ, 0); }
		public TerminalNode LE() { return getToken(GramParser.LE, 0); }
		public TerminalNode LEQ() { return getToken(GramParser.LEQ, 0); }
		public TerminalNode GE() { return getToken(GramParser.GE, 0); }
		public TerminalNode GEQ() { return getToken(GramParser.GEQ, 0); }
		public Comparisson_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparisson_type; }
	}

	public final Comparisson_typeContext comparisson_type() throws RecognitionException {
		Comparisson_typeContext _localctx = new Comparisson_typeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_comparisson_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 258048L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Logic_operatorContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(GramParser.AND, 0); }
		public TerminalNode OR() { return getToken(GramParser.OR, 0); }
		public Logic_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logic_operator; }
	}

	public final Logic_operatorContext logic_operator() throws RecognitionException {
		Logic_operatorContext _localctx = new Logic_operatorContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_logic_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			_la = _input.LA(1);
			if ( !(_la==AND || _la==OR) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Aritmetic_operator_strongContext extends ParserRuleContext {
		public TerminalNode MUL() { return getToken(GramParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(GramParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(GramParser.MOD, 0); }
		public Aritmetic_operator_strongContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aritmetic_operator_strong; }
	}

	public final Aritmetic_operator_strongContext aritmetic_operator_strong() throws RecognitionException {
		Aritmetic_operator_strongContext _localctx = new Aritmetic_operator_strongContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_aritmetic_operator_strong);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1792L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Aritmetic_operator_weakContext extends ParserRuleContext {
		public TerminalNode ADD() { return getToken(GramParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(GramParser.SUB, 0); }
		public Aritmetic_operator_weakContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aritmetic_operator_weak; }
	}

	public final Aritmetic_operator_weakContext aritmetic_operator_weak() throws RecognitionException {
		Aritmetic_operator_weakContext _localctx = new Aritmetic_operator_weakContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_aritmetic_operator_weak);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			_la = _input.LA(1);
			if ( !(_la==ADD || _la==SUB) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Bool_valueContext extends ParserRuleContext {
		public TerminalNode BOOL_VAR() { return getToken(GramParser.BOOL_VAR, 0); }
		public TerminalNode TRUE() { return getToken(GramParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(GramParser.FALSE, 0); }
		public TerminalNode NOT() { return getToken(GramParser.NOT, 0); }
		public List<Bool_valueContext> bool_value() {
			return getRuleContexts(Bool_valueContext.class);
		}
		public Bool_valueContext bool_value(int i) {
			return getRuleContext(Bool_valueContext.class,i);
		}
		public List<Numeric_valueContext> numeric_value() {
			return getRuleContexts(Numeric_valueContext.class);
		}
		public Numeric_valueContext numeric_value(int i) {
			return getRuleContext(Numeric_valueContext.class,i);
		}
		public Comparisson_typeContext comparisson_type() {
			return getRuleContext(Comparisson_typeContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(GramParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(GramParser.RPAREN, 0); }
		public Logic_operatorContext logic_operator() {
			return getRuleContext(Logic_operatorContext.class,0);
		}
		public Bool_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool_value; }
	}

	public final Bool_valueContext bool_value() throws RecognitionException {
		return bool_value(0);
	}

	private Bool_valueContext bool_value(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Bool_valueContext _localctx = new Bool_valueContext(_ctx, _parentState);
		Bool_valueContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_bool_value, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(94);
				match(BOOL_VAR);
				}
				break;
			case 2:
				{
				setState(95);
				match(TRUE);
				}
				break;
			case 3:
				{
				setState(96);
				match(FALSE);
				}
				break;
			case 4:
				{
				setState(97);
				match(NOT);
				setState(98);
				bool_value(4);
				}
				break;
			case 5:
				{
				setState(99);
				numeric_value(0);
				setState(100);
				comparisson_type();
				setState(101);
				numeric_value(0);
				}
				break;
			case 6:
				{
				setState(103);
				match(LPAREN);
				setState(104);
				bool_value(0);
				setState(105);
				match(RPAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(115);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Bool_valueContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_bool_value);
					setState(109);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(110);
					logic_operator();
					setState(111);
					bool_value(3);
					}
					} 
				}
				setState(117);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Numeric_valueContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(GramParser.NUMBER, 0); }
		public TerminalNode NUM_VAR() { return getToken(GramParser.NUM_VAR, 0); }
		public TerminalNode SUB() { return getToken(GramParser.SUB, 0); }
		public List<Numeric_valueContext> numeric_value() {
			return getRuleContexts(Numeric_valueContext.class);
		}
		public Numeric_valueContext numeric_value(int i) {
			return getRuleContext(Numeric_valueContext.class,i);
		}
		public TerminalNode LPAREN() { return getToken(GramParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(GramParser.RPAREN, 0); }
		public Aritmetic_operator_strongContext aritmetic_operator_strong() {
			return getRuleContext(Aritmetic_operator_strongContext.class,0);
		}
		public Aritmetic_operator_weakContext aritmetic_operator_weak() {
			return getRuleContext(Aritmetic_operator_weakContext.class,0);
		}
		public Numeric_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numeric_value; }
	}

	public final Numeric_valueContext numeric_value() throws RecognitionException {
		return numeric_value(0);
	}

	private Numeric_valueContext numeric_value(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Numeric_valueContext _localctx = new Numeric_valueContext(_ctx, _parentState);
		Numeric_valueContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_numeric_value, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				{
				setState(119);
				match(NUMBER);
				}
				break;
			case NUM_VAR:
				{
				setState(120);
				match(NUM_VAR);
				}
				break;
			case SUB:
				{
				setState(121);
				match(SUB);
				setState(122);
				numeric_value(4);
				}
				break;
			case LPAREN:
				{
				setState(123);
				match(LPAREN);
				setState(124);
				numeric_value(0);
				setState(125);
				match(RPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(139);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(137);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new Numeric_valueContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_numeric_value);
						setState(129);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(130);
						aritmetic_operator_strong();
						setState(131);
						numeric_value(4);
						}
						break;
					case 2:
						{
						_localctx = new Numeric_valueContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_numeric_value);
						setState(133);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(134);
						aritmetic_operator_weak();
						setState(135);
						numeric_value(3);
						}
						break;
					}
					} 
				}
				setState(141);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 11:
			return bool_value_sempred((Bool_valueContext)_localctx, predIndex);
		case 12:
			return numeric_value_sempred((Numeric_valueContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean bool_value_sempred(Bool_valueContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean numeric_value_sempred(Numeric_valueContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 3);
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u001d\u008f\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0003\u0001\"\b\u0001\u0001\u0001\u0001"+
		"\u0001\u0003\u0001&\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004B\b"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0003\u0005L\b\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006T\b"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n"+
		"\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0003\u000bl\b\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0005\u000br\b\u000b\n\u000b\f\u000bu\t"+
		"\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0001\f\u0003\f\u0080\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0005\f\u008a\b\f\n\f\f\f\u008d\t\f\u0001\f\u0000\u0002"+
		"\u0016\u0018\r\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016"+
		"\u0018\u0000\u0004\u0001\u0000\f\u0011\u0001\u0000\u0012\u0013\u0001\u0000"+
		"\b\n\u0001\u0000\u0006\u0007\u0094\u0000\u001a\u0001\u0000\u0000\u0000"+
		"\u0002!\u0001\u0000\u0000\u0000\u0004\'\u0001\u0000\u0000\u0000\u0006"+
		"/\u0001\u0000\u0000\u0000\bA\u0001\u0000\u0000\u0000\nK\u0001\u0000\u0000"+
		"\u0000\fS\u0001\u0000\u0000\u0000\u000eU\u0001\u0000\u0000\u0000\u0010"+
		"W\u0001\u0000\u0000\u0000\u0012Y\u0001\u0000\u0000\u0000\u0014[\u0001"+
		"\u0000\u0000\u0000\u0016k\u0001\u0000\u0000\u0000\u0018\u007f\u0001\u0000"+
		"\u0000\u0000\u001a\u001b\u0003\u0002\u0001\u0000\u001b\u0001\u0001\u0000"+
		"\u0000\u0000\u001c\"\u0003\u0004\u0002\u0000\u001d\"\u0003\u0006\u0003"+
		"\u0000\u001e\"\u0003\b\u0004\u0000\u001f\"\u0003\n\u0005\u0000 \"\u0003"+
		"\f\u0006\u0000!\u001c\u0001\u0000\u0000\u0000!\u001d\u0001\u0000\u0000"+
		"\u0000!\u001e\u0001\u0000\u0000\u0000!\u001f\u0001\u0000\u0000\u0000!"+
		" \u0001\u0000\u0000\u0000\"%\u0001\u0000\u0000\u0000#&\u0003\u0002\u0001"+
		"\u0000$&\u0001\u0000\u0000\u0000%#\u0001\u0000\u0000\u0000%$\u0001\u0000"+
		"\u0000\u0000&\u0003\u0001\u0000\u0000\u0000\'(\u0005\u0017\u0000\u0000"+
		"()\u0005\u0002\u0000\u0000)*\u0003\u0016\u000b\u0000*+\u0005\u0003\u0000"+
		"\u0000+,\u0005\u0004\u0000\u0000,-\u0003\u0002\u0001\u0000-.\u0005\u0005"+
		"\u0000\u0000.\u0005\u0001\u0000\u0000\u0000/0\u0005\u0018\u0000\u0000"+
		"01\u0005\u0002\u0000\u000012\u0003\u0016\u000b\u000023\u0005\u0003\u0000"+
		"\u000034\u0005\u0004\u0000\u000045\u0003\u0002\u0001\u000056\u0005\u0005"+
		"\u0000\u00006\u0007\u0001\u0000\u0000\u000078\u0005\u0019\u0000\u0000"+
		"89\u0005\u0002\u0000\u00009:\u0003\u0018\f\u0000:;\u0005\u0003\u0000\u0000"+
		";B\u0001\u0000\u0000\u0000<=\u0005\u0019\u0000\u0000=>\u0005\u0002\u0000"+
		"\u0000>?\u0003\u0016\u000b\u0000?@\u0005\u0003\u0000\u0000@B\u0001\u0000"+
		"\u0000\u0000A7\u0001\u0000\u0000\u0000A<\u0001\u0000\u0000\u0000B\t\u0001"+
		"\u0000\u0000\u0000CD\u0005\u001a\u0000\u0000DE\u0005\u0002\u0000\u0000"+
		"EF\u0005\u001c\u0000\u0000FL\u0005\u0003\u0000\u0000GH\u0005\u001a\u0000"+
		"\u0000HI\u0005\u0002\u0000\u0000IJ\u0005\u001d\u0000\u0000JL\u0005\u0003"+
		"\u0000\u0000KC\u0001\u0000\u0000\u0000KG\u0001\u0000\u0000\u0000L\u000b"+
		"\u0001\u0000\u0000\u0000MN\u0005\u001c\u0000\u0000NO\u0005\u000b\u0000"+
		"\u0000OT\u0003\u0018\f\u0000PQ\u0005\u001d\u0000\u0000QR\u0005\u000b\u0000"+
		"\u0000RT\u0003\u0016\u000b\u0000SM\u0001\u0000\u0000\u0000SP\u0001\u0000"+
		"\u0000\u0000T\r\u0001\u0000\u0000\u0000UV\u0007\u0000\u0000\u0000V\u000f"+
		"\u0001\u0000\u0000\u0000WX\u0007\u0001\u0000\u0000X\u0011\u0001\u0000"+
		"\u0000\u0000YZ\u0007\u0002\u0000\u0000Z\u0013\u0001\u0000\u0000\u0000"+
		"[\\\u0007\u0003\u0000\u0000\\\u0015\u0001\u0000\u0000\u0000]^\u0006\u000b"+
		"\uffff\uffff\u0000^l\u0005\u001d\u0000\u0000_l\u0005\u0015\u0000\u0000"+
		"`l\u0005\u0016\u0000\u0000ab\u0005\u0014\u0000\u0000bl\u0003\u0016\u000b"+
		"\u0004cd\u0003\u0018\f\u0000de\u0003\u000e\u0007\u0000ef\u0003\u0018\f"+
		"\u0000fl\u0001\u0000\u0000\u0000gh\u0005\u0002\u0000\u0000hi\u0003\u0016"+
		"\u000b\u0000ij\u0005\u0003\u0000\u0000jl\u0001\u0000\u0000\u0000k]\u0001"+
		"\u0000\u0000\u0000k_\u0001\u0000\u0000\u0000k`\u0001\u0000\u0000\u0000"+
		"ka\u0001\u0000\u0000\u0000kc\u0001\u0000\u0000\u0000kg\u0001\u0000\u0000"+
		"\u0000ls\u0001\u0000\u0000\u0000mn\n\u0002\u0000\u0000no\u0003\u0010\b"+
		"\u0000op\u0003\u0016\u000b\u0003pr\u0001\u0000\u0000\u0000qm\u0001\u0000"+
		"\u0000\u0000ru\u0001\u0000\u0000\u0000sq\u0001\u0000\u0000\u0000st\u0001"+
		"\u0000\u0000\u0000t\u0017\u0001\u0000\u0000\u0000us\u0001\u0000\u0000"+
		"\u0000vw\u0006\f\uffff\uffff\u0000w\u0080\u0005\u001b\u0000\u0000x\u0080"+
		"\u0005\u001c\u0000\u0000yz\u0005\u0007\u0000\u0000z\u0080\u0003\u0018"+
		"\f\u0004{|\u0005\u0002\u0000\u0000|}\u0003\u0018\f\u0000}~\u0005\u0003"+
		"\u0000\u0000~\u0080\u0001\u0000\u0000\u0000\u007fv\u0001\u0000\u0000\u0000"+
		"\u007fx\u0001\u0000\u0000\u0000\u007fy\u0001\u0000\u0000\u0000\u007f{"+
		"\u0001\u0000\u0000\u0000\u0080\u008b\u0001\u0000\u0000\u0000\u0081\u0082"+
		"\n\u0003\u0000\u0000\u0082\u0083\u0003\u0012\t\u0000\u0083\u0084\u0003"+
		"\u0018\f\u0004\u0084\u008a\u0001\u0000\u0000\u0000\u0085\u0086\n\u0002"+
		"\u0000\u0000\u0086\u0087\u0003\u0014\n\u0000\u0087\u0088\u0003\u0018\f"+
		"\u0003\u0088\u008a\u0001\u0000\u0000\u0000\u0089\u0081\u0001\u0000\u0000"+
		"\u0000\u0089\u0085\u0001\u0000\u0000\u0000\u008a\u008d\u0001\u0000\u0000"+
		"\u0000\u008b\u0089\u0001\u0000\u0000\u0000\u008b\u008c\u0001\u0000\u0000"+
		"\u0000\u008c\u0019\u0001\u0000\u0000\u0000\u008d\u008b\u0001\u0000\u0000"+
		"\u0000\n!%AKSks\u007f\u0089\u008b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}