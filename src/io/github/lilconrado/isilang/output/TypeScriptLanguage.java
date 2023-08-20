package io.github.lilconrado.isilang.output;

import io.github.lilconrado.isilang.ast.*;
import io.github.lilconrado.isilang.symbols.Identifier;

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
        return "";
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
        return "";
    }

    @Override
    protected String generateDoWhile(CmdDoWhile cmd) {
        return "";
    }

    @Override
    protected String generateIf(CmdIf cmd) {
        return "";
    }

    @Override
    protected String generateRead(CmdRead cmd) {
        return "";
    }

    @Override
    protected String generateWrite(CmdWrite write) {
        String tmp = write.getId() == null ? write.getText() : write.getId().getName();

        return String.format("console.log(%s);\n", tmp);
    }
}
