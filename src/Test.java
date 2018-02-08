import org.antlr.v4.runtime.*;

/**
 * Il seguente codice mette in esecuzione il tutto:
 * <p><ul>
 * <li>si aspetta che lo stream input sia presente in un file denominato quicksort.fool.asm;
 * <li>legge un {@link CharStream} dal file;
 * <li>passa il {@link CharStream} al {@link SVMLexer};
 * <li>crea un {@link CommonTokenStream} dal Lexer;
 * <li>passa il {@link CommonTokenStream} al {@link SVMParser};
 * <li>assembla il codice e stampa eventuali errori lessicali;
 * <li>stampa il resoconto.
 * </ul><p>
 */
public class Test {
	
	/**
	 * Mette in esecuzione il codice, caricando la stringa da un file quicksort.fool.asm.
	 * 
	 * @param args argomenti del metodo main, inutili
	 * @throws Exception nel caso in cui vengano tirate eccezioni per errori vari
	 */
    public static void main(String[] args) throws Exception {
     
        String fileName = "quicksort.fool.asm";
                
        CharStream chars = CharStreams.fromFileName(fileName);
        SVMLexer lexer = new SVMLexer(chars);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SVMParser parser = new SVMParser(tokens);
        
        
        parser.assembly();
        
        System.out.println("You had: "+lexer.lexicalErrors+" lexical errors and "+parser.getNumberOfSyntaxErrors()+" syntax errors.");
        if (lexer.lexicalErrors>0 || parser.getNumberOfSyntaxErrors()>0) System.exit(1);

        System.out.println("Starting Virtual Machine...");
        ExecuteVM vm = new ExecuteVM(parser.code);
        vm.cpu();
        
      
    }
}
