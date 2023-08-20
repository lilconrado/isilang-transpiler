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

}
