package io.github.lilconrado.isilang.ast;

import io.github.lilconrado.isilang.symbols.Identifier;

public class CmdDeclaration extends AbstractCommand {
    private Identifier id;

    public CmdDeclaration(Identifier id) {
        super();
        this.id = id;
    }

    public CmdDeclaration() {
        super();
    }

    public Identifier getId() {
        return id;
    }

    public void setId(Identifier id) {
        this.id = id;
    }
    @Override
    public String generateCode() {
        String idType = this.getIdType();
        return String.format("%s %s;\n", idType, this.id.getName());
    }

    private String getIdType() {
        switch (this.id.getType()) {
            case INTEGER:
                return "int";
            case REAL:
                return "double";
            case STRING:
                return "String";
            default:
                throw new RuntimeException("Unknown Type");
        }
    }
}
