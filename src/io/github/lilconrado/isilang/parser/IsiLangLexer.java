// Generated from ./IsiLang.g4 by ANTLR 4.13.0
package io.github.lilconrado.isilang.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class IsiLangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, AP=9, 
		FP=10, PF=11, VIR=12, AC=13, FC=14, ATTR=15, OP=16, OP_REL=17, ID=18, 
		NUMBER=19, TEXT=20, BLANK=21;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "AP", 
			"FP", "PF", "VIR", "AC", "FC", "ATTR", "OP", "OP_REL", "ID", "NUMBER", 
			"TEXT", "BLANK"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'fimprog.'", "'declare'", "'leia'", "'escreva'", 
			"'se'", "'entao'", "'senao'", "'('", "')'", "'.'", "','", "'{'", "'}'", 
			"':='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "AP", "FP", "PF", 
			"VIR", "AC", "FC", "ATTR", "OP", "OP_REL", "ID", "NUMBER", "TEXT", "BLANK"
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


	public IsiLangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "IsiLang.g4"; }

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
		"\u0004\u0000\u0015\u009e\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b"+
		"\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010|\b"+
		"\u0010\u0001\u0011\u0001\u0011\u0005\u0011\u0080\b\u0011\n\u0011\f\u0011"+
		"\u0083\t\u0011\u0001\u0012\u0004\u0012\u0086\b\u0012\u000b\u0012\f\u0012"+
		"\u0087\u0001\u0012\u0001\u0012\u0004\u0012\u008c\b\u0012\u000b\u0012\f"+
		"\u0012\u008d\u0003\u0012\u0090\b\u0012\u0001\u0013\u0001\u0013\u0005\u0013"+
		"\u0094\b\u0013\n\u0013\f\u0013\u0097\t\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0000\u0000\u0015\u0001\u0001"+
		"\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f"+
		"\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f"+
		"\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015\u0001\u0000\u0007\u0003"+
		"\u0000*+--//\u0002\u0000<<>>\u0001\u0000az\u0003\u000009AZaz\u0001\u0000"+
		"09\u0006\u0000\t\t !--09AZaz\u0003\u0000\t\n\r\r  \u00a6\u0000\u0001\u0001"+
		"\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001"+
		"\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000"+
		"\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000"+
		"\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000"+
		"\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000"+
		"\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000"+
		"\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000"+
		"\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000"+
		"\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'"+
		"\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0001+\u0001\u0000"+
		"\u0000\u0000\u00034\u0001\u0000\u0000\u0000\u0005=\u0001\u0000\u0000\u0000"+
		"\u0007E\u0001\u0000\u0000\u0000\tJ\u0001\u0000\u0000\u0000\u000bR\u0001"+
		"\u0000\u0000\u0000\rU\u0001\u0000\u0000\u0000\u000f[\u0001\u0000\u0000"+
		"\u0000\u0011a\u0001\u0000\u0000\u0000\u0013c\u0001\u0000\u0000\u0000\u0015"+
		"e\u0001\u0000\u0000\u0000\u0017g\u0001\u0000\u0000\u0000\u0019i\u0001"+
		"\u0000\u0000\u0000\u001bk\u0001\u0000\u0000\u0000\u001dm\u0001\u0000\u0000"+
		"\u0000\u001fp\u0001\u0000\u0000\u0000!{\u0001\u0000\u0000\u0000#}\u0001"+
		"\u0000\u0000\u0000%\u0085\u0001\u0000\u0000\u0000\'\u0091\u0001\u0000"+
		"\u0000\u0000)\u009a\u0001\u0000\u0000\u0000+,\u0005p\u0000\u0000,-\u0005"+
		"r\u0000\u0000-.\u0005o\u0000\u0000./\u0005g\u0000\u0000/0\u0005r\u0000"+
		"\u000001\u0005a\u0000\u000012\u0005m\u0000\u000023\u0005a\u0000\u0000"+
		"3\u0002\u0001\u0000\u0000\u000045\u0005f\u0000\u000056\u0005i\u0000\u0000"+
		"67\u0005m\u0000\u000078\u0005p\u0000\u000089\u0005r\u0000\u00009:\u0005"+
		"o\u0000\u0000:;\u0005g\u0000\u0000;<\u0005.\u0000\u0000<\u0004\u0001\u0000"+
		"\u0000\u0000=>\u0005d\u0000\u0000>?\u0005e\u0000\u0000?@\u0005c\u0000"+
		"\u0000@A\u0005l\u0000\u0000AB\u0005a\u0000\u0000BC\u0005r\u0000\u0000"+
		"CD\u0005e\u0000\u0000D\u0006\u0001\u0000\u0000\u0000EF\u0005l\u0000\u0000"+
		"FG\u0005e\u0000\u0000GH\u0005i\u0000\u0000HI\u0005a\u0000\u0000I\b\u0001"+
		"\u0000\u0000\u0000JK\u0005e\u0000\u0000KL\u0005s\u0000\u0000LM\u0005c"+
		"\u0000\u0000MN\u0005r\u0000\u0000NO\u0005e\u0000\u0000OP\u0005v\u0000"+
		"\u0000PQ\u0005a\u0000\u0000Q\n\u0001\u0000\u0000\u0000RS\u0005s\u0000"+
		"\u0000ST\u0005e\u0000\u0000T\f\u0001\u0000\u0000\u0000UV\u0005e\u0000"+
		"\u0000VW\u0005n\u0000\u0000WX\u0005t\u0000\u0000XY\u0005a\u0000\u0000"+
		"YZ\u0005o\u0000\u0000Z\u000e\u0001\u0000\u0000\u0000[\\\u0005s\u0000\u0000"+
		"\\]\u0005e\u0000\u0000]^\u0005n\u0000\u0000^_\u0005a\u0000\u0000_`\u0005"+
		"o\u0000\u0000`\u0010\u0001\u0000\u0000\u0000ab\u0005(\u0000\u0000b\u0012"+
		"\u0001\u0000\u0000\u0000cd\u0005)\u0000\u0000d\u0014\u0001\u0000\u0000"+
		"\u0000ef\u0005.\u0000\u0000f\u0016\u0001\u0000\u0000\u0000gh\u0005,\u0000"+
		"\u0000h\u0018\u0001\u0000\u0000\u0000ij\u0005{\u0000\u0000j\u001a\u0001"+
		"\u0000\u0000\u0000kl\u0005}\u0000\u0000l\u001c\u0001\u0000\u0000\u0000"+
		"mn\u0005:\u0000\u0000no\u0005=\u0000\u0000o\u001e\u0001\u0000\u0000\u0000"+
		"pq\u0007\u0000\u0000\u0000q \u0001\u0000\u0000\u0000r|\u0007\u0001\u0000"+
		"\u0000st\u0005<\u0000\u0000t|\u0005=\u0000\u0000uv\u0005>\u0000\u0000"+
		"v|\u0005=\u0000\u0000wx\u0005!\u0000\u0000x|\u0005=\u0000\u0000yz\u0005"+
		"=\u0000\u0000z|\u0005=\u0000\u0000{r\u0001\u0000\u0000\u0000{s\u0001\u0000"+
		"\u0000\u0000{u\u0001\u0000\u0000\u0000{w\u0001\u0000\u0000\u0000{y\u0001"+
		"\u0000\u0000\u0000|\"\u0001\u0000\u0000\u0000}\u0081\u0007\u0002\u0000"+
		"\u0000~\u0080\u0007\u0003\u0000\u0000\u007f~\u0001\u0000\u0000\u0000\u0080"+
		"\u0083\u0001\u0000\u0000\u0000\u0081\u007f\u0001\u0000\u0000\u0000\u0081"+
		"\u0082\u0001\u0000\u0000\u0000\u0082$\u0001\u0000\u0000\u0000\u0083\u0081"+
		"\u0001\u0000\u0000\u0000\u0084\u0086\u0007\u0004\u0000\u0000\u0085\u0084"+
		"\u0001\u0000\u0000\u0000\u0086\u0087\u0001\u0000\u0000\u0000\u0087\u0085"+
		"\u0001\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000\u0000\u0088\u008f"+
		"\u0001\u0000\u0000\u0000\u0089\u008b\u0005.\u0000\u0000\u008a\u008c\u0007"+
		"\u0004\u0000\u0000\u008b\u008a\u0001\u0000\u0000\u0000\u008c\u008d\u0001"+
		"\u0000\u0000\u0000\u008d\u008b\u0001\u0000\u0000\u0000\u008d\u008e\u0001"+
		"\u0000\u0000\u0000\u008e\u0090\u0001\u0000\u0000\u0000\u008f\u0089\u0001"+
		"\u0000\u0000\u0000\u008f\u0090\u0001\u0000\u0000\u0000\u0090&\u0001\u0000"+
		"\u0000\u0000\u0091\u0095\u0005\"\u0000\u0000\u0092\u0094\u0007\u0005\u0000"+
		"\u0000\u0093\u0092\u0001\u0000\u0000\u0000\u0094\u0097\u0001\u0000\u0000"+
		"\u0000\u0095\u0093\u0001\u0000\u0000\u0000\u0095\u0096\u0001\u0000\u0000"+
		"\u0000\u0096\u0098\u0001\u0000\u0000\u0000\u0097\u0095\u0001\u0000\u0000"+
		"\u0000\u0098\u0099\u0005\"\u0000\u0000\u0099(\u0001\u0000\u0000\u0000"+
		"\u009a\u009b\u0007\u0006\u0000\u0000\u009b\u009c\u0001\u0000\u0000\u0000"+
		"\u009c\u009d\u0006\u0014\u0000\u0000\u009d*\u0001\u0000\u0000\u0000\t"+
		"\u0000{\u007f\u0081\u0087\u008d\u008f\u0093\u0095\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}