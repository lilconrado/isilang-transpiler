package io.github.lilconrado.isilang.expressions;

public class RealExpression extends AbstractExpression {
    public RealExpression(String text) {
       super();
       this.value = Double.parseDouble(text);
    }

    public RealExpression() {
        super();
    }

    private double value;

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String toString() {
        return String.valueOf(value);
    }
}
