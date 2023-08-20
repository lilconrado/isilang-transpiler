package io.github.lilconrado.isilang.ast;

import io.github.lilconrado.isilang.expressions.AbstractExpression;

import java.util.List;

public class CmdDoWhile extends AbstractCommand {
    private AbstractExpression expr;
    private List<AbstractCommand> listTrue;

    public AbstractExpression getExpr() {
        return expr;
    }

    public List<AbstractCommand> getListTrue() {
        return listTrue;
    }

    public void setExpr(AbstractExpression expr) {
        this.expr = expr;
    }

    public void setListTrue(List<AbstractCommand> listTrue) {
        this.listTrue = listTrue;
    }

    @Override
    public String generateCode() {
        StringBuilder sbTrue = new StringBuilder();

        for (AbstractCommand cmd: listTrue) {
            sbTrue.append(cmd.generateCode());
        }

        return String.format("do {\n%s} while(%s);\n", sbTrue.toString(), expr.toString());
    }
}
