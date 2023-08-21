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
         String header = String.format("function ask() {\n" +
                "  const readline = require(\"readline\").createInterface({\n" +
                "    input: process.stdin,\n" +
                "    output: process.stdout\n" +
                "  })\n" +
                "\n" +
                "  return  new Promise(resolve => readline.question('', ans => {\n" +
                "  readline.close();\n" +
                "  resolve(ans);\n" +
                "}));\n" +
                "}\n\n" +
                "async function main(){\n");

        return header;
    }

    @Override
    public String generateFooter() {
        return "}\nmain();\n";
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

    @Override
    protected String generateRead(CmdRead cmd) {
        var id = cmd.getId();

        switch (id.getType()) {
            case INTEGER: return  String.format("%s=Number.parseInt(await ask());\n", id.getName());
            case REAL: return  String.format("%s=Number.parseFloat(await ask());\n", id.getName());
            case STRING: return String.format("%s=await ask();\n", id.getName());
            default: throw new RuntimeException();
        }


    }


    @Override
    protected String generateWrite(CmdWrite write) {
        String tmp = write.getId() == null ? write.getText() : write.getId().getName();

        return String.format("console.log(%s);\n", tmp);
    }
}
