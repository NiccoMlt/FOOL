package ast;

public interface Node {

    /**
     * Stampa il una descrizione testuale dell'operazione.
     * 
     * @param indent una stringa di prefisso
     */
    String toPrint(String indent);

    /**
     * Fa il type checking e ritorna:
     * <p>
     * - per una espressione, il suo tipo (oggetto BoolTypeNode o IntTypeNode);
     * <p>
     * - per una dichiarazione, "null"
     * 
     * @return il tipo oppure null
     */
    Node typeCheck();

    /**
     * Ritorna il codice assembly in formato stringa.
     * 
     * @return il codice assembly
     */
    String codeGeneration();

}