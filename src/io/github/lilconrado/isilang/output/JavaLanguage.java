package io.github.lilconrado.isilang.output;

import io.github.lilconrado.isilang.ast.*;
import io.github.lilconrado.isilang.expressions.AbstractExpression;
import io.github.lilconrado.isilang.symbols.Identifier;

import java.util.List;

public class JavaLanguage extends AbstractLanguage {
    @Override
    public String generateHeader() {
        return "import java.util.Scanner;\n\npublic class Main {\npublic static void main(String[] args) {\n";
    }

    @Override
    public String getFileName(String fileName) {
        return String.format("%s.java", fileName);
    }

    @Override
    public String generateFooter() {
        return "\n}\n}";
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

        return String.format("%s %s;\n", idType, id.getName());
    }

    private String getIdType(Identifier id) {
        return switch (id.getType()) {
            case INTEGER -> "int";
            case REAL -> "double";
            case STRING -> "String";
            default -> throw new RuntimeException("Unknown Type");
        };
    }

    @Override
    protected String generateWhile(CmdWhile cmd) {
        var listTrue = cmd.getListTrue();
        var expr = cmd.getExpr();

        StringBuilder sbTrue = new StringBuilder();

        for (AbstractCommand c: listTrue) {
            sbTrue.append(generateCode(c));
        }

        return String.format("while(%s) {\n%s}\n", expr.toString(), sbTrue.toString() );
    }

    @Override
    protected String generateDoWhile(CmdDoWhile cmd) {
        var cmds = cmd.getListTrue();
        var expr = cmd.getExpr();

        StringBuilder sbTrue = new StringBuilder();

        for (AbstractCommand c: cmds) {
            sbTrue.append(generateCode(c));
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
            sbTrue.append(generateCode(c));
        }

        if (cmdsFalse != null && !cmdsFalse.isEmpty()) {
            sbFalse.append("else {\n");

            for (AbstractCommand c: cmdsFalse) {
                sbFalse.append(generateCode(c));
            }

            sbFalse.append("}\n");
        }

        return String.format("if (%s) {\n%s}\n%s", expr.toString(), sbTrue.toString(), sbFalse.toString());
    }

    private static boolean firstScanner = false;

    @Override
    protected String generateRead(CmdRead cmd) {
        var id = cmd.getId();

        StringBuilder code = new StringBuilder() ;

        if(!firstScanner){
            code.append( "Scanner scanner = new Scanner(System.in);\n");
            firstScanner = true;
        }

        switch (id.getType()) {
            case INTEGER -> code.append(String.format("%s=scanner.nextInt();scanner.nextLine(); \n", id.getName()));
            case REAL -> code.append(String.format("%s=scanner.nextDouble();scanner.nextLine(); \n", id.getName()));
            case STRING -> code.append(String.format("%s=scanner.nextLine(); \n", id.getName()));
            default -> throw new RuntimeException();
        }

        return code.toString();
    }

    @Override
    public String generateWrite(CmdWrite write) {
        String tmp = write.getId() == null ? write.getText() : write.getId().getName();

        return String.format("System.out.println(%s);\n", tmp);
    }

}
