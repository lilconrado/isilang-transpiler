package io.github.lilconrado.isilang.symbols;

public class Identifier {
    protected String name;

    protected Type type;

    protected Object value;

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }

    protected boolean isUsed;

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
