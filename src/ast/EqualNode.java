package ast;

import lib.FOOLlib;

/**
 * Nodo per l'operatore di uguaglianza "==".
 */
public class EqualNode implements Node {

    private final Node left;
    private final Node right;

    /**
     * Costruttore.
     * 
     * @param l l'operando a sinistra dell'operatore
     * @param r l'operando a destra dell'operatore
     */
    public EqualNode(final Node l, final Node r) {
        left = l;
        right = r;
    }

    @Override
    public String toPrint(final String s) {
        return s + "Equal\n" + left.toPrint(s + "  ") + right.toPrint(s + "  ");
    }

    /**
     * {@inheritDoc}
     * <p>
     * L'operatore == richiede che i due operandi siano dello stesso tipo 
     * e ritorna un tipo di dato {@link BoolTypeNode booleano}.
     */
    @Override
    public Node typeCheck() {
        final Node l = left.typeCheck();
        final Node r = right.typeCheck();
        if (l instanceof ArrowTypeNode || r instanceof ArrowTypeNode) {
            System.out.println("Expression comparison not supported");
            System.exit(0);
        }
        if (!(FOOLlib.isSubtype(l, r) || FOOLlib.isSubtype(r, l))) {
            System.out.println("Incompatible types in equal");
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
     * <li>se i due operandi sono uguali:
     *     <p><ul>
     *     <li>viene effettuato il salto condizionato alla label l1;
     *     <li>viene effettuato un {@code push} di {@code 1} (ossia {@code true}).
     *     </ul>
     * <li>se i due operandi non sono uguali:
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
        return left.codeGeneration() 
             + right.codeGeneration() 
             + "beq " + l1 + "\n" 
             + "push 0\n" 
             + "b " + l2 + "\n" 
             + l1 + ": \n" 
             + "push 1\n" 
             + l2 + ": \n";
    }
}
