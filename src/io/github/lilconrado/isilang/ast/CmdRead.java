package io.github.lilconrado.isilang.ast;

import io.github.lilconrado.isilang.symbols.Identifier;

public class CmdRead extends AbstractCommand {
    static boolean firstScanner = false;
    private Identifier id;
    public CmdRead(Identifier id) {
        super();
        this.id = id;
    }
    @Override
    public String generateCode() {
        StringBuilder code = new StringBuilder() ;
        if(!firstScanner){
            code.append( "Scanner scanner = new Scanner(System.in);\n");
            firstScanner = true;
        }
        switch(id.getType()){
            case INTEGER:
                code.append( String.format("%s=scanner.nextInt();\n", id.getName()));
                break;
            case REAL:
                code.append( String.format("%s=scanner.nextDouble();\n", id.getName()));
                break;
            case STRING:
                code.append(String.format("%s=scanner.nextLine();\n", id.getName()));
                break;
            default:
                throw new RuntimeException();
        }
        return code.toString();
    }
}
