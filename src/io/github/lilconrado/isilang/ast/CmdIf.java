package io.github.lilconrado.isilang.ast;

import io.github.lilconrado.isilang.expressions.AbstractExpression;

import java.util.List;

public class CmdIf extends AbstractCommand {
    private AbstractExpression expr;

    public void setExpr(AbstractExpression expr) {
        this.expr = expr;
    }

    public void setListTrue(List<AbstractCommand> listTrue) {
        this.listTrue = listTrue;
    }

    public void setListFalse(List<AbstractCommand> listFalse) {
        this.listFalse = listFalse;
    }

    private List<AbstractCommand> listTrue;
    private List<AbstractCommand> listFalse;

    @Override
    public String generateCode() {
        StringBuilder sbTrue = new StringBuilder();
        StringBuilder sbFalse = new StringBuilder();

        for (AbstractCommand cmd: listTrue) {
            sbTrue.append(cmd.generateCode());
        }

        if (!listFalse.isEmpty()) {
            sbFalse.append("else {\n");

            for (AbstractCommand cmd: listFalse) {
                sbFalse.append(cmd.generateCode());
            }

            sbFalse.append("}\n");
        }

        return String.format("if (%s) {\n%s}\n%s", expr.toString(), sbTrue.toString(), sbFalse.toString());
    }

    @Override
    public void run() {

    }
}
