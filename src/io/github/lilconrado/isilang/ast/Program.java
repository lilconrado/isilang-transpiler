package io.github.lilconrado.isilang.ast;

import io.github.lilconrado.isilang.symbols.SymbolTable;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Program {
    private String filename;
    private List<AbstractCommand> comandos;
    private SymbolTable symbolTable;

    public Program() {
        this.filename = "output.c";
        this.comandos = new ArrayList<AbstractCommand>();
    }

    public void generateTarget() {
        try {
            FileWriter fw = new FileWriter(filename);
            PrintWriter pw = new PrintWriter(fw);
            StringBuilder strBuilder = new StringBuilder();
            comandos.forEach(c -> {
                System.out.print(c.generateCode());
                strBuilder.append(c.generateCode());
            });
            pw.println(strBuilder.toString());
            pw.close();
            fw.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<AbstractCommand> getComandos() {
        return comandos;
    }

    public void setComandos(List<AbstractCommand> comandos) {
        this.comandos = comandos;
    }

    public SymbolTable getSymbolTable() {
        return symbolTable;
    }

    public void setSymbolTable(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
    }

    public void run() {
        comandos.stream().forEach(c -> {
            c.run();
            System.out.println(symbolTable.getSymbols().values());
        });
    }
}
