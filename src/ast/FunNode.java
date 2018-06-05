package ast;

import java.util.ArrayList;

import lib.FOOLlib;

public class FunNode implements Node {

    private String id;
    private Node type;
    private ArrayList<Node> parlist = new ArrayList<Node>(); // campo "parlist" che è lista di Node
    private ArrayList<Node> declist = new ArrayList<Node>();
    private Node exp;

    public FunNode(String i, Node t) {
        id = i;
        type = t;
    }

    public void addDec(ArrayList<Node> d) {
        declist = d;
    }

    public void addBody(Node b) {
        exp = b;
    }

    public void addPar(Node p) { // metodo "addPar" che aggiunge un nodo a campo "parlist"
        parlist.add(p);
    }

    public String toPrint(String s) {
        String parlstr = "";
        for (Node par : parlist) {
            parlstr += par.toPrint(s + "  ");
        }

        String declstr = "";
        for (Node dec : declist) {
            declstr += dec.toPrint(s + "  ");
        }

        return s + "Fun:" + id + "\n" + type.toPrint(s + "  ") + parlstr + declstr + exp.toPrint(s + "  ");
    }

    public Node typeCheck() {
        for (Node dec : declist) {
            dec.typeCheck();
        }
        ;
        if (!FOOLlib.isSubtype(exp.typeCheck(), type)) {
            System.out.println("Incompatible value for variable");
            System.exit(0);
        }
        return null;
    }

    public String codeGeneration() {
        String funl = FOOLlib.freshFunLabel();

        String declCode = "";
        for (Node dec : declist) {
            declCode += dec.codeGeneration();
        }

        String popDecl = "";
        for (Node dec : declist) {
            popDecl += "pop\n";
        }

        String popParl = "";
        for (Node par : parlist) {
            popParl += "pop\n";
        }

        FOOLlib.putCode(funl + ":\n" + "cfp\n" + // setta $fp allo $sp
                        "lra\n" + // inserimento Return Address
                        declCode + exp.codeGeneration() + //Code generation per il CORPO della F.
                        "srv\n" + // pop del return value e memorizzazione in $rv
                        popDecl + // una pop per ogni dichiarazione
                        "sra\n" + // pop del Return Address e memorizzazione in $ra
                        "pop\n" + // pop di Access Link
                        popParl + //pop di tutti i parametri
                        "sfp\n" + // ripristino il $fp al valore del Control Link
                        "lrv\n" + // risultato della funzione sullo stack
                                  // pushare sulla cima dello stack il risultato della F.
                        "lra\n" + "js\n" // salta a $ra e ridà il controllo al chiamante
        );

        return "push " + funl + "\n"; //push della label della Funzione
    }
}
