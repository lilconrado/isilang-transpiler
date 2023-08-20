package io.github.lilconrado.isilang.ast;

import io.github.lilconrado.isilang.output.AbstractLanguage;
import io.github.lilconrado.isilang.output.JavaLanguage;
import io.github.lilconrado.isilang.output.TypeScriptLanguage;
import io.github.lilconrado.isilang.symbols.SymbolTable;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class Program {
    private String filename;
    private List<AbstractCommand> commands;
    private SymbolTable symbolTable;

    private AbstractLanguage language;

    public Program() {
        this.commands = new ArrayList<AbstractCommand>();
        //this.language = new JavaLanguage();
        this.language = new TypeScriptLanguage();
        this.filename = this.language.getFileName("output");
    }

    public void generateTarget() {
        try {
            FileWriter fw = new FileWriter(filename);
            PrintWriter pw = new PrintWriter(fw);
            StringBuilder strBuilder = new StringBuilder();

            strBuilder.append(language.generateHeader());
            commands.forEach(c -> {
                strBuilder.append(this.language.generateCode(c));
            });
            strBuilder.append(language.generateFooter());
            pw.println(strBuilder.toString());
            pw.close();
            fw.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<AbstractCommand> getCommands() {
        return commands;
    }

    public void setCommands(List<AbstractCommand> commands) {
        this.commands = commands;
    }

    public SymbolTable getSymbolTable() {
        return symbolTable;
    }

    public void setSymbolTable(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
    }
}
