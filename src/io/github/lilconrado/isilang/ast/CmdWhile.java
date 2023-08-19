package io.github.lilconrado.isilang.ast;
import io.github.lilconrado.isilang.expressions.AbstractExpression;
import io.github.lilconrado.isilang.symbols.Identifier;

import java.util.List;

public class CmdWhile extends AbstractCommand{
    private AbstractExpression expr;
    private List<AbstractCommand> listTrue;

    private List<AbstractCommand> listFalse;


    public void setExpr(AbstractExpression expr) {
        this.expr = expr;
    }

    public void setListTrue(List<AbstractCommand> listTrue) {
        this.listTrue = listTrue;
    }

    public void setListFalse(List<AbstractCommand> listFalse) {
        this.listFalse = listFalse;
    }

    @Override
    public String generateCode() {
        StringBuilder sbTrue = new StringBuilder();
        //StringBuilder sbFalse = new StringBuilder();

        for (AbstractCommand cmd: listTrue) {
            sbTrue.append(cmd.generateCode());
        }



        return String.format("while(%s) {\n%s}\n%s", expr.toString(), sbTrue.toString() );
    }

    @Override
    public void run() {

    }
}
