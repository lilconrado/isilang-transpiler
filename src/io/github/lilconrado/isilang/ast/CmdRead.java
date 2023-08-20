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
        String code = "" ;
        if(!firstScanner){
            code= "Scanner scanner = new Scanner(System.in);\n";
            firstScanner = true;
        }
        switch(id.getType()){
            case INTEGER:
                code += String.format("%s=.nextInt();\n", id.getName());
                break;
            case REAL:
                code += String.format("%s=.nextDouble();\n", id.getName());
                break;
            case STRING:
                code += String.format("%s=.nextLine();\n", id.getName());
                break;
            default:
                throw new RuntimeException();
        }
        return code;
    }

    @Override
    public void run() {

    }
}
