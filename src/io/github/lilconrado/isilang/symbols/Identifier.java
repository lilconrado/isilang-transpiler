package io.github.lilconrado.isilang.symbols;

public class Identifier {
    protected String name;

    protected Types type;

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

    public Types getType() {
        return type;
    }

    public void setType(Types type) {
        this.type = type;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Identifier(String name, Types type) {
        this.name = name;
        this.type = type;
    }
}
