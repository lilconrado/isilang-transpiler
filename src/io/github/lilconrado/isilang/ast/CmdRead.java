package io.github.lilconrado.isilang.ast;

import io.github.lilconrado.isilang.symbols.Identifier;

public class CmdRead extends AbstractCommand {
    private Identifier id;

    @Override
    public String generateCode() {
        return String.format("%s = prompt(texto);\n");
    }

    @Override
    public void run() {

    }
}
