package io.github.lilconrado.isilang.expressions;

import java.util.ArrayList;

public class PolyExpression extends AbstractExpression {
    private ArrayList<AbstractExpression> expressions;

    public PolyExpression() {
        this.expressions = new ArrayList<AbstractExpression>();
        this.operators = new ArrayList<String>();
    }

    public ArrayList<AbstractExpression> getExpressions() {
        return expressions;
    }

    public void setExpressions(ArrayList<AbstractExpression> expressions) {
        this.expressions = expressions;
    }

    public ArrayList<String> getOperators() {
        return operators;
    }

    public void setOperators(ArrayList<String> operators) {
        this.operators = operators;
    }

    private ArrayList<String> operators;

    public void addExpression(AbstractExpression expr) {
        expressions.add(expr);
    }

    public void addOperator(String op) {
        operators.add(op);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < expressions.size(); i++) {
            sb.append(expressions.get(i).toString());

            if (i < expressions.size() - 1) {
                sb.append(operators.get(i));
            }
        }

        return sb.toString();
    }
}
