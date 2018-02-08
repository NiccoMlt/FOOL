// Generated from FOOL.g4 by ANTLR 4.7

import ast.*;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FOOLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SEMIC=1, EQ=2, PLUS=3, TIMES=4, INTEGER=5, TRUE=6, FALSE=7, LPAR=8, RPAR=9, 
		CLPAR=10, CRPAR=11, IF=12, THEN=13, ELSE=14, PRINT=15, WHITESP=16, COMMENT=17, 
		ERR=18;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"SEMIC", "EQ", "PLUS", "TIMES", "INTEGER", "TRUE", "FALSE", "LPAR", "RPAR", 
		"CLPAR", "CRPAR", "IF", "THEN", "ELSE", "PRINT", "WHITESP", "COMMENT", 
		"ERR"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'=='", "'+'", "'*'", null, "'true'", "'false'", "'('", "')'", 
		"'{'", "'}'", "'if'", "'then'", "'else'", "'print'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "SEMIC", "EQ", "PLUS", "TIMES", "INTEGER", "TRUE", "FALSE", "LPAR", 
		"RPAR", "CLPAR", "CRPAR", "IF", "THEN", "ELSE", "PRINT", "WHITESP", "COMMENT", 
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


	int lexicalErrors=0;


	public FOOLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "FOOL.g4"; }

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

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 17:
			ERR_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void ERR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			 System.out.println("Invalid char: "+ getText()); lexicalErrors++; 
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\24}\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\5\6\62\n\6\3\6\3\6"+
		"\7\6\66\n\6\f\6\16\69\13\6\3\6\5\6<\n\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\16\3\16"+
		"\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\21\6\21e\n\21\r\21\16\21f\3\21\3\21\3\22\3\22\3\22\3\22\7\22o\n\22"+
		"\f\22\16\22r\13\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3"+
		"p\2\24\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17"+
		"\35\20\37\21!\22#\23%\24\3\2\3\5\2\13\f\17\17\"\"\2\u0081\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2"+
		"\2\3\'\3\2\2\2\5)\3\2\2\2\7,\3\2\2\2\t.\3\2\2\2\13;\3\2\2\2\r=\3\2\2\2"+
		"\17B\3\2\2\2\21H\3\2\2\2\23J\3\2\2\2\25L\3\2\2\2\27N\3\2\2\2\31P\3\2\2"+
		"\2\33S\3\2\2\2\35X\3\2\2\2\37]\3\2\2\2!d\3\2\2\2#j\3\2\2\2%x\3\2\2\2\'"+
		"(\7=\2\2(\4\3\2\2\2)*\7?\2\2*+\7?\2\2+\6\3\2\2\2,-\7-\2\2-\b\3\2\2\2."+
		"/\7,\2\2/\n\3\2\2\2\60\62\7/\2\2\61\60\3\2\2\2\61\62\3\2\2\2\62\63\3\2"+
		"\2\2\63\67\4\63;\2\64\66\4\62;\2\65\64\3\2\2\2\669\3\2\2\2\67\65\3\2\2"+
		"\2\678\3\2\2\28<\3\2\2\29\67\3\2\2\2:<\7\62\2\2;\61\3\2\2\2;:\3\2\2\2"+
		"<\f\3\2\2\2=>\7v\2\2>?\7t\2\2?@\7w\2\2@A\7g\2\2A\16\3\2\2\2BC\7h\2\2C"+
		"D\7c\2\2DE\7n\2\2EF\7u\2\2FG\7g\2\2G\20\3\2\2\2HI\7*\2\2I\22\3\2\2\2J"+
		"K\7+\2\2K\24\3\2\2\2LM\7}\2\2M\26\3\2\2\2NO\7\177\2\2O\30\3\2\2\2PQ\7"+
		"k\2\2QR\7h\2\2R\32\3\2\2\2ST\7v\2\2TU\7j\2\2UV\7g\2\2VW\7p\2\2W\34\3\2"+
		"\2\2XY\7g\2\2YZ\7n\2\2Z[\7u\2\2[\\\7g\2\2\\\36\3\2\2\2]^\7r\2\2^_\7t\2"+
		"\2_`\7k\2\2`a\7p\2\2ab\7v\2\2b \3\2\2\2ce\t\2\2\2dc\3\2\2\2ef\3\2\2\2"+
		"fd\3\2\2\2fg\3\2\2\2gh\3\2\2\2hi\b\21\2\2i\"\3\2\2\2jk\7\61\2\2kl\7,\2"+
		"\2lp\3\2\2\2mo\13\2\2\2nm\3\2\2\2or\3\2\2\2pq\3\2\2\2pn\3\2\2\2qs\3\2"+
		"\2\2rp\3\2\2\2st\7,\2\2tu\7\61\2\2uv\3\2\2\2vw\b\22\2\2w$\3\2\2\2xy\13"+
		"\2\2\2yz\b\23\3\2z{\3\2\2\2{|\b\23\2\2|&\3\2\2\2\b\2\61\67;fp\4\2\3\2"+
		"\3\23\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}