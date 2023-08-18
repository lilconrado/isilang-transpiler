package io.github.lilconrado.isilang.expressions;

public class BinaryExpression extends AbstractExpression {
    private char operator;
    private AbstractExpression left;
    private AbstractExpression right;

    public void setOperator(char operator) {
        this.operator = operator;
    }

    public void setLeft(AbstractExpression left) {
        this.left = left;
    }

    public void setRight(AbstractExpression right) {
        this.right = right;
    }

    @Override
    public Object eval() {
        switch (this.operator) {
            case '+':
                return null;
            case '-':
                return null;
            case '/':
                return null;
            case '*':
                return null;
            default:
                return null;
        }
    }

    public String toString() {
        return this.left.toString() + this.operator + this.right.toString();
    }
}
