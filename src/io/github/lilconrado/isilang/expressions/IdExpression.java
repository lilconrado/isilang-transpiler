package io.github.lilconrado.isilang.expressions;

public class IdExpression extends AbstractExpression {
    private String name;
    private Object value;

    @Override
    public Object eval() {
        return this.value;
    }

    public String toString() {
        return this.name;
    }
}
