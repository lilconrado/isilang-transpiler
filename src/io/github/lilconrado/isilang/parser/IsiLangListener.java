// Generated from ./IsiLang.g4 by ANTLR 4.13.0
package io.github.lilconrado.isilang.parser;

    import java.util.ArrayList;
    import java.util.List;
    import java.util.Stack;
    import java.lang.String;
    import io.github.lilconrado.isilang.symbols.*;
    import io.github.lilconrado.isilang.exceptions.SemanticException;
    import io.github.lilconrado.isilang.ast.*;
    import io.github.lilconrado.isilang.expressions.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link IsiLangParser}.
 */
public interface IsiLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(IsiLangParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(IsiLangParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(IsiLangParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(IsiLangParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#declara}.
	 * @param ctx the parse tree
	 */
	void enterDeclara(IsiLangParser.DeclaraContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#declara}.
	 * @param ctx the parse tree
	 */
	void exitDeclara(IsiLangParser.DeclaraContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(IsiLangParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(IsiLangParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#bloco}.
	 * @param ctx the parse tree
	 */
	void enterBloco(IsiLangParser.BlocoContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#bloco}.
	 * @param ctx the parse tree
	 */
	void exitBloco(IsiLangParser.BlocoContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(IsiLangParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(IsiLangParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdLeitura}.
	 * @param ctx the parse tree
	 */
	void enterCmdLeitura(IsiLangParser.CmdLeituraContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdLeitura}.
	 * @param ctx the parse tree
	 */
	void exitCmdLeitura(IsiLangParser.CmdLeituraContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdEscrita}.
	 * @param ctx the parse tree
	 */
	void enterCmdEscrita(IsiLangParser.CmdEscritaContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdEscrita}.
	 * @param ctx the parse tree
	 */
	void exitCmdEscrita(IsiLangParser.CmdEscritaContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdExpr}.
	 * @param ctx the parse tree
	 */
	void enterCmdExpr(IsiLangParser.CmdExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdExpr}.
	 * @param ctx the parse tree
	 */
	void exitCmdExpr(IsiLangParser.CmdExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdIf}.
	 * @param ctx the parse tree
	 */
	void enterCmdIf(IsiLangParser.CmdIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdIf}.
	 * @param ctx the parse tree
	 */
	void exitCmdIf(IsiLangParser.CmdIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdWhile}.
	 * @param ctx the parse tree
	 */
	void enterCmdWhile(IsiLangParser.CmdWhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdWhile}.
	 * @param ctx the parse tree
	 */
	void exitCmdWhile(IsiLangParser.CmdWhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdDoWhile}.
	 * @param ctx the parse tree
	 */
	void enterCmdDoWhile(IsiLangParser.CmdDoWhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdDoWhile}.
	 * @param ctx the parse tree
	 */
	void exitCmdDoWhile(IsiLangParser.CmdDoWhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(IsiLangParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(IsiLangParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(IsiLangParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(IsiLangParser.TermoContext ctx);
}