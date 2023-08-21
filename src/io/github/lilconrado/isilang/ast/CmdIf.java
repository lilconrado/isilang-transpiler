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

    public AbstractExpression getExpr() {
        return expr;
    }

    public List<AbstractCommand> getListTrue() {
        return listTrue;
    }

    public List<AbstractCommand> getListFalse() {
        return listFalse;
    }

    private List<AbstractCommand> listTrue;
    private List<AbstractCommand> listFalse;


}
