package io.github.lilconrado.isilang.output;

import io.github.lilconrado.isilang.ast.*;
import io.github.lilconrado.isilang.expressions.AbstractExpression;
import io.github.lilconrado.isilang.symbols.Identifier;

import java.util.List;

public abstract class AbstractLanguage {
    public abstract String generateHeader();
    public abstract String generateFooter();
    protected abstract String generateAttribution(CmdAttrib cmd);
    protected abstract String generateDeclaration(CmdDeclaration cmd);
    protected abstract String generateWhile(CmdWhile cmd);
    protected abstract String generateDoWhile(CmdDoWhile cmd);
    protected abstract String generateIf(CmdIf cmd);
    protected abstract String generateRead(CmdRead cmd);
    protected abstract String generateWrite(CmdWrite cmd);

    public String generateCode(AbstractCommand cmd) {
        if (cmd instanceof CmdWrite) {
            return this.generateWrite((CmdWrite) cmd);
        }

        if (cmd instanceof CmdAttrib) {
            return this.generateAttribution((CmdAttrib) cmd);
        }

        if (cmd instanceof CmdDeclaration) {
            return  this.generateDeclaration((CmdDeclaration) cmd);
        }

        if (cmd instanceof CmdDoWhile) {
            return  this.generateDoWhile((CmdDoWhile) cmd);
        }

        if (cmd instanceof CmdIf) {
            return  this.generateIf((CmdIf) cmd);
        }

        if (cmd instanceof CmdRead) {
            return  this.generateRead((CmdRead) cmd);
        }

        if (cmd instanceof CmdWhile) {
            return  this.generateWhile((CmdWhile) cmd);
        }

        return "NOT IMPLEMENTED!";
    }

    public abstract String getFileName(String fileName);
}
