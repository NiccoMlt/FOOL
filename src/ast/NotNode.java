package ast;

import lib.FOOLlib;

public class NotNode implements Node {

    private Node exp;

    public NotNode(Node r) {
        exp = r;
    }

    public String toPrint(String s) {
        return s + "Not\n" + exp.toPrint(s + "  ");
    }

    public Node typeCheck() {
        Node r = exp.typeCheck();
        if (!FOOLlib.isSubtype(r, new BoolTypeNode())) {
            System.out.println("Incompatible types in not");
            System.exit(0);
        }
        return new BoolTypeNode();
    }

    public String codeGeneration() {
        String l1 = FOOLlib.freshLabel();
        String l2 = FOOLlib.freshLabel();
        return exp.codeGeneration() + "push 0\n" + "beq " + l1 + "\n" + "push 1\n" + "b " + l2 + "\n" + l1
                        + ": \n" + "push 0\n" + l2 + ": \n";
    }
}