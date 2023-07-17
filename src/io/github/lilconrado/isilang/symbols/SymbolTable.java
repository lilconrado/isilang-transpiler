package io.github.lilconrado.isilang.symbols;

import java.util.HashMap;

public class SymbolTable {
    private HashMap<String, Identifier> symbols;

    public SymbolTable() {
        this.symbols = new HashMap<String, Identifier>();
    }

    public Identifier get(String key) {
        return this.symbols.get(key);
    }

    public HashMap<String, Identifier> getSymbols() {
        return symbols;
    }

    public void setSymbols(HashMap<String, Identifier> symbols) {
        this.symbols = symbols;
    }

    public void add(String key, Identifier value) {
        this.symbols.put(key, value);
    }

    public boolean exists(String key) {
        return this.symbols.containsKey(key);
    }
}
