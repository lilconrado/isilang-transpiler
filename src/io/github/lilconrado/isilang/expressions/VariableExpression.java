package io.github.lilconrado.isilang.expressions;

import io.github.lilconrado.isilang.symbols.Identifier;

public class VariableExpression extends AbstractExpression {
    private Identifier id;

    public VariableExpression(Identifier id) {
        this.id = id;
    }

    public String toString() {
        return this.id.getName();
    }
}
