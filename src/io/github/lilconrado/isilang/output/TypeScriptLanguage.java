package io.github.lilconrado.isilang.output;

import io.github.lilconrado.isilang.ast.*;
import io.github.lilconrado.isilang.expressions.AbstractExpression;
import io.github.lilconrado.isilang.symbols.Identifier;

import static io.github.lilconrado.isilang.symbols.Type.INTEGER;
import static io.github.lilconrado.isilang.symbols.Type.REAL;
import static io.github.lilconrado.isilang.symbols.Type.STRING;


public class TypeScriptLanguage extends AbstractLanguage {
    @Override
    public String getFileName(String fileName) {
        return String.format("%s.ts", fileName);
    }

    @Override
    public String generateHeader() {
        return "";
    }

    @Override
    public String generateFooter() {
        return "";
    }

    @Override
    protected String generateAttribution(CmdAttrib cmd) {
        Identifier id = cmd.getId();
        AbstractExpression expr = cmd.getExpr();

        return id.getName() + "=" + expr.toString() + ";\n";
    }

    @Override
    protected String generateDeclaration(CmdDeclaration cmd) {
        Identifier id = cmd.getId();
        String idType = this.getIdType(id);

        return String.format("let %s:%s;\n", id.getName(), idType);
    }

    private String getIdType(Identifier id) {
        return switch (id.getType()) {
            case INTEGER, REAL -> "number";
            case STRING -> "string";
            default -> throw new RuntimeException("Unknown Type");
        };
    }

    @Override
    protected String generateWhile(CmdWhile cmd) {
        var listTrue = cmd.getListTrue();
        var expr = cmd.getExpr();

        StringBuilder sbTrue = new StringBuilder();

        for (AbstractCommand c: listTrue) {
            sbTrue.append(String.format("\t"+generateCode(c)));
        }

        return String.format("while(%s) {\n%s}\n", expr.toString(), sbTrue.toString() );
    }

    @Override
    protected String generateDoWhile(CmdDoWhile cmd) {
        var cmds = cmd.getListTrue();
        var expr = cmd.getExpr();

        StringBuilder sbTrue = new StringBuilder();

        for (AbstractCommand c: cmds) {
            sbTrue.append(String.format("\t"+generateCode(c)));
        }

        return String.format("do {\n%s} while(%s);\n", sbTrue.toString(), expr.toString());

    }

    @Override
    protected String generateIf(CmdIf cmd) {
        var cmdsTrue = cmd.getListTrue();
        var cmdsFalse = cmd.getListFalse();
        var expr = cmd.getExpr();

        StringBuilder sbTrue = new StringBuilder();
        StringBuilder sbFalse = new StringBuilder();

        for (AbstractCommand c: cmdsTrue) {
            sbTrue.append(String.format("\t"+generateCode(c)));
        }

        if (!cmdsFalse.isEmpty()) {
            sbFalse.append("else {\n");

            for (AbstractCommand c: cmdsFalse) {
                sbFalse.append(String.format("\t"+generateCode(c)));
            }

            sbFalse.append("}\n");
        }

        return String.format("if (%s) {\n%s}\n%s", expr.toString(), sbTrue.toString(), sbFalse.toString());

    }

    @Override
    protected String generateRead(CmdRead cmd) {
        var id = cmd.getId();

        if(id.getType() !=INTEGER && id.getType() !=REAL && id.getType() !=STRING){
            throw new RuntimeException("Unknown Type");
        }

        return String.format("%s=window.prompt();\n", id.getName());
    }

    @Override
    protected String generateWrite(CmdWrite write) {
        String tmp = write.getId() == null ? write.getText() : write.getId().getName();

        return String.format("console.log(%s);\n", tmp);
    }
}
