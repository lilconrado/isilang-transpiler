package io.github.lilconrado.isilang.ast;
import io.github.lilconrado.isilang.expressions.AbstractExpression;
import io.github.lilconrado.isilang.symbols.Identifier;

import java.util.List;

public class CmdWhile extends AbstractCommand{
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



}
