package io.github.lilconrado.isilang.symbols;

public class Identifier {
    protected String name;

    protected Type type;

    protected Object value;

    @Override
    public String toString() {
        return "Identifier [name=" + name + ", type=" + type + ", value=" + value + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(String value) {
        if (this.type != Type.UNDEFINED) {
            return;
        }

        if (value.charAt(0) == '"') {
            this.type = Type.STRING;
        } else if (value.matches("[+-]?[0-9]*")) {
            this.type = Type.INTEGER;
        } else if (value.matches("[+-]?[0-9]*\\.[0-9]+")) {
            this.type = Type.REAL;
        }
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Identifier(String name) {
        this.name = name;
        this.type = Type.UNDEFINED;
    }

    public Identifier(String name, Type type) {
        this.name = name;
        this.type = type;
    }
}
