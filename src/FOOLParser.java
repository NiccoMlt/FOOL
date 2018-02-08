// Generated from FOOL.g4 by ANTLR 4.7

import java.util.ArrayList;
import java.util.HashMap;	
import ast.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FOOLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COLON=1, COMMA=2, EQ=3, ASS=4, SEMIC=5, PLUS=6, TIMES=7, INTEGER=8, TRUE=9, 
		FALSE=10, LPAR=11, RPAR=12, CLPAR=13, CRPAR=14, IF=15, THEN=16, ELSE=17, 
		PRINT=18, LET=19, IN=20, VAR=21, FUN=22, INT=23, BOOL=24, ID=25, WHITESP=26, 
		COMMENT=27, ERR=28;
	public static final int
		RULE_prog = 0, RULE_declist = 1, RULE_type = 2, RULE_exp = 3, RULE_term = 4, 
		RULE_factor = 5, RULE_value = 6;
	public static final String[] ruleNames = {
		"prog", "declist", "type", "exp", "term", "factor", "value"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "':'", "','", "'=='", "'='", "';'", "'+'", "'*'", null, "'true'", 
		"'false'", "'('", "')'", "'{'", "'}'", "'if'", "'then'", "'else'", "'print'", 
		"'let'", "'in'", "'var'", "'fun'", "'int'", "'bool'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "COLON", "COMMA", "EQ", "ASS", "SEMIC", "PLUS", "TIMES", "INTEGER", 
		"TRUE", "FALSE", "LPAR", "RPAR", "CLPAR", "CRPAR", "IF", "THEN", "ELSE", 
		"PRINT", "LET", "IN", "VAR", "FUN", "INT", "BOOL", "ID", "WHITESP", "COMMENT", 
		"ERR"
	};
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
	public String getGrammarFileName() { return "FOOL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	private int nestingLevel = 0;
	private ArrayList<HashMap<String,STentry>> symTable = new ArrayList<HashMap<String,STentry>>();
	//livello ambiente con dichiarazioni piu' esterno è 0 (invece che 1 nelle slides)
	//il "fronte" della lista di tabelle è "symTable.get(nestingLevel)"

	public FOOLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public Node ast;
		public ExpContext e;
		public DeclistContext d;
		public TerminalNode SEMIC() { return getToken(FOOLParser.SEMIC, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode LET() { return getToken(FOOLParser.LET, 0); }
		public TerminalNode IN() { return getToken(FOOLParser.IN, 0); }
		public DeclistContext declist() {
			return getRuleContext(DeclistContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			setState(26);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER:
			case TRUE:
			case FALSE:
			case LPAR:
			case IF:
			case PRINT:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(14);
				((ProgContext)_localctx).e = exp();
				setState(15);
				match(SEMIC);
				((ProgContext)_localctx).ast =  new ProgNode(((ProgContext)_localctx).e.ast);
				}
				break;
			case LET:
				enterOuterAlt(_localctx, 2);
				{
				setState(18);
				match(LET);
				HashMap<String,STentry> hm= new HashMap<String,STentry>();
				    	   symTable.add(hm);
				          
				setState(20);
				((ProgContext)_localctx).d = declist();
				setState(21);
				match(IN);
				setState(22);
				((ProgContext)_localctx).e = exp();
				setState(23);
				match(SEMIC);
				((ProgContext)_localctx).ast =  new ProgLetInNode(((ProgContext)_localctx).d.astlist,((ProgContext)_localctx).e.ast);
				           symTable.remove(nestingLevel);
				          
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

	public static class DeclistContext extends ParserRuleContext {
		public ArrayList<Node> astlist;
		public Token i;
		public TypeContext t;
		public ExpContext e;
		public DeclistContext d;
		public List<TerminalNode> SEMIC() { return getTokens(FOOLParser.SEMIC); }
		public TerminalNode SEMIC(int i) {
			return getToken(FOOLParser.SEMIC, i);
		}
		public List<TerminalNode> VAR() { return getTokens(FOOLParser.VAR); }
		public TerminalNode VAR(int i) {
			return getToken(FOOLParser.VAR, i);
		}
		public List<TerminalNode> COLON() { return getTokens(FOOLParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(FOOLParser.COLON, i);
		}
		public List<TerminalNode> ASS() { return getTokens(FOOLParser.ASS); }
		public TerminalNode ASS(int i) {
			return getToken(FOOLParser.ASS, i);
		}
		public List<TerminalNode> FUN() { return getTokens(FOOLParser.FUN); }
		public TerminalNode FUN(int i) {
			return getToken(FOOLParser.FUN, i);
		}
		public List<TerminalNode> LPAR() { return getTokens(FOOLParser.LPAR); }
		public TerminalNode LPAR(int i) {
			return getToken(FOOLParser.LPAR, i);
		}
		public List<TerminalNode> RPAR() { return getTokens(FOOLParser.RPAR); }
		public TerminalNode RPAR(int i) {
			return getToken(FOOLParser.RPAR, i);
		}
		public List<TerminalNode> ID() { return getTokens(FOOLParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(FOOLParser.ID, i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public List<TerminalNode> LET() { return getTokens(FOOLParser.LET); }
		public TerminalNode LET(int i) {
			return getToken(FOOLParser.LET, i);
		}
		public List<TerminalNode> IN() { return getTokens(FOOLParser.IN); }
		public TerminalNode IN(int i) {
			return getToken(FOOLParser.IN, i);
		}
		public List<DeclistContext> declist() {
			return getRuleContexts(DeclistContext.class);
		}
		public DeclistContext declist(int i) {
			return getRuleContext(DeclistContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(FOOLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FOOLParser.COMMA, i);
		}
		public DeclistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declist; }
	}

	public final DeclistContext declist() throws RecognitionException {
		DeclistContext _localctx = new DeclistContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((DeclistContext)_localctx).astlist =  new ArrayList<Node>();
			setState(75); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(71);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case VAR:
					{
					setState(29);
					match(VAR);
					setState(30);
					((DeclistContext)_localctx).i = match(ID);
					setState(31);
					match(COLON);
					setState(32);
					((DeclistContext)_localctx).t = type();
					setState(33);
					match(ASS);
					setState(34);
					((DeclistContext)_localctx).e = exp();
					VarNode v = new VarNode((((DeclistContext)_localctx).i!=null?((DeclistContext)_localctx).i.getText():null),((DeclistContext)_localctx).t.ast,((DeclistContext)_localctx).e.ast);
					                 _localctx.astlist.add(v);	
					                 HashMap<String,STentry> hm=symTable.get(nestingLevel);
					                 if (hm.put((((DeclistContext)_localctx).i!=null?((DeclistContext)_localctx).i.getText():null), new STentry(nestingLevel)) != null) 
					                   {System.out.println("Var id "+(((DeclistContext)_localctx).i!=null?((DeclistContext)_localctx).i.getText():null)+" at line "+(((DeclistContext)_localctx).i!=null?((DeclistContext)_localctx).i.getLine():0)+" already declared"); 
					                   	System.exit(0);
					                   } 
					                
					}
					break;
				case FUN:
					{
					setState(37);
					match(FUN);
					setState(38);
					((DeclistContext)_localctx).i = match(ID);
					setState(39);
					match(COLON);
					setState(40);
					((DeclistContext)_localctx).t = type();
					FunNode f = new FunNode((((DeclistContext)_localctx).i!=null?((DeclistContext)_localctx).i.getText():null),((DeclistContext)_localctx).t.ast);
					                 _localctx.astlist.add(f);	
					                 HashMap<String,STentry> hm=symTable.get(nestingLevel);
					                 if (hm.put((((DeclistContext)_localctx).i!=null?((DeclistContext)_localctx).i.getText():null), new STentry(nestingLevel)) != null) 
					                   {System.out.println("Fun id "+(((DeclistContext)_localctx).i!=null?((DeclistContext)_localctx).i.getText():null)+" at line "+(((DeclistContext)_localctx).i!=null?((DeclistContext)_localctx).i.getLine():0)+" already declared"); 
					                   	System.exit(0);
					                   }                  
					                 // entro dentro un nuovo scope
					                 nestingLevel++;
					                 HashMap<String,STentry> hmn= new HashMap<String,STentry>();
					    	         symTable.add(hmn);
					                 
					setState(42);
					match(LPAR);
					setState(58);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==ID) {
						{
						setState(43);
						match(ID);
						setState(44);
						match(COLON);
						setState(45);
						type();
						//creare il ParNode
						                  //lo attacco al FunNode invocando addPar 
						                  //aggiungo una STentry alla hashmap hmn
						                 
						setState(55);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(47);
							match(COMMA);
							setState(48);
							match(ID);
							setState(49);
							match(COLON);
							setState(50);
							type();
							//creare il ParNode
							                  //lo attacco al FunNode invocando addPar 
							                  //aggiungo una STentry alla hashmap hmn
							                 
							}
							}
							setState(57);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(60);
					match(RPAR);
					setState(66);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==LET) {
						{
						setState(61);
						match(LET);
						setState(62);
						((DeclistContext)_localctx).d = declist();
						setState(63);
						match(IN);
						f.addDec(((DeclistContext)_localctx).d.astlist);
						}
					}

					setState(68);
					((DeclistContext)_localctx).e = exp();
					f.addBody(((DeclistContext)_localctx).e.ast);
					                 symTable.remove(nestingLevel--);                	
					                
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(73);
				match(SEMIC);
				}
				}
				setState(77); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==VAR || _la==FUN );
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

	public static class TypeContext extends ParserRuleContext {
		public Node ast;
		public TerminalNode INT() { return getToken(FOOLParser.INT, 0); }
		public TerminalNode BOOL() { return getToken(FOOLParser.BOOL, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_type);
		try {
			setState(83);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(79);
				match(INT);
				((TypeContext)_localctx).ast =  new IntTypeNode();
				}
				break;
			case BOOL:
				enterOuterAlt(_localctx, 2);
				{
				setState(81);
				match(BOOL);
				((TypeContext)_localctx).ast =  new BoolTypeNode();
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

	public static class ExpContext extends ParserRuleContext {
		public Node ast;
		public TermContext f;
		public TermContext l;
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(FOOLParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(FOOLParser.PLUS, i);
		}
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
	}

	public final ExpContext exp() throws RecognitionException {
		ExpContext _localctx = new ExpContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_exp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			((ExpContext)_localctx).f = term();
			((ExpContext)_localctx).ast =  ((ExpContext)_localctx).f.ast;
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS) {
				{
				{
				setState(87);
				match(PLUS);
				setState(88);
				((ExpContext)_localctx).l = term();
				((ExpContext)_localctx).ast =  new PlusNode (_localctx.ast,((ExpContext)_localctx).l.ast);
				}
				}
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class TermContext extends ParserRuleContext {
		public Node ast;
		public FactorContext f;
		public FactorContext l;
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public List<TerminalNode> TIMES() { return getTokens(FOOLParser.TIMES); }
		public TerminalNode TIMES(int i) {
			return getToken(FOOLParser.TIMES, i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			((TermContext)_localctx).f = factor();
			((TermContext)_localctx).ast =  ((TermContext)_localctx).f.ast;
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TIMES) {
				{
				{
				setState(98);
				match(TIMES);
				setState(99);
				((TermContext)_localctx).l = factor();
				((TermContext)_localctx).ast =  new TimesNode (_localctx.ast,((TermContext)_localctx).l.ast);
				}
				}
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class FactorContext extends ParserRuleContext {
		public Node ast;
		public ValueContext f;
		public ValueContext l;
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public List<TerminalNode> EQ() { return getTokens(FOOLParser.EQ); }
		public TerminalNode EQ(int i) {
			return getToken(FOOLParser.EQ, i);
		}
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_factor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			((FactorContext)_localctx).f = value();
			((FactorContext)_localctx).ast =  ((FactorContext)_localctx).f.ast;
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EQ) {
				{
				{
				setState(109);
				match(EQ);
				setState(110);
				((FactorContext)_localctx).l = value();
				((FactorContext)_localctx).ast =  new EqualNode (_localctx.ast,((FactorContext)_localctx).l.ast);
				}
				}
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class ValueContext extends ParserRuleContext {
		public Node ast;
		public Token n;
		public ExpContext e;
		public ExpContext x;
		public ExpContext y;
		public ExpContext z;
		public Token i;
		public TerminalNode INTEGER() { return getToken(FOOLParser.INTEGER, 0); }
		public TerminalNode TRUE() { return getToken(FOOLParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(FOOLParser.FALSE, 0); }
		public TerminalNode LPAR() { return getToken(FOOLParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(FOOLParser.RPAR, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode IF() { return getToken(FOOLParser.IF, 0); }
		public TerminalNode THEN() { return getToken(FOOLParser.THEN, 0); }
		public List<TerminalNode> CLPAR() { return getTokens(FOOLParser.CLPAR); }
		public TerminalNode CLPAR(int i) {
			return getToken(FOOLParser.CLPAR, i);
		}
		public List<TerminalNode> CRPAR() { return getTokens(FOOLParser.CRPAR); }
		public TerminalNode CRPAR(int i) {
			return getToken(FOOLParser.CRPAR, i);
		}
		public TerminalNode ELSE() { return getToken(FOOLParser.ELSE, 0); }
		public TerminalNode PRINT() { return getToken(FOOLParser.PRINT, 0); }
		public TerminalNode ID() { return getToken(FOOLParser.ID, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_value);
		try {
			setState(149);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER:
				enterOuterAlt(_localctx, 1);
				{
				setState(118);
				((ValueContext)_localctx).n = match(INTEGER);
				((ValueContext)_localctx).ast =  new IntNode(Integer.parseInt((((ValueContext)_localctx).n!=null?((ValueContext)_localctx).n.getText():null)));
				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(120);
				match(TRUE);
				((ValueContext)_localctx).ast =  new BoolNode(true);
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 3);
				{
				setState(122);
				match(FALSE);
				((ValueContext)_localctx).ast =  new BoolNode(false);
				}
				break;
			case LPAR:
				enterOuterAlt(_localctx, 4);
				{
				setState(124);
				match(LPAR);
				setState(125);
				((ValueContext)_localctx).e = exp();
				setState(126);
				match(RPAR);
				((ValueContext)_localctx).ast =  ((ValueContext)_localctx).e.ast;
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 5);
				{
				setState(129);
				match(IF);
				setState(130);
				((ValueContext)_localctx).x = exp();
				setState(131);
				match(THEN);
				setState(132);
				match(CLPAR);
				setState(133);
				((ValueContext)_localctx).y = exp();
				setState(134);
				match(CRPAR);
				setState(135);
				match(ELSE);
				setState(136);
				match(CLPAR);
				setState(137);
				((ValueContext)_localctx).z = exp();
				setState(138);
				match(CRPAR);
				((ValueContext)_localctx).ast =  new IfNode(((ValueContext)_localctx).x.ast,((ValueContext)_localctx).y.ast,((ValueContext)_localctx).z.ast);
				}
				break;
			case PRINT:
				enterOuterAlt(_localctx, 6);
				{
				setState(141);
				match(PRINT);
				setState(142);
				match(LPAR);
				setState(143);
				((ValueContext)_localctx).e = exp();
				setState(144);
				match(RPAR);
				((ValueContext)_localctx).ast =  new PrintNode(((ValueContext)_localctx).e.ast);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 7);
				{
				setState(147);
				((ValueContext)_localctx).i = match(ID);
				 //cerco la dichiarazione dentro la symbol table
					  	int j=nestingLevel;
					  	STentry entry=null;
					    while (j>=0 && entry==null)
					      entry=symTable.get(j--).get((((ValueContext)_localctx).i!=null?((ValueContext)_localctx).i.getText():null));	    
				        if (entry==null)
				          { System.out.println("Id "+(((ValueContext)_localctx).i!=null?((ValueContext)_localctx).i.getText():null)+" at line "+(((ValueContext)_localctx).i!=null?((ValueContext)_localctx).i.getLine():0)+" not declared"); 
				            System.exit(0); }
					  	((ValueContext)_localctx).ast =  new IdNode((((ValueContext)_localctx).i!=null?((ValueContext)_localctx).i.getText():null),entry);
					  
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\36\u009a\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\35\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7"+
		"\38\n\3\f\3\16\3;\13\3\5\3=\n\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3E\n\3\3\3\3"+
		"\3\3\3\5\3J\n\3\3\3\3\3\6\3N\n\3\r\3\16\3O\3\4\3\4\3\4\3\4\5\4V\n\4\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\7\5^\n\5\f\5\16\5a\13\5\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\7\6i\n\6\f\6\16\6l\13\6\3\7\3\7\3\7\3\7\3\7\3\7\7\7t\n\7\f\7\16\7w\13"+
		"\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u0098\n\b"+
		"\3\b\2\2\t\2\4\6\b\n\f\16\2\2\2\u00a2\2\34\3\2\2\2\4\36\3\2\2\2\6U\3\2"+
		"\2\2\bW\3\2\2\2\nb\3\2\2\2\fm\3\2\2\2\16\u0097\3\2\2\2\20\21\5\b\5\2\21"+
		"\22\7\7\2\2\22\23\b\2\1\2\23\35\3\2\2\2\24\25\7\25\2\2\25\26\b\2\1\2\26"+
		"\27\5\4\3\2\27\30\7\26\2\2\30\31\5\b\5\2\31\32\7\7\2\2\32\33\b\2\1\2\33"+
		"\35\3\2\2\2\34\20\3\2\2\2\34\24\3\2\2\2\35\3\3\2\2\2\36M\b\3\1\2\37 \7"+
		"\27\2\2 !\7\33\2\2!\"\7\3\2\2\"#\5\6\4\2#$\7\6\2\2$%\5\b\5\2%&\b\3\1\2"+
		"&J\3\2\2\2\'(\7\30\2\2()\7\33\2\2)*\7\3\2\2*+\5\6\4\2+,\b\3\1\2,<\7\r"+
		"\2\2-.\7\33\2\2./\7\3\2\2/\60\5\6\4\2\609\b\3\1\2\61\62\7\4\2\2\62\63"+
		"\7\33\2\2\63\64\7\3\2\2\64\65\5\6\4\2\65\66\b\3\1\2\668\3\2\2\2\67\61"+
		"\3\2\2\28;\3\2\2\29\67\3\2\2\29:\3\2\2\2:=\3\2\2\2;9\3\2\2\2<-\3\2\2\2"+
		"<=\3\2\2\2=>\3\2\2\2>D\7\16\2\2?@\7\25\2\2@A\5\4\3\2AB\7\26\2\2BC\b\3"+
		"\1\2CE\3\2\2\2D?\3\2\2\2DE\3\2\2\2EF\3\2\2\2FG\5\b\5\2GH\b\3\1\2HJ\3\2"+
		"\2\2I\37\3\2\2\2I\'\3\2\2\2JK\3\2\2\2KL\7\7\2\2LN\3\2\2\2MI\3\2\2\2NO"+
		"\3\2\2\2OM\3\2\2\2OP\3\2\2\2P\5\3\2\2\2QR\7\31\2\2RV\b\4\1\2ST\7\32\2"+
		"\2TV\b\4\1\2UQ\3\2\2\2US\3\2\2\2V\7\3\2\2\2WX\5\n\6\2X_\b\5\1\2YZ\7\b"+
		"\2\2Z[\5\n\6\2[\\\b\5\1\2\\^\3\2\2\2]Y\3\2\2\2^a\3\2\2\2_]\3\2\2\2_`\3"+
		"\2\2\2`\t\3\2\2\2a_\3\2\2\2bc\5\f\7\2cj\b\6\1\2de\7\t\2\2ef\5\f\7\2fg"+
		"\b\6\1\2gi\3\2\2\2hd\3\2\2\2il\3\2\2\2jh\3\2\2\2jk\3\2\2\2k\13\3\2\2\2"+
		"lj\3\2\2\2mn\5\16\b\2nu\b\7\1\2op\7\5\2\2pq\5\16\b\2qr\b\7\1\2rt\3\2\2"+
		"\2so\3\2\2\2tw\3\2\2\2us\3\2\2\2uv\3\2\2\2v\r\3\2\2\2wu\3\2\2\2xy\7\n"+
		"\2\2y\u0098\b\b\1\2z{\7\13\2\2{\u0098\b\b\1\2|}\7\f\2\2}\u0098\b\b\1\2"+
		"~\177\7\r\2\2\177\u0080\5\b\5\2\u0080\u0081\7\16\2\2\u0081\u0082\b\b\1"+
		"\2\u0082\u0098\3\2\2\2\u0083\u0084\7\21\2\2\u0084\u0085\5\b\5\2\u0085"+
		"\u0086\7\22\2\2\u0086\u0087\7\17\2\2\u0087\u0088\5\b\5\2\u0088\u0089\7"+
		"\20\2\2\u0089\u008a\7\23\2\2\u008a\u008b\7\17\2\2\u008b\u008c\5\b\5\2"+
		"\u008c\u008d\7\20\2\2\u008d\u008e\b\b\1\2\u008e\u0098\3\2\2\2\u008f\u0090"+
		"\7\24\2\2\u0090\u0091\7\r\2\2\u0091\u0092\5\b\5\2\u0092\u0093\7\16\2\2"+
		"\u0093\u0094\b\b\1\2\u0094\u0098\3\2\2\2\u0095\u0096\7\33\2\2\u0096\u0098"+
		"\b\b\1\2\u0097x\3\2\2\2\u0097z\3\2\2\2\u0097|\3\2\2\2\u0097~\3\2\2\2\u0097"+
		"\u0083\3\2\2\2\u0097\u008f\3\2\2\2\u0097\u0095\3\2\2\2\u0098\17\3\2\2"+
		"\2\r\349<DIOU_ju\u0097";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}