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
		int _la;
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
			setState(36);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 931135488L) != 0)) {
				{
				setState(35);
				expressions();
				}
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
			setState(38);
			match(IF);
			setState(39);
			match(LPAREN);
			setState(40);
			bool_value(0);
			setState(41);
			match(RPAREN);
			setState(42);
			match(LBRACE);
			setState(43);
			expressions();
			setState(44);
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
			setState(46);
			match(WHILE);
			setState(47);
			match(LPAREN);
			setState(48);
			bool_value(0);
			setState(49);
			match(RPAREN);
			setState(50);
			match(LBRACE);
			setState(51);
			expressions();
			setState(52);
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
			setState(64);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(54);
				match(PRINT);
				setState(55);
				match(LPAREN);
				setState(56);
				numeric_value(0);
				setState(57);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(59);
				match(PRINT);
				setState(60);
				match(LPAREN);
				setState(61);
				bool_value(0);
				setState(62);
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
			setState(74);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(66);
				match(SCAN);
				setState(67);
				match(LPAREN);
				setState(68);
				match(NUM_VAR);
				setState(69);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(70);
				match(SCAN);
				setState(71);
				match(LPAREN);
				setState(72);
				match(BOOL_VAR);
				setState(73);
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
			setState(82);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUM_VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(76);
				match(NUM_VAR);
				setState(77);
				match(ASS);
				setState(78);
				numeric_value(0);
				}
				break;
			case BOOL_VAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(79);
				match(BOOL_VAR);
				setState(80);
				match(ASS);
				setState(81);
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
			setState(84);
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
			setState(86);
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
			setState(88);
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
			setState(90);
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
			setState(106);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(93);
				match(BOOL_VAR);
				}
				break;
			case 2:
				{
				setState(94);
				match(TRUE);
				}
				break;
			case 3:
				{
				setState(95);
				match(FALSE);
				}
				break;
			case 4:
				{
				setState(96);
				match(NOT);
				setState(97);
				bool_value(4);
				}
				break;
			case 5:
				{
				setState(98);
				numeric_value(0);
				setState(99);
				comparisson_type();
				setState(100);
				numeric_value(0);
				}
				break;
			case 6:
				{
				setState(102);
				match(LPAREN);
				setState(103);
				bool_value(0);
				setState(104);
				match(RPAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(114);
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
					setState(108);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(109);
					logic_operator();
					setState(110);
					bool_value(3);
					}
					} 
				}
				setState(116);
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
			setState(126);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				{
				setState(118);
				match(NUMBER);
				}
				break;
			case NUM_VAR:
				{
				setState(119);
				match(NUM_VAR);
				}
				break;
			case SUB:
				{
				setState(120);
				match(SUB);
				setState(121);
				numeric_value(4);
				}
				break;
			case LPAREN:
				{
				setState(122);
				match(LPAREN);
				setState(123);
				numeric_value(0);
				setState(124);
				match(RPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(138);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(136);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new Numeric_valueContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_numeric_value);
						setState(128);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(129);
						aritmetic_operator_strong();
						setState(130);
						numeric_value(4);
						}
						break;
					case 2:
						{
						_localctx = new Numeric_valueContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_numeric_value);
						setState(132);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(133);
						aritmetic_operator_weak();
						setState(134);
						numeric_value(3);
						}
						break;
					}
					} 
				}
				setState(140);
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
		"\u0004\u0001\u001d\u008e\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0003\u0001\"\b\u0001\u0001\u0001\u0003"+
		"\u0001%\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004A\b\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0003\u0005K\b\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006S\b\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0003\u000bk\b\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0005\u000bq\b\u000b\n\u000b\f\u000bt\t\u000b\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003"+
		"\f\u007f\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0005\f\u0089\b\f\n\f\f\f\u008c\t\f\u0001\f\u0000\u0002\u0016\u0018"+
		"\r\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u0000"+
		"\u0004\u0001\u0000\f\u0011\u0001\u0000\u0012\u0013\u0001\u0000\b\n\u0001"+
		"\u0000\u0006\u0007\u0093\u0000\u001a\u0001\u0000\u0000\u0000\u0002!\u0001"+
		"\u0000\u0000\u0000\u0004&\u0001\u0000\u0000\u0000\u0006.\u0001\u0000\u0000"+
		"\u0000\b@\u0001\u0000\u0000\u0000\nJ\u0001\u0000\u0000\u0000\fR\u0001"+
		"\u0000\u0000\u0000\u000eT\u0001\u0000\u0000\u0000\u0010V\u0001\u0000\u0000"+
		"\u0000\u0012X\u0001\u0000\u0000\u0000\u0014Z\u0001\u0000\u0000\u0000\u0016"+
		"j\u0001\u0000\u0000\u0000\u0018~\u0001\u0000\u0000\u0000\u001a\u001b\u0003"+
		"\u0002\u0001\u0000\u001b\u0001\u0001\u0000\u0000\u0000\u001c\"\u0003\u0004"+
		"\u0002\u0000\u001d\"\u0003\u0006\u0003\u0000\u001e\"\u0003\b\u0004\u0000"+
		"\u001f\"\u0003\n\u0005\u0000 \"\u0003\f\u0006\u0000!\u001c\u0001\u0000"+
		"\u0000\u0000!\u001d\u0001\u0000\u0000\u0000!\u001e\u0001\u0000\u0000\u0000"+
		"!\u001f\u0001\u0000\u0000\u0000! \u0001\u0000\u0000\u0000\"$\u0001\u0000"+
		"\u0000\u0000#%\u0003\u0002\u0001\u0000$#\u0001\u0000\u0000\u0000$%\u0001"+
		"\u0000\u0000\u0000%\u0003\u0001\u0000\u0000\u0000&\'\u0005\u0017\u0000"+
		"\u0000\'(\u0005\u0002\u0000\u0000()\u0003\u0016\u000b\u0000)*\u0005\u0003"+
		"\u0000\u0000*+\u0005\u0004\u0000\u0000+,\u0003\u0002\u0001\u0000,-\u0005"+
		"\u0005\u0000\u0000-\u0005\u0001\u0000\u0000\u0000./\u0005\u0018\u0000"+
		"\u0000/0\u0005\u0002\u0000\u000001\u0003\u0016\u000b\u000012\u0005\u0003"+
		"\u0000\u000023\u0005\u0004\u0000\u000034\u0003\u0002\u0001\u000045\u0005"+
		"\u0005\u0000\u00005\u0007\u0001\u0000\u0000\u000067\u0005\u0019\u0000"+
		"\u000078\u0005\u0002\u0000\u000089\u0003\u0018\f\u00009:\u0005\u0003\u0000"+
		"\u0000:A\u0001\u0000\u0000\u0000;<\u0005\u0019\u0000\u0000<=\u0005\u0002"+
		"\u0000\u0000=>\u0003\u0016\u000b\u0000>?\u0005\u0003\u0000\u0000?A\u0001"+
		"\u0000\u0000\u0000@6\u0001\u0000\u0000\u0000@;\u0001\u0000\u0000\u0000"+
		"A\t\u0001\u0000\u0000\u0000BC\u0005\u001a\u0000\u0000CD\u0005\u0002\u0000"+
		"\u0000DE\u0005\u001c\u0000\u0000EK\u0005\u0003\u0000\u0000FG\u0005\u001a"+
		"\u0000\u0000GH\u0005\u0002\u0000\u0000HI\u0005\u001d\u0000\u0000IK\u0005"+
		"\u0003\u0000\u0000JB\u0001\u0000\u0000\u0000JF\u0001\u0000\u0000\u0000"+
		"K\u000b\u0001\u0000\u0000\u0000LM\u0005\u001c\u0000\u0000MN\u0005\u000b"+
		"\u0000\u0000NS\u0003\u0018\f\u0000OP\u0005\u001d\u0000\u0000PQ\u0005\u000b"+
		"\u0000\u0000QS\u0003\u0016\u000b\u0000RL\u0001\u0000\u0000\u0000RO\u0001"+
		"\u0000\u0000\u0000S\r\u0001\u0000\u0000\u0000TU\u0007\u0000\u0000\u0000"+
		"U\u000f\u0001\u0000\u0000\u0000VW\u0007\u0001\u0000\u0000W\u0011\u0001"+
		"\u0000\u0000\u0000XY\u0007\u0002\u0000\u0000Y\u0013\u0001\u0000\u0000"+
		"\u0000Z[\u0007\u0003\u0000\u0000[\u0015\u0001\u0000\u0000\u0000\\]\u0006"+
		"\u000b\uffff\uffff\u0000]k\u0005\u001d\u0000\u0000^k\u0005\u0015\u0000"+
		"\u0000_k\u0005\u0016\u0000\u0000`a\u0005\u0014\u0000\u0000ak\u0003\u0016"+
		"\u000b\u0004bc\u0003\u0018\f\u0000cd\u0003\u000e\u0007\u0000de\u0003\u0018"+
		"\f\u0000ek\u0001\u0000\u0000\u0000fg\u0005\u0002\u0000\u0000gh\u0003\u0016"+
		"\u000b\u0000hi\u0005\u0003\u0000\u0000ik\u0001\u0000\u0000\u0000j\\\u0001"+
		"\u0000\u0000\u0000j^\u0001\u0000\u0000\u0000j_\u0001\u0000\u0000\u0000"+
		"j`\u0001\u0000\u0000\u0000jb\u0001\u0000\u0000\u0000jf\u0001\u0000\u0000"+
		"\u0000kr\u0001\u0000\u0000\u0000lm\n\u0002\u0000\u0000mn\u0003\u0010\b"+
		"\u0000no\u0003\u0016\u000b\u0003oq\u0001\u0000\u0000\u0000pl\u0001\u0000"+
		"\u0000\u0000qt\u0001\u0000\u0000\u0000rp\u0001\u0000\u0000\u0000rs\u0001"+
		"\u0000\u0000\u0000s\u0017\u0001\u0000\u0000\u0000tr\u0001\u0000\u0000"+
		"\u0000uv\u0006\f\uffff\uffff\u0000v\u007f\u0005\u001b\u0000\u0000w\u007f"+
		"\u0005\u001c\u0000\u0000xy\u0005\u0007\u0000\u0000y\u007f\u0003\u0018"+
		"\f\u0004z{\u0005\u0002\u0000\u0000{|\u0003\u0018\f\u0000|}\u0005\u0003"+
		"\u0000\u0000}\u007f\u0001\u0000\u0000\u0000~u\u0001\u0000\u0000\u0000"+
		"~w\u0001\u0000\u0000\u0000~x\u0001\u0000\u0000\u0000~z\u0001\u0000\u0000"+
		"\u0000\u007f\u008a\u0001\u0000\u0000\u0000\u0080\u0081\n\u0003\u0000\u0000"+
		"\u0081\u0082\u0003\u0012\t\u0000\u0082\u0083\u0003\u0018\f\u0004\u0083"+
		"\u0089\u0001\u0000\u0000\u0000\u0084\u0085\n\u0002\u0000\u0000\u0085\u0086"+
		"\u0003\u0014\n\u0000\u0086\u0087\u0003\u0018\f\u0003\u0087\u0089\u0001"+
		"\u0000\u0000\u0000\u0088\u0080\u0001\u0000\u0000\u0000\u0088\u0084\u0001"+
		"\u0000\u0000\u0000\u0089\u008c\u0001\u0000\u0000\u0000\u008a\u0088\u0001"+
		"\u0000\u0000\u0000\u008a\u008b\u0001\u0000\u0000\u0000\u008b\u0019\u0001"+
		"\u0000\u0000\u0000\u008c\u008a\u0001\u0000\u0000\u0000\n!$@JRjr~\u0088"+
		"\u008a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}