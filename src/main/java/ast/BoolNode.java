package ast;

/**
 * Nodo per il tipo booleano.
 */
public class BoolNode implements Node {
    private final boolean val;

    /**
     * Costruttore.
     * 
     * @param n il valore booleano
     */
    public BoolNode(final boolean n) {
        val = n;
    }

    @Override
    public String toPrint(final String s) {
        if (val) {
            return s + "Bool:true\n";
        } else {
            return s + "Bool:false\n";
        }
    }

    /**
     * {@inheritDoc}
     * <p>
     * Utilizza il tipo di dato {@link BoolTypeNode booleano}.
     */
    @Override
    public Node typeCheck() {
        return new BoolTypeNode();
    }

    /**
     * {@inheritDoc}
     * <p>
     * Il dato è implementato effettuando un {@code push} di un valore intero:
     * <p><ul>
     * <li>{@code 0} corrisponde a {@code false};
     * <li>{@code 1} corrisponde a {@code true}.
     * </ul>
     */
    @Override
    public String codeGeneration() {
        return "push " + (val ? 1 : 0) + "\n";
    }
}
