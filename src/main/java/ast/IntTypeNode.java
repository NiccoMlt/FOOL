package ast;

/**
 * Nodo per il tipo di dato intero.
 */
public class IntTypeNode implements Node {

    /**
     * Costruttore.
     */
    public IntTypeNode() {
    }

    @Override
    public String toPrint(String s) {
        return s + "IntType\n";
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
