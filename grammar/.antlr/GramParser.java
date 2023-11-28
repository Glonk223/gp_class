// Generated from /Users/jakubwadrzyk/Documents/Studia/Semestr 5/Programowanie Genetyczne/gp_class/grammar/Gram.g4 by ANTLR 4.13.1
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
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 14898167844L) != 0) );
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
		public List<TerminalNode> NEWLINE() { return getTokens(GramParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(GramParser.NEWLINE, i);
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
			int _alt;
			setState(44);
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
			case NEWLINE:
				enterOuterAlt(_localctx, 7);
				{
				setState(40); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(39);
						match(NEWLINE);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(42); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
		public TerminalNode NEWLINE() { return getToken(GramParser.NEWLINE, 0); }
		public If_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_statement; }
	}

	public final If_statementContext if_statement() throws RecognitionException {
		If_statementContext _localctx = new If_statementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_if_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			match(IF);
			setState(47);
			match(LPAREN);
			setState(48);
			bool_value();
			setState(49);
			match(RPAREN);
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEWLINE) {
				{
				setState(50);
				match(NEWLINE);
				}
			}

			setState(53);
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
		public TerminalNode NEWLINE() { return getToken(GramParser.NEWLINE, 0); }
		public While_loopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_loop; }
	}

	public final While_loopContext while_loop() throws RecognitionException {
		While_loopContext _localctx = new While_loopContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_while_loop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(WHILE);
			setState(56);
			match(LPAREN);
			setState(57);
			bool_value();
			setState(58);
			match(RPAREN);
			setState(60);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEWLINE) {
				{
				setState(59);
				match(NEWLINE);
				}
			}

			setState(62);
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
			setState(64);
			match(LBRACE);
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 14898167844L) != 0)) {
				{
				{
				setState(65);
				expr();
				}
				}
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(71);
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
			setState(85);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(73);
				match(PRINT);
				setState(74);
				match(LPAREN);
				setState(75);
				numeric_value(0);
				setState(76);
				match(RPAREN);
				setState(77);
				match(SEMICOLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(79);
				match(PRINT);
				setState(80);
				match(LPAREN);
				setState(81);
				bool_value();
				setState(82);
				match(RPAREN);
				setState(83);
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
			setState(97);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(87);
				match(SCAN);
				setState(88);
				match(LPAREN);
				setState(89);
				match(NUM_VAR);
				setState(90);
				match(RPAREN);
				setState(91);
				match(SEMICOLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(92);
				match(SCAN);
				setState(93);
				match(LPAREN);
				setState(94);
				match(BOOL_VAR);
				setState(95);
				match(RPAREN);
				setState(96);
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
			setState(109);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUM_VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(99);
				match(NUM_VAR);
				setState(100);
				match(ASS);
				setState(101);
				numeric_value(0);
				setState(102);
				match(SEMICOLON);
				}
				break;
			case BOOL_VAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(104);
				match(BOOL_VAR);
				setState(105);
				match(ASS);
				setState(106);
				bool_value();
				setState(107);
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
			setState(111);
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
			setState(113);
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
			setState(115);
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
			setState(117);
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
		public TerminalNode LPAREN() { return getToken(GramParser.LPAREN, 0); }
		public Logic_operatorContext logic_operator() {
			return getRuleContext(Logic_operatorContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(GramParser.RPAREN, 0); }
		public List<Numeric_valueContext> numeric_value() {
			return getRuleContexts(Numeric_valueContext.class);
		}
		public Numeric_valueContext numeric_value(int i) {
			return getRuleContext(Numeric_valueContext.class,i);
		}
		public Comparisson_typeContext comparisson_type() {
			return getRuleContext(Comparisson_typeContext.class,0);
		}
		public Bool_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool_value; }
	}

	public final Bool_valueContext bool_value() throws RecognitionException {
		Bool_valueContext _localctx = new Bool_valueContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_bool_value);
		try {
			setState(136);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(119);
				match(BOOL_VAR);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(120);
				match(TRUE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(121);
				match(FALSE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(122);
				match(NOT);
				setState(123);
				bool_value();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(124);
				match(LPAREN);
				setState(125);
				bool_value();
				setState(126);
				logic_operator();
				setState(127);
				bool_value();
				setState(128);
				match(RPAREN);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(130);
				match(LPAREN);
				setState(131);
				numeric_value(0);
				setState(132);
				comparisson_type();
				setState(133);
				numeric_value(0);
				setState(134);
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
			setState(150);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				{
				setState(139);
				match(NUMBER);
				}
				break;
			case NUM_VAR:
				{
				setState(140);
				match(NUM_VAR);
				}
				break;
			case SIN:
			case COS:
				{
				setState(141);
				trigonometric_operator();
				setState(142);
				match(LPAREN);
				setState(143);
				numeric_value(0);
				setState(144);
				match(RPAREN);
				}
				break;
			case LPAREN:
				{
				setState(146);
				match(LPAREN);
				setState(147);
				numeric_value(0);
				setState(148);
				match(RPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(160);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(158);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new Numeric_valueContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_numeric_value);
						setState(152);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(153);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 7168L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(154);
						numeric_value(5);
						}
						break;
					case 2:
						{
						_localctx = new Numeric_valueContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_numeric_value);
						setState(155);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(156);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(157);
						numeric_value(4);
						}
						break;
					}
					} 
				}
				setState(162);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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
		case 13:
			return numeric_value_sempred((Numeric_valueContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean numeric_value_sempred(Numeric_valueContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001!\u00a4\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0004\u0000\u001e\b\u0000\u000b"+
		"\u0000\f\u0000\u001f\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0004\u0001)\b\u0001\u000b\u0001\f\u0001"+
		"*\u0003\u0001-\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0003\u00024\b\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003=\b\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0005\u0004C\b\u0004"+
		"\n\u0004\f\u0004F\t\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005V\b\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006b\b\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007n\b\u0007"+
		"\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003"+
		"\f\u0089\b\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u0097\b\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0005\r\u009f\b\r\n\r\f\r\u00a2\t\r\u0001\r"+
		"\u0000\u0001\u001a\u000e\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0018\u001a\u0000\u0006\u0001\u0000\u0010\u0015\u0001\u0000"+
		"\u0016\u0017\u0001\u0000\b\f\u0001\u0000\r\u000e\u0001\u0000\n\f\u0001"+
		"\u0000\b\t\u00ad\u0000\u001d\u0001\u0000\u0000\u0000\u0002,\u0001\u0000"+
		"\u0000\u0000\u0004.\u0001\u0000\u0000\u0000\u00067\u0001\u0000\u0000\u0000"+
		"\b@\u0001\u0000\u0000\u0000\nU\u0001\u0000\u0000\u0000\fa\u0001\u0000"+
		"\u0000\u0000\u000em\u0001\u0000\u0000\u0000\u0010o\u0001\u0000\u0000\u0000"+
		"\u0012q\u0001\u0000\u0000\u0000\u0014s\u0001\u0000\u0000\u0000\u0016u"+
		"\u0001\u0000\u0000\u0000\u0018\u0088\u0001\u0000\u0000\u0000\u001a\u0096"+
		"\u0001\u0000\u0000\u0000\u001c\u001e\u0003\u0002\u0001\u0000\u001d\u001c"+
		"\u0001\u0000\u0000\u0000\u001e\u001f\u0001\u0000\u0000\u0000\u001f\u001d"+
		"\u0001\u0000\u0000\u0000\u001f \u0001\u0000\u0000\u0000 \u0001\u0001\u0000"+
		"\u0000\u0000!-\u0003\u0004\u0002\u0000\"-\u0003\u0006\u0003\u0000#-\u0003"+
		"\b\u0004\u0000$-\u0003\n\u0005\u0000%-\u0003\f\u0006\u0000&-\u0003\u000e"+
		"\u0007\u0000\')\u0005\u0002\u0000\u0000(\'\u0001\u0000\u0000\u0000)*\u0001"+
		"\u0000\u0000\u0000*(\u0001\u0000\u0000\u0000*+\u0001\u0000\u0000\u0000"+
		"+-\u0001\u0000\u0000\u0000,!\u0001\u0000\u0000\u0000,\"\u0001\u0000\u0000"+
		"\u0000,#\u0001\u0000\u0000\u0000,$\u0001\u0000\u0000\u0000,%\u0001\u0000"+
		"\u0000\u0000,&\u0001\u0000\u0000\u0000,(\u0001\u0000\u0000\u0000-\u0003"+
		"\u0001\u0000\u0000\u0000./\u0005\u001b\u0000\u0000/0\u0005\u0003\u0000"+
		"\u000001\u0003\u0018\f\u000013\u0005\u0004\u0000\u000024\u0005\u0002\u0000"+
		"\u000032\u0001\u0000\u0000\u000034\u0001\u0000\u0000\u000045\u0001\u0000"+
		"\u0000\u000056\u0003\b\u0004\u00006\u0005\u0001\u0000\u0000\u000078\u0005"+
		"\u001c\u0000\u000089\u0005\u0003\u0000\u00009:\u0003\u0018\f\u0000:<\u0005"+
		"\u0004\u0000\u0000;=\u0005\u0002\u0000\u0000<;\u0001\u0000\u0000\u0000"+
		"<=\u0001\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000>?\u0003\b\u0004\u0000"+
		"?\u0007\u0001\u0000\u0000\u0000@D\u0005\u0005\u0000\u0000AC\u0003\u0002"+
		"\u0001\u0000BA\u0001\u0000\u0000\u0000CF\u0001\u0000\u0000\u0000DB\u0001"+
		"\u0000\u0000\u0000DE\u0001\u0000\u0000\u0000EG\u0001\u0000\u0000\u0000"+
		"FD\u0001\u0000\u0000\u0000GH\u0005\u0006\u0000\u0000H\t\u0001\u0000\u0000"+
		"\u0000IJ\u0005\u001d\u0000\u0000JK\u0005\u0003\u0000\u0000KL\u0003\u001a"+
		"\r\u0000LM\u0005\u0004\u0000\u0000MN\u0005\u0007\u0000\u0000NV\u0001\u0000"+
		"\u0000\u0000OP\u0005\u001d\u0000\u0000PQ\u0005\u0003\u0000\u0000QR\u0003"+
		"\u0018\f\u0000RS\u0005\u0004\u0000\u0000ST\u0005\u0007\u0000\u0000TV\u0001"+
		"\u0000\u0000\u0000UI\u0001\u0000\u0000\u0000UO\u0001\u0000\u0000\u0000"+
		"V\u000b\u0001\u0000\u0000\u0000WX\u0005\u001e\u0000\u0000XY\u0005\u0003"+
		"\u0000\u0000YZ\u0005 \u0000\u0000Z[\u0005\u0004\u0000\u0000[b\u0005\u0007"+
		"\u0000\u0000\\]\u0005\u001e\u0000\u0000]^\u0005\u0003\u0000\u0000^_\u0005"+
		"!\u0000\u0000_`\u0005\u0004\u0000\u0000`b\u0005\u0007\u0000\u0000aW\u0001"+
		"\u0000\u0000\u0000a\\\u0001\u0000\u0000\u0000b\r\u0001\u0000\u0000\u0000"+
		"cd\u0005 \u0000\u0000de\u0005\u000f\u0000\u0000ef\u0003\u001a\r\u0000"+
		"fg\u0005\u0007\u0000\u0000gn\u0001\u0000\u0000\u0000hi\u0005!\u0000\u0000"+
		"ij\u0005\u000f\u0000\u0000jk\u0003\u0018\f\u0000kl\u0005\u0007\u0000\u0000"+
		"ln\u0001\u0000\u0000\u0000mc\u0001\u0000\u0000\u0000mh\u0001\u0000\u0000"+
		"\u0000n\u000f\u0001\u0000\u0000\u0000op\u0007\u0000\u0000\u0000p\u0011"+
		"\u0001\u0000\u0000\u0000qr\u0007\u0001\u0000\u0000r\u0013\u0001\u0000"+
		"\u0000\u0000st\u0007\u0002\u0000\u0000t\u0015\u0001\u0000\u0000\u0000"+
		"uv\u0007\u0003\u0000\u0000v\u0017\u0001\u0000\u0000\u0000w\u0089\u0005"+
		"!\u0000\u0000x\u0089\u0005\u0019\u0000\u0000y\u0089\u0005\u001a\u0000"+
		"\u0000z{\u0005\u0018\u0000\u0000{\u0089\u0003\u0018\f\u0000|}\u0005\u0003"+
		"\u0000\u0000}~\u0003\u0018\f\u0000~\u007f\u0003\u0012\t\u0000\u007f\u0080"+
		"\u0003\u0018\f\u0000\u0080\u0081\u0005\u0004\u0000\u0000\u0081\u0089\u0001"+
		"\u0000\u0000\u0000\u0082\u0083\u0005\u0003\u0000\u0000\u0083\u0084\u0003"+
		"\u001a\r\u0000\u0084\u0085\u0003\u0010\b\u0000\u0085\u0086\u0003\u001a"+
		"\r\u0000\u0086\u0087\u0005\u0004\u0000\u0000\u0087\u0089\u0001\u0000\u0000"+
		"\u0000\u0088w\u0001\u0000\u0000\u0000\u0088x\u0001\u0000\u0000\u0000\u0088"+
		"y\u0001\u0000\u0000\u0000\u0088z\u0001\u0000\u0000\u0000\u0088|\u0001"+
		"\u0000\u0000\u0000\u0088\u0082\u0001\u0000\u0000\u0000\u0089\u0019\u0001"+
		"\u0000\u0000\u0000\u008a\u008b\u0006\r\uffff\uffff\u0000\u008b\u0097\u0005"+
		"\u001f\u0000\u0000\u008c\u0097\u0005 \u0000\u0000\u008d\u008e\u0003\u0016"+
		"\u000b\u0000\u008e\u008f\u0005\u0003\u0000\u0000\u008f\u0090\u0003\u001a"+
		"\r\u0000\u0090\u0091\u0005\u0004\u0000\u0000\u0091\u0097\u0001\u0000\u0000"+
		"\u0000\u0092\u0093\u0005\u0003\u0000\u0000\u0093\u0094\u0003\u001a\r\u0000"+
		"\u0094\u0095\u0005\u0004\u0000\u0000\u0095\u0097\u0001\u0000\u0000\u0000"+
		"\u0096\u008a\u0001\u0000\u0000\u0000\u0096\u008c\u0001\u0000\u0000\u0000"+
		"\u0096\u008d\u0001\u0000\u0000\u0000\u0096\u0092\u0001\u0000\u0000\u0000"+
		"\u0097\u00a0\u0001\u0000\u0000\u0000\u0098\u0099\n\u0004\u0000\u0000\u0099"+
		"\u009a\u0007\u0004\u0000\u0000\u009a\u009f\u0003\u001a\r\u0005\u009b\u009c"+
		"\n\u0003\u0000\u0000\u009c\u009d\u0007\u0005\u0000\u0000\u009d\u009f\u0003"+
		"\u001a\r\u0004\u009e\u0098\u0001\u0000\u0000\u0000\u009e\u009b\u0001\u0000"+
		"\u0000\u0000\u009f\u00a2\u0001\u0000\u0000\u0000\u00a0\u009e\u0001\u0000"+
		"\u0000\u0000\u00a0\u00a1\u0001\u0000\u0000\u0000\u00a1\u001b\u0001\u0000"+
		"\u0000\u0000\u00a2\u00a0\u0001\u0000\u0000\u0000\r\u001f*,3<DUam\u0088"+
		"\u0096\u009e\u00a0";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}