package ast;

import lib.FOOLlib;

public class NotNode implements Node {

    private final Node exp;

    /**
     * Costruttore.
     * 
     * @param r l'espressione da negare
     */
    public NotNode(final Node r) {
        exp = r;
    }

    @Override
    public String toPrint(String s) {
        return s + "Not\n" + exp.toPrint(s + "  ");
    }

    /**
     * {@inheritDoc}
     * <p>
     * L'operatore richiede che l'espressione e il tipo di dato di ritorno siano di tipo {@link BoolTypeNode booleano}.
     */
    public Node typeCheck() {
        final Node r = exp.typeCheck();
        if (!FOOLlib.isSubtype(r, new BoolTypeNode())) {
            System.out.println("Incompatible types in not");
            System.exit(0);
        }
        return new BoolTypeNode();
    }

    /**
     * {@inheritDoc}
     * <p>
     * L'operatore di uguaglianza è implementato attraverso l'operatore assembly di salto condizionato {@code BEQ} e 
     * due label l1 e l2:
     * <p><ul>
     * <li>effettua un {@code push} di {@code 0}.
     * <li>se l'espressione è falsa, il suo valore sarà uguale al {@code false} di cui è stato appena effettuato il {@code push}:
     *     <p><ul>
     *     <li>viene effettuato il salto condizionato alla label l1;
     *     <li>viene effettuato un {@code push} di {@code 1} (ossia {@code true}).
     *     </ul>
     * <li>altrimenti:
     *     <p><ul>
     *     <li>non viene effettuato il salto condizionato e viene effettuato un {@code push} di {@code 0} (ossia {@code false});
     *     <li>viene effettuato un salto incondizionato alla label l2 per ignorare l'istruzione a l1.
     *     </ul>
     * </ul>
     */
    @Override
    public String codeGeneration() {
        final String l1 = FOOLlib.freshLabel();
        final String l2 = FOOLlib.freshLabel();
        return exp.codeGeneration() 
             + "push 0\n" 
             + "beq " + l1 + "\n" 
             + "push 1\n" 
             + "b " + l2 + "\n" 
             + l1 + ": \n" 
             + "push 0\n" 
             + l2 + ": \n";
    }
}