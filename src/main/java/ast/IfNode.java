package ast;

import lib.FOOLlib;

/**
 * Nodo per l'istruzione condizionale "if".
 */
public class IfNode implements Node {

    private final Node cond;
    private final Node th;
    private final Node el;

    /**
     * Costruttore.
     * 
     * @param c la condizione da valutare
     * @param t il blocco di codice da effettuare nel caso la condizione risulti vera (then)
     * @param e il blocco di codice da effettuare nel caso la condizione risulti falsa (else)
     */
    public IfNode(final Node c, final Node t, final Node e) {
        cond = c;
        th = t;
        el = e;
    }

    @Override
    public String toPrint(final String s) {
        return s + "If\n" + cond.toPrint(s + "  ") + th.toPrint(s + "  ") + el.toPrint(s + "  ");
    }

    /**
     * {@inheritDoc}
     * <p>
     * L'operatore richiede il tipo di dato {@link BoolTypeNode booleano} per la condizione da valutare 
     * e ritorna il tipo di dato dei blocchi then e else (devono essere compatibili tra loro).
     */
    @Override
    public Node typeCheck() {
        if (!(FOOLlib.isSubtype(cond.typeCheck(), new BoolTypeNode()))) {
            System.out.println("non boolean condition in if");
            System.exit(0);
        }
        final Node t = th.typeCheck();
        final Node e = el.typeCheck();
        if (FOOLlib.isSubtype(t, e))
            return e;
        if (FOOLlib.isSubtype(e, t))
            return t;
        System.out.println("Incompatible types in then-else branches");
        System.exit(0);
        return null;
    }

    /**
     * {@inheritDoc}
     * <p>
     * L'if è implementato nel modo seguente:
     * <p><ul>
     * <li>viene generato il codice della condizione dell'if;
     * <li>viene effettuato il {@code push} di {@code 1}, ossia {@code true};
     * <li>attraverso l'operatore assembly di salto condizionato {@code BEQ} e 
     *     due label l1 e l2 si verifica la veridicità della condizione:
     * <li>se è vera:
     *     <p><ul>
     *     <li>viene effettuato il salto condizionato alla label l1;
     *     <li>viene generato il codice del blocco then.
     *     </ul>
     * <li>se è falsa:
     *     <p><ul>
     *     <li>non viene effettuato il salto condizionato e viene generato il codice del blocco else;
     *     <li>viene effettuato un salto incondizionato alla label l2 per ignorare l'istruzione a l1.
     *     </ul>
     * </ul>
     */
    @Override
    public String codeGeneration() {
        final String l1 = FOOLlib.freshLabel();
        final String l2 = FOOLlib.freshLabel();
        return cond.codeGeneration() 
               + "push 1\n" 
               + "beq " + l1 + "\n" 
               + el.codeGeneration() 
               + "b " + l2 + "\n" 
               + l1 + ": \n" 
               + th.codeGeneration() 
               + l2 + ": \n";
    }
}