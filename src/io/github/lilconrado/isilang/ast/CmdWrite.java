package io.github.lilconrado.isilang.ast;

import io.github.lilconrado.isilang.symbols.Identifier;

public class CmdWrite extends AbstractCommand {
    private Identifier id;
    private String text;

    public Identifier getId() {
        return id;
    }

    public void setId(Identifier id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public CmdWrite(Identifier id) {
        super();
        this.id = id;
    }

    public CmdWrite(String text) {
        super();
        this.text = text;
    }

    @Override
    public String generateCode() {
        String tmp = id == null ? text : id.getName();

        return String.format("System.out.println(%s);\n", tmp);
    }
}
