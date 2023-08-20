package io.github.lilconrado.isilang.expressions;

import io.github.lilconrado.isilang.symbols.Identifier;

public class AttributionExpression extends AbstractExpression {
    private Identifier left;
    private Identifier right;

    public AttributionExpression(Identifier left, Identifier right) {
        this.left = left;
        this.right = right;
    }

    public String toString() {
        return String.format("%s", this.right.getName());
    }
}
