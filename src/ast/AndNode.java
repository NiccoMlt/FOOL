package ast;

import lib.FOOLlib;

/**
 * Nodo per l'operatore AND "&&".
 */
public class AndNode implements Node {

    private final Node left;
    private final Node right;

    /**
     * Costruttore.
     * 
     * @param l operando a sinistra dell'operatore
     * @param r operando a destra dell'opertatore
     */
    public AndNode(final Node l, final Node r) {
        left = l;
        right = r;
    }

    @Override
    public String toPrint(final String s) {
        return s + "And\n" + left.toPrint(s + "  ") + right.toPrint(s + "  ");
    }

    /**
     * {@inheritDoc}
     * <p>
     * L'operatore && utilizza il tipo di dato {@link BoolTypeNode booleano}.
     */
    @Override
    public Node typeCheck() {
        final Node l = left.typeCheck();
        final Node r = right.typeCheck();
        if (!(FOOLlib.isSubtype(l, r) || FOOLlib.isSubtype(r, l))) {
            System.out.println("Incompatible types in equal");
            System.exit(0);
        }
        return new BoolTypeNode();
    }

    /**
     * {@inheritDoc}
     * <p>
     * L'operatore && è implementato nel modo seguente:
     * <p><ul>
     * <li>viene effettuato un push del valore decimale {@code 2};
     * <li>viene effettuata la somma dei due operandi booleani; poiché essi possono assumere esclusivamente i valori 
     *     {@code 0} e {@code 1}, && deve restituire {@code true} solo nel caso in cui la somma abbia valore {@code 2};
     * <li>attraverso l'operatore assembly di salto condizionato {@code BEQ} e 
     *     due label l1 e l2 si confronta il {@code 2} con il valore della somma:
     * <li>se sono uguali:
     *     <p><ul>
     *     <li>viene effettuato il salto condizionato alla label l1;
     *     <li>viene effettuato un {@code push} di {@code 1}.
     *     </ul>
     * <li>se non sono uguali:
     *     <p><ul>
     *     <li>non viene effettuato il salto condizionato e viene effettuato un {@code push} di {@code 0};
     *     <li>viene effettuato un salto incondizionato alla label l2 per ignorare l'istruzione a l1.
     *     </ul>
     * </ul>
     */
    @Override
    public String codeGeneration() {
        final String l1 = FOOLlib.freshLabel();
        final String l2 = FOOLlib.freshLabel();
        return "push 2\n" 
               + left.codeGeneration() + right.codeGeneration() + "add\n"
               + "beq " + l1 + "\n"
               + "push 0\n"
               + "b " + l2 + "\n"
               + l1 + ": \n"
               + "push 1\n"
               + l2 + ": \n";
    }
}
