package io.github.lilconrado.isilang.expressions;

public class IdExpression extends AbstractExpression {
    private String name;
    private Object value;

    public String toString() {
        return this.name;
    }
}
