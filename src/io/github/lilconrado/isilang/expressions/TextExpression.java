package io.github.lilconrado.isilang.expressions;

public class TextExpression extends AbstractExpression {
    private String value;

    public TextExpression(String value) {
        super();
        this.value = value;
    }

    public TextExpression() {
        super();
    }

    @Override
    public String eval() {
        return this.value;
    }

    public String toString() {
        return this.value;
    }
}
