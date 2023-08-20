package io.github.lilconrado.isilang.symbols;

public class Identifier {
    protected String name;

    protected Type type;

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }

    protected boolean isUsed;

    @Override
    public String toString() {
        return "Identifier [name=" + name + ", type=" + type + "]";
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

    public Identifier(String name) {
        this.name = name;
        this.type = Type.UNDEFINED;
    }

    public Identifier(String name, Type type) {
        this.name = name;
        this.type = type;
    }
}
