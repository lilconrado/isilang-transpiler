package io.github.lilconrado.isilang.main;

import io.github.lilconrado.isilang.exceptions.SemanticException;
import io.github.lilconrado.isilang.parser.IsiLangLexer;
import io.github.lilconrado.isilang.parser.IsiLangParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class Main {
    public static void main(String[] args) {
        try {
            var charStream = CharStreams.fromFileName("input.isi");

            IsiLangLexer lexer = new IsiLangLexer(charStream);
            var tokenStream = new CommonTokenStream(lexer);

            var parser = new IsiLangParser(tokenStream);

            var a = parser.prog();

            System.out.println("Compilation Successful");
        } catch (SemanticException ex) {
            System.err.println("Semantic error: " + ex.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}