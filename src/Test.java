import org.antlr.v4.runtime.*;

/**
 * Il seguente codice mette in esecuzione il tutto:
 * <p><ul>
 * <li>si aspetta che lo stream input sia presente in un file denominato prova.txt;
 * <li>legge un {@link CharStream} dal file;
 * <li>passa il {@link CharStream} al Lexer;
 * <li>crea un {@link TokenStream} dal Lexer;
 * <li>passa il {@link TokenStream} al Parser;
 * <li>analizza il programma;
 * <li>stampa il resoconto.
 * </ul><p>
 */
public class Test {
	
	/**
	 * Mette in esecuzione il codice, caricando la stringa da un file prova.txt.
	 * 
	 * @param args argomenti del metodo main, inutili
	 * @throws Exception nel caso in cui vengano tirate eccezioni per errori vari
	 */
    public static void main(String[] args) throws Exception {
        String filename="prova.txt";

        CharStream chars = CharStreams.fromFileName(filename);
        SimpleExpLexer lexer = new SimpleExpLexer(chars);
    	
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SimpleExpParser parser = new SimpleExpParser(tokens);
        
        parser.prog();
        
        System.out.println("You had: "+lexer.lexicalErrors+" lexical errors and "+
                           parser.getNumberOfSyntaxErrors()+" syntax errors.");
        
    }
}
