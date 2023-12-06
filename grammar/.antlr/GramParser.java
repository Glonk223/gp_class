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
		WS=1, NEWLINE=2, LPAREN=3, RPAREN=4, LBRACE=5, RBRACE=6, SEMICOLON=7, 
		ADD=8, SUB=9, MUL=10, DIV=11, MOD=12, SIN=13, COS=14, ASS=15, EQ=16, NEQ=17, 
		LE=18, LEQ=19, GE=20, GEQ=21, AND=22, OR=23, NOT=24, TRUE=25, FALSE=26, 
		IF=27, WHILE=28, PRINT=29, SCAN=30, NUMBER=31, NUM_VAR=32, BOOL_VAR=33;
	public static final int
		RULE_program = 0, RULE_expr = 1, RULE_if_statement = 2, RULE_while_loop = 3, 
		RULE_block = 4, RULE_print_call = 5, RULE_scan_call = 6, RULE_assignment = 7, 
		RULE_comparisson_type = 8, RULE_logic_operator = 9, RULE_aritmetic_operator = 10, 
		RULE_trigonometric_operator = 11, RULE_bool_value = 12, RULE_numeric_value = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "expr", "if_statement", "while_loop", "block", "print_call", 
			"scan_call", "assignment", "comparisson_type", "logic_operator", "aritmetic_operator", 
			"trigonometric_operator", "bool_value", "numeric_value"
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
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(28);
				expr();
				}
				}
				setState(31); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 14898167840L) != 0) );
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
	public static class ExprContext extends ParserRuleContext {
		public If_statementContext if_statement() {
			return getRuleContext(If_statementContext.class,0);
		}
		public While_loopContext while_loop() {
			return getRuleContext(While_loopContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
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
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_expr);
		try {
			setState(39);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(33);
				if_statement();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 2);
				{
				setState(34);
				while_loop();
				}
				break;
			case LBRACE:
				enterOuterAlt(_localctx, 3);
				{
				setState(35);
				block();
				}
				break;
			case PRINT:
				enterOuterAlt(_localctx, 4);
				{
				setState(36);
				print_call();
				}
				break;
			case SCAN:
				enterOuterAlt(_localctx, 5);
				{
				setState(37);
				scan_call();
				}
				break;
			case NUM_VAR:
			case BOOL_VAR:
				enterOuterAlt(_localctx, 6);
				{
				setState(38);
				assignment();
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
	public static class If_statementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(GramParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(GramParser.LPAREN, 0); }
		public Bool_valueContext bool_value() {
			return getRuleContext(Bool_valueContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(GramParser.RPAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
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
			setState(41);
			match(IF);
			setState(42);
			match(LPAREN);
			setState(43);
			bool_value(0);
			setState(44);
			match(RPAREN);
			setState(45);
			block();
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
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
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
			block();
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
	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(GramParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(GramParser.RBRACE, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			match(LBRACE);
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 14898167840L) != 0)) {
				{
				{
				setState(54);
				expr();
				}
				}
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(60);
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
		public TerminalNode SEMICOLON() { return getToken(GramParser.SEMICOLON, 0); }
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
		enterRule(_localctx, 10, RULE_print_call);
		try {
			setState(74);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				match(PRINT);
				setState(63);
				match(LPAREN);
				setState(64);
				numeric_value(0);
				setState(65);
				match(RPAREN);
				setState(66);
				match(SEMICOLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(68);
				match(PRINT);
				setState(69);
				match(LPAREN);
				setState(70);
				bool_value(0);
				setState(71);
				match(RPAREN);
				setState(72);
				match(SEMICOLON);
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
		public TerminalNode SEMICOLON() { return getToken(GramParser.SEMICOLON, 0); }
		public TerminalNode BOOL_VAR() { return getToken(GramParser.BOOL_VAR, 0); }
		public Scan_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scan_call; }
	}

	public final Scan_callContext scan_call() throws RecognitionException {
		Scan_callContext _localctx = new Scan_callContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_scan_call);
		try {
			setState(86);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(76);
				match(SCAN);
				setState(77);
				match(LPAREN);
				setState(78);
				match(NUM_VAR);
				setState(79);
				match(RPAREN);
				setState(80);
				match(SEMICOLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(81);
				match(SCAN);
				setState(82);
				match(LPAREN);
				setState(83);
				match(BOOL_VAR);
				setState(84);
				match(RPAREN);
				setState(85);
				match(SEMICOLON);
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
		public TerminalNode SEMICOLON() { return getToken(GramParser.SEMICOLON, 0); }
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
		enterRule(_localctx, 14, RULE_assignment);
		try {
			setState(98);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUM_VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(88);
				match(NUM_VAR);
				setState(89);
				match(ASS);
				setState(90);
				numeric_value(0);
				setState(91);
				match(SEMICOLON);
				}
				break;
			case BOOL_VAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(93);
				match(BOOL_VAR);
				setState(94);
				match(ASS);
				setState(95);
				bool_value(0);
				setState(96);
				match(SEMICOLON);
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
		enterRule(_localctx, 16, RULE_comparisson_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4128768L) != 0)) ) {
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
		enterRule(_localctx, 18, RULE_logic_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
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
	public static class Aritmetic_operatorContext extends ParserRuleContext {
		public TerminalNode ADD() { return getToken(GramParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(GramParser.SUB, 0); }
		public TerminalNode MUL() { return getToken(GramParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(GramParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(GramParser.MOD, 0); }
		public Aritmetic_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aritmetic_operator; }
	}

	public final Aritmetic_operatorContext aritmetic_operator() throws RecognitionException {
		Aritmetic_operatorContext _localctx = new Aritmetic_operatorContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_aritmetic_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 7936L) != 0)) ) {
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
	public static class Trigonometric_operatorContext extends ParserRuleContext {
		public TerminalNode SIN() { return getToken(GramParser.SIN, 0); }
		public TerminalNode COS() { return getToken(GramParser.COS, 0); }
		public Trigonometric_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trigonometric_operator; }
	}

	public final Trigonometric_operatorContext trigonometric_operator() throws RecognitionException {
		Trigonometric_operatorContext _localctx = new Trigonometric_operatorContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_trigonometric_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			_la = _input.LA(1);
			if ( !(_la==SIN || _la==COS) ) {
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
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_bool_value, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(109);
				match(BOOL_VAR);
				}
				break;
			case 2:
				{
				setState(110);
				match(TRUE);
				}
				break;
			case 3:
				{
				setState(111);
				match(FALSE);
				}
				break;
			case 4:
				{
				setState(112);
				match(NOT);
				setState(113);
				bool_value(4);
				}
				break;
			case 5:
				{
				setState(114);
				numeric_value(0);
				setState(115);
				comparisson_type();
				setState(116);
				numeric_value(0);
				}
				break;
			case 6:
				{
				setState(118);
				match(LPAREN);
				setState(119);
				bool_value(0);
				setState(120);
				match(RPAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(130);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Bool_valueContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_bool_value);
					setState(124);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(125);
					logic_operator();
					setState(126);
					bool_value(3);
					}
					} 
				}
				setState(132);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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
		public Trigonometric_operatorContext trigonometric_operator() {
			return getRuleContext(Trigonometric_operatorContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(GramParser.LPAREN, 0); }
		public List<Numeric_valueContext> numeric_value() {
			return getRuleContexts(Numeric_valueContext.class);
		}
		public Numeric_valueContext numeric_value(int i) {
			return getRuleContext(Numeric_valueContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(GramParser.RPAREN, 0); }
		public TerminalNode MUL() { return getToken(GramParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(GramParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(GramParser.MOD, 0); }
		public TerminalNode ADD() { return getToken(GramParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(GramParser.SUB, 0); }
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
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_numeric_value, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				{
				setState(134);
				match(NUMBER);
				}
				break;
			case NUM_VAR:
				{
				setState(135);
				match(NUM_VAR);
				}
				break;
			case SIN:
			case COS:
				{
				setState(136);
				trigonometric_operator();
				setState(137);
				match(LPAREN);
				setState(138);
				numeric_value(0);
				setState(139);
				match(RPAREN);
				}
				break;
			case LPAREN:
				{
				setState(141);
				match(LPAREN);
				setState(142);
				numeric_value(0);
				setState(143);
				match(RPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(155);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(153);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new Numeric_valueContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_numeric_value);
						setState(147);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(148);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 7168L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(149);
						numeric_value(5);
						}
						break;
					case 2:
						{
						_localctx = new Numeric_valueContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_numeric_value);
						setState(150);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(151);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(152);
						numeric_value(4);
						}
						break;
					}
					} 
				}
				setState(157);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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
		case 12:
			return bool_value_sempred((Bool_valueContext)_localctx, predIndex);
		case 13:
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
			return precpred(_ctx, 4);
		case 2:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001!\u009f\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0004\u0000\u001e\b\u0000\u000b"+
		"\u0000\f\u0000\u001f\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0003\u0001(\b\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0005"+
		"\u00048\b\u0004\n\u0004\f\u0004;\t\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003"+
		"\u0005K\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003"+
		"\u0006W\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003"+
		"\u0007c\b\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f{\b"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u0081\b\f\n\f\f\f\u0084\t\f"+
		"\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0003\r\u0092\b\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0005\r\u009a\b\r\n\r\f\r\u009d\t\r\u0001\r\u0000\u0002"+
		"\u0018\u001a\u000e\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"+
		"\u0016\u0018\u001a\u0000\u0006\u0001\u0000\u0010\u0015\u0001\u0000\u0016"+
		"\u0017\u0001\u0000\b\f\u0001\u0000\r\u000e\u0001\u0000\n\f\u0001\u0000"+
		"\b\t\u00a5\u0000\u001d\u0001\u0000\u0000\u0000\u0002\'\u0001\u0000\u0000"+
		"\u0000\u0004)\u0001\u0000\u0000\u0000\u0006/\u0001\u0000\u0000\u0000\b"+
		"5\u0001\u0000\u0000\u0000\nJ\u0001\u0000\u0000\u0000\fV\u0001\u0000\u0000"+
		"\u0000\u000eb\u0001\u0000\u0000\u0000\u0010d\u0001\u0000\u0000\u0000\u0012"+
		"f\u0001\u0000\u0000\u0000\u0014h\u0001\u0000\u0000\u0000\u0016j\u0001"+
		"\u0000\u0000\u0000\u0018z\u0001\u0000\u0000\u0000\u001a\u0091\u0001\u0000"+
		"\u0000\u0000\u001c\u001e\u0003\u0002\u0001\u0000\u001d\u001c\u0001\u0000"+
		"\u0000\u0000\u001e\u001f\u0001\u0000\u0000\u0000\u001f\u001d\u0001\u0000"+
		"\u0000\u0000\u001f \u0001\u0000\u0000\u0000 \u0001\u0001\u0000\u0000\u0000"+
		"!(\u0003\u0004\u0002\u0000\"(\u0003\u0006\u0003\u0000#(\u0003\b\u0004"+
		"\u0000$(\u0003\n\u0005\u0000%(\u0003\f\u0006\u0000&(\u0003\u000e\u0007"+
		"\u0000\'!\u0001\u0000\u0000\u0000\'\"\u0001\u0000\u0000\u0000\'#\u0001"+
		"\u0000\u0000\u0000\'$\u0001\u0000\u0000\u0000\'%\u0001\u0000\u0000\u0000"+
		"\'&\u0001\u0000\u0000\u0000(\u0003\u0001\u0000\u0000\u0000)*\u0005\u001b"+
		"\u0000\u0000*+\u0005\u0003\u0000\u0000+,\u0003\u0018\f\u0000,-\u0005\u0004"+
		"\u0000\u0000-.\u0003\b\u0004\u0000.\u0005\u0001\u0000\u0000\u0000/0\u0005"+
		"\u001c\u0000\u000001\u0005\u0003\u0000\u000012\u0003\u0018\f\u000023\u0005"+
		"\u0004\u0000\u000034\u0003\b\u0004\u00004\u0007\u0001\u0000\u0000\u0000"+
		"59\u0005\u0005\u0000\u000068\u0003\u0002\u0001\u000076\u0001\u0000\u0000"+
		"\u00008;\u0001\u0000\u0000\u000097\u0001\u0000\u0000\u00009:\u0001\u0000"+
		"\u0000\u0000:<\u0001\u0000\u0000\u0000;9\u0001\u0000\u0000\u0000<=\u0005"+
		"\u0006\u0000\u0000=\t\u0001\u0000\u0000\u0000>?\u0005\u001d\u0000\u0000"+
		"?@\u0005\u0003\u0000\u0000@A\u0003\u001a\r\u0000AB\u0005\u0004\u0000\u0000"+
		"BC\u0005\u0007\u0000\u0000CK\u0001\u0000\u0000\u0000DE\u0005\u001d\u0000"+
		"\u0000EF\u0005\u0003\u0000\u0000FG\u0003\u0018\f\u0000GH\u0005\u0004\u0000"+
		"\u0000HI\u0005\u0007\u0000\u0000IK\u0001\u0000\u0000\u0000J>\u0001\u0000"+
		"\u0000\u0000JD\u0001\u0000\u0000\u0000K\u000b\u0001\u0000\u0000\u0000"+
		"LM\u0005\u001e\u0000\u0000MN\u0005\u0003\u0000\u0000NO\u0005 \u0000\u0000"+
		"OP\u0005\u0004\u0000\u0000PW\u0005\u0007\u0000\u0000QR\u0005\u001e\u0000"+
		"\u0000RS\u0005\u0003\u0000\u0000ST\u0005!\u0000\u0000TU\u0005\u0004\u0000"+
		"\u0000UW\u0005\u0007\u0000\u0000VL\u0001\u0000\u0000\u0000VQ\u0001\u0000"+
		"\u0000\u0000W\r\u0001\u0000\u0000\u0000XY\u0005 \u0000\u0000YZ\u0005\u000f"+
		"\u0000\u0000Z[\u0003\u001a\r\u0000[\\\u0005\u0007\u0000\u0000\\c\u0001"+
		"\u0000\u0000\u0000]^\u0005!\u0000\u0000^_\u0005\u000f\u0000\u0000_`\u0003"+
		"\u0018\f\u0000`a\u0005\u0007\u0000\u0000ac\u0001\u0000\u0000\u0000bX\u0001"+
		"\u0000\u0000\u0000b]\u0001\u0000\u0000\u0000c\u000f\u0001\u0000\u0000"+
		"\u0000de\u0007\u0000\u0000\u0000e\u0011\u0001\u0000\u0000\u0000fg\u0007"+
		"\u0001\u0000\u0000g\u0013\u0001\u0000\u0000\u0000hi\u0007\u0002\u0000"+
		"\u0000i\u0015\u0001\u0000\u0000\u0000jk\u0007\u0003\u0000\u0000k\u0017"+
		"\u0001\u0000\u0000\u0000lm\u0006\f\uffff\uffff\u0000m{\u0005!\u0000\u0000"+
		"n{\u0005\u0019\u0000\u0000o{\u0005\u001a\u0000\u0000pq\u0005\u0018\u0000"+
		"\u0000q{\u0003\u0018\f\u0004rs\u0003\u001a\r\u0000st\u0003\u0010\b\u0000"+
		"tu\u0003\u001a\r\u0000u{\u0001\u0000\u0000\u0000vw\u0005\u0003\u0000\u0000"+
		"wx\u0003\u0018\f\u0000xy\u0005\u0004\u0000\u0000y{\u0001\u0000\u0000\u0000"+
		"zl\u0001\u0000\u0000\u0000zn\u0001\u0000\u0000\u0000zo\u0001\u0000\u0000"+
		"\u0000zp\u0001\u0000\u0000\u0000zr\u0001\u0000\u0000\u0000zv\u0001\u0000"+
		"\u0000\u0000{\u0082\u0001\u0000\u0000\u0000|}\n\u0002\u0000\u0000}~\u0003"+
		"\u0012\t\u0000~\u007f\u0003\u0018\f\u0003\u007f\u0081\u0001\u0000\u0000"+
		"\u0000\u0080|\u0001\u0000\u0000\u0000\u0081\u0084\u0001\u0000\u0000\u0000"+
		"\u0082\u0080\u0001\u0000\u0000\u0000\u0082\u0083\u0001\u0000\u0000\u0000"+
		"\u0083\u0019\u0001\u0000\u0000\u0000\u0084\u0082\u0001\u0000\u0000\u0000"+
		"\u0085\u0086\u0006\r\uffff\uffff\u0000\u0086\u0092\u0005\u001f\u0000\u0000"+
		"\u0087\u0092\u0005 \u0000\u0000\u0088\u0089\u0003\u0016\u000b\u0000\u0089"+
		"\u008a\u0005\u0003\u0000\u0000\u008a\u008b\u0003\u001a\r\u0000\u008b\u008c"+
		"\u0005\u0004\u0000\u0000\u008c\u0092\u0001\u0000\u0000\u0000\u008d\u008e"+
		"\u0005\u0003\u0000\u0000\u008e\u008f\u0003\u001a\r\u0000\u008f\u0090\u0005"+
		"\u0004\u0000\u0000\u0090\u0092\u0001\u0000\u0000\u0000\u0091\u0085\u0001"+
		"\u0000\u0000\u0000\u0091\u0087\u0001\u0000\u0000\u0000\u0091\u0088\u0001"+
		"\u0000\u0000\u0000\u0091\u008d\u0001\u0000\u0000\u0000\u0092\u009b\u0001"+
		"\u0000\u0000\u0000\u0093\u0094\n\u0004\u0000\u0000\u0094\u0095\u0007\u0004"+
		"\u0000\u0000\u0095\u009a\u0003\u001a\r\u0005\u0096\u0097\n\u0003\u0000"+
		"\u0000\u0097\u0098\u0007\u0005\u0000\u0000\u0098\u009a\u0003\u001a\r\u0004"+
		"\u0099\u0093\u0001\u0000\u0000\u0000\u0099\u0096\u0001\u0000\u0000\u0000"+
		"\u009a\u009d\u0001\u0000\u0000\u0000\u009b\u0099\u0001\u0000\u0000\u0000"+
		"\u009b\u009c\u0001\u0000\u0000\u0000\u009c\u001b\u0001\u0000\u0000\u0000"+
		"\u009d\u009b\u0001\u0000\u0000\u0000\u000b\u001f\'9JVbz\u0082\u0091\u0099"+
		"\u009b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}