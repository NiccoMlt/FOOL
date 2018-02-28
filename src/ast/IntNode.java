package ast;

/**
 * Nodo per il tipo intero.
 */
public class IntNode implements Node {

    private final Integer val;

    /**
     * Costruttore.
     * 
     * @param n il valore intero decimale
     */
    public IntNode(final Integer n) {
        val = n;
    }

    @Override
    public String toPrint(final String s) {
        return s + "Int:" + Integer.toString(val) + "\n";
    }

    /**
     * {@inheritDoc}
     * <p>
     * Utilizza il tipo di dato {@link IntTypeNode intero}.
     */
    @Override
    public Node typeCheck() {
        return new IntTypeNode();
    }

    /**
     * {@inheritDoc}
     * <p>
     * Il dato è implementato effettuando un {@code push} del valore intero.
     */
    @Override
    public String codeGeneration() {
        return "push " + val + "\n";
    }
}