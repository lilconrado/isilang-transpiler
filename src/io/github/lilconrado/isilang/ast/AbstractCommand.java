package io.github.lilconrado.isilang.ast;

public abstract class AbstractCommand {
    public abstract String generateCode();
    public abstract void run();
}
