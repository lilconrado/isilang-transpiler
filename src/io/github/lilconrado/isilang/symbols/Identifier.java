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

    public void setType(Type type) {
        this.type = type;
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

    public static Type queryType(String value) {
        return Type.INTEGER;
    }
}
