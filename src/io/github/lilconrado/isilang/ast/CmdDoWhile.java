package io.github.lilconrado.isilang.ast;

import io.github.lilconrado.isilang.expressions.AbstractExpression;

import java.util.List;

public class CmdDoWhile extends AbstractCommand {
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
        StringBuilder sbFalse = new StringBuilder();

        for (AbstractCommand cmd: listTrue) {
            sbTrue.append(cmd.generateCode());
        }



        return String.format("do {\n%s} while(%s);\n%s", expr.toString(), sbTrue.toString(), sbFalse.toString());
    }


    @Override
    public void run() {

    }
}
