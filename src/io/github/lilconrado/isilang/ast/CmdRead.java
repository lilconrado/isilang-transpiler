package io.github.lilconrado.isilang.ast;

import io.github.lilconrado.isilang.symbols.Identifier;

public class CmdRead extends AbstractCommand {
    static boolean firstScanner = false;

    public Identifier getId() {
        return id;
    }

    public void setId(Identifier id) {
        this.id = id;
    }

    private Identifier id;
    public CmdRead(Identifier id) {
        super();
        this.id = id;
    }

}
