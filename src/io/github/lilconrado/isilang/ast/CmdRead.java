package io.github.lilconrado.isilang.ast;

import io.github.lilconrado.isilang.symbols.Identifier;

public class CmdRead extends AbstractCommand {
    private Identifier id;
    public CmdRead(Identifier id) {
        super();
        this.id = id;
    }
    @Override
    public String generateCode() {
        // scanner precisa trazer uma vez soh
        String code = "";
        switch(id.getType()){
            case INTEGER:
                code = String.format("Scanner scanner = new Scanner(System.in);\n%s=.nextInt()", id.getName());
                break;
            case REAL:
                code = String.format("Scanner scanner = new Scanner(System.in);\n%s=.nextDouble()", id.getName());
                break;
            case STRING:
                code = String.format("Scanner scanner = new Scanner(System.in);\n%s=.nextLine()", id.getName());
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
