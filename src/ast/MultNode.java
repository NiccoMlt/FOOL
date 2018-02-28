package ast;

import lib.FOOLlib;

/**
 * Nodo per l'operatore moltiplicazione "*".
 */
public class MultNode implements Node {

    private final Node left;
    private final Node right;

    /**
     * Costruttore.
     * 
     * @param l il fattore di sinistra
     * @param r il fattore di destra
     */
    public MultNode(final Node l, final Node r) {
        left = l;
        right = r;
    }

    @Override
    public String toPrint(String s) {
        return s + "Mult\n" + left.toPrint(s + "  ") + right.toPrint(s + "  ");
    }

    /**
     * {@inheritDoc}
     * <p>
     * L'operatore * richiede il tipo di dato {@link IntTypeNode intero} sia per gli operandi che per il valore di ritorno.
     */
    @Override
    public Node typeCheck() {
        if (!(FOOLlib.isSubtype(left.typeCheck(), new IntTypeNode())
                        && FOOLlib.isSubtype(right.typeCheck(), new IntTypeNode()))) {
            System.out.println("Non integers in multiplication");
            System.exit(0);
        }
        return new IntTypeNode();
    }

    /**
     * {@inheritDoc}
     * <p>
     * L'operatore è implementato attraverso l'operatore nativo assembly {@code mult}.
     */
    @Override
    public String codeGeneration() {
        return left.codeGeneration() + right.codeGeneration() + "mult\n";
    }
}