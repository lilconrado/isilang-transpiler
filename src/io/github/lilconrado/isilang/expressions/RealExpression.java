package io.github.lilconrado.isilang.expressions;

public class RealExpression extends AbstractExpression {
    public RealExpression(float value) {
       super();
       this.value = value;
    }

    public RealExpression() {
        super();
    }

    private float value;

    public float getValue() {
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
