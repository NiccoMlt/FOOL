package ast;

/**
 * Nodo per il tipo di dato booleano.
 */
public class BoolTypeNode implements Node {

    /**
     * Costruttore.
     */
    public BoolTypeNode() {
    }

    @Override
    public String toPrint(final String s) {
        return s + "BoolType\n";
    }

    // non utilizzato
    @Override
    public Node typeCheck() {
        return null;
    }

    // non utilizzato
    @Override
    public String codeGeneration() {
        return "";
    }

}
