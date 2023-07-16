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
		T__0=1, T__1=2, T__2=3, T__3=4, AP=5, FP=6, PF=7, ATTR=8, OP=9, ID=10, 
		NUMBER=11, TEXT=12, BLANK=13;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "AP", "FP", "PF", "ATTR", "OP", "ID", 
			"NUMBER", "TEXT", "BLANK"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'fimprog.'", "'leia'", "'escreva'", "'('", "')'", 
			"'.'", "':='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "AP", "FP", "PF", "ATTR", "OP", "ID", "NUMBER", 
			"TEXT", "BLANK"
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
		"\u0004\u0000\rf\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0005\tJ\b\t\n"+
		"\t\f\tM\t\t\u0001\n\u0004\nP\b\n\u000b\n\f\nQ\u0001\n\u0001\n\u0004\n"+
		"V\b\n\u000b\n\f\nW\u0001\u000b\u0001\u000b\u0005\u000b\\\b\u000b\n\u000b"+
		"\f\u000b_\t\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0000\u0000\r\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005"+
		"\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019"+
		"\r\u0001\u0000\u0006\u0003\u0000*+--//\u0001\u0000az\u0001\u0000AZ\u0001"+
		"\u000009\u0006\u0000\t\t !--09AZaz\u0003\u0000\t\n\r\r  j\u0000\u0001"+
		"\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005"+
		"\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001"+
		"\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000"+
		"\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000"+
		"\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000"+
		"\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000"+
		"\u0000\u0000\u0001\u001b\u0001\u0000\u0000\u0000\u0003$\u0001\u0000\u0000"+
		"\u0000\u0005-\u0001\u0000\u0000\u0000\u00072\u0001\u0000\u0000\u0000\t"+
		":\u0001\u0000\u0000\u0000\u000b<\u0001\u0000\u0000\u0000\r>\u0001\u0000"+
		"\u0000\u0000\u000f@\u0001\u0000\u0000\u0000\u0011C\u0001\u0000\u0000\u0000"+
		"\u0013E\u0001\u0000\u0000\u0000\u0015O\u0001\u0000\u0000\u0000\u0017Y"+
		"\u0001\u0000\u0000\u0000\u0019b\u0001\u0000\u0000\u0000\u001b\u001c\u0005"+
		"p\u0000\u0000\u001c\u001d\u0005r\u0000\u0000\u001d\u001e\u0005o\u0000"+
		"\u0000\u001e\u001f\u0005g\u0000\u0000\u001f \u0005r\u0000\u0000 !\u0005"+
		"a\u0000\u0000!\"\u0005m\u0000\u0000\"#\u0005a\u0000\u0000#\u0002\u0001"+
		"\u0000\u0000\u0000$%\u0005f\u0000\u0000%&\u0005i\u0000\u0000&\'\u0005"+
		"m\u0000\u0000\'(\u0005p\u0000\u0000()\u0005r\u0000\u0000)*\u0005o\u0000"+
		"\u0000*+\u0005g\u0000\u0000+,\u0005.\u0000\u0000,\u0004\u0001\u0000\u0000"+
		"\u0000-.\u0005l\u0000\u0000./\u0005e\u0000\u0000/0\u0005i\u0000\u0000"+
		"01\u0005a\u0000\u00001\u0006\u0001\u0000\u0000\u000023\u0005e\u0000\u0000"+
		"34\u0005s\u0000\u000045\u0005c\u0000\u000056\u0005r\u0000\u000067\u0005"+
		"e\u0000\u000078\u0005v\u0000\u000089\u0005a\u0000\u00009\b\u0001\u0000"+
		"\u0000\u0000:;\u0005(\u0000\u0000;\n\u0001\u0000\u0000\u0000<=\u0005)"+
		"\u0000\u0000=\f\u0001\u0000\u0000\u0000>?\u0005.\u0000\u0000?\u000e\u0001"+
		"\u0000\u0000\u0000@A\u0005:\u0000\u0000AB\u0005=\u0000\u0000B\u0010\u0001"+
		"\u0000\u0000\u0000CD\u0007\u0000\u0000\u0000D\u0012\u0001\u0000\u0000"+
		"\u0000EK\u0007\u0001\u0000\u0000FG\u0007\u0001\u0000\u0000GJ\u0007\u0002"+
		"\u0000\u0000HJ\u0007\u0003\u0000\u0000IF\u0001\u0000\u0000\u0000IH\u0001"+
		"\u0000\u0000\u0000JM\u0001\u0000\u0000\u0000KI\u0001\u0000\u0000\u0000"+
		"KL\u0001\u0000\u0000\u0000L\u0014\u0001\u0000\u0000\u0000MK\u0001\u0000"+
		"\u0000\u0000NP\u0007\u0003\u0000\u0000ON\u0001\u0000\u0000\u0000PQ\u0001"+
		"\u0000\u0000\u0000QO\u0001\u0000\u0000\u0000QR\u0001\u0000\u0000\u0000"+
		"RS\u0001\u0000\u0000\u0000SU\u0005.\u0000\u0000TV\u0007\u0003\u0000\u0000"+
		"UT\u0001\u0000\u0000\u0000VW\u0001\u0000\u0000\u0000WU\u0001\u0000\u0000"+
		"\u0000WX\u0001\u0000\u0000\u0000X\u0016\u0001\u0000\u0000\u0000Y]\u0005"+
		"\"\u0000\u0000Z\\\u0007\u0004\u0000\u0000[Z\u0001\u0000\u0000\u0000\\"+
		"_\u0001\u0000\u0000\u0000][\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000"+
		"\u0000^`\u0001\u0000\u0000\u0000_]\u0001\u0000\u0000\u0000`a\u0005\"\u0000"+
		"\u0000a\u0018\u0001\u0000\u0000\u0000bc\u0007\u0005\u0000\u0000cd\u0001"+
		"\u0000\u0000\u0000de\u0006\f\u0000\u0000e\u001a\u0001\u0000\u0000\u0000"+
		"\u0007\u0000IKQW[]\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}