package io.github.lilconrado.isilang.ast;

import io.github.lilconrado.isilang.expressions.AbstractExpression;
import io.github.lilconrado.isilang.symbols.Identifier;

public class CmdAttrib extends AbstractCommand{
    public CmdAttrib(Identifier id, AbstractExpression expr) {
        super();
        this.id = id;
        this.expr = expr;
    }

    public CmdAttrib(Identifier id) {
        super();
        this.id = id;
    }

    public CmdAttrib() {
        super();
    }

    public Identifier getId() {
        return id;
    }

    public void setId(Identifier id) {
        this.id = id;
    }

    public AbstractExpression getExpr() {
        return expr;
    }

    public void setExpr(AbstractExpression expr) {
        this.expr = expr;
    }

    private Identifier id;
    private AbstractExpression expr;


}
