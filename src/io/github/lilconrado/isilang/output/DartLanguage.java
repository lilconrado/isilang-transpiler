package io.github.lilconrado.isilang.output;


import io.github.lilconrado.isilang.ast.*;
import io.github.lilconrado.isilang.expressions.AbstractExpression;
import io.github.lilconrado.isilang.symbols.Identifier;

import static io.github.lilconrado.isilang.symbols.Type.INTEGER;
import static io.github.lilconrado.isilang.symbols.Type.REAL;
import static io.github.lilconrado.isilang.symbols.Type.STRING;


public class DartLanguage extends AbstractLanguage {
    @Override
    public String getFileName(String fileName) {
        return String.format("%s.dart", fileName);
    }

    @Override
    public String generateHeader() {
        return "import 'dart:io';\n\nvoid main(){\n";
    }

    @Override
    public String generateFooter() {
        return "}\n";
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

        return String.format("%s=%s;\n", idType, id.getName());
    }

    private String getIdType(Identifier id) {
        return switch (id.getType()) {
            case INTEGER -> "int";
            case REAL -> "double";
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

        StringBuilder code = new StringBuilder() ;

        switch (id.getType()) {
            case INTEGER -> code.append(String.format("%s=int.parse(stdin.readLineSync()!);\n", id.getName()));
            case REAL -> code.append(String.format("%s=double.parse(stdin.readLineSync()!);\n", id.getName()));
            case STRING -> code.append(String.format("%s=stdin.readLineSync();\n", id.getName()));
            default -> throw new RuntimeException();
        }

        return code.toString();
    }

    @Override
    protected String generateWrite(CmdWrite write) {
        String tmp = write.getId() == null ? write.getText() : write.getId().getName();
        return String.format("print(%s);\n", tmp);
    }
}
