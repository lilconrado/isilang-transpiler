package io.github.lilconrado.isilang.expressions;

public class IntegerExpression extends AbstractExpression {
    public IntegerExpression(String text) {
       super();
       this.value = Integer.parseInt(text);
    }

    public IntegerExpression() {
        super();
    }

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public Object eval() {
        return value;
    }

    public String toString() {
        return String.valueOf(value);
    }
}
