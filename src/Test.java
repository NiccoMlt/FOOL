import org.antlr.v4.runtime.*;

import ast.Node;

/**
 * Il seguente codice mette in esecuzione il tutto:
 * <p><ul>
 * <li>si aspetta che lo stream input sia presente in un file denominato prova.fool;
 * <li>legge un {@link CharStream} dal file;
 * <li>passa il {@link CharStream} al {@link FOOLLexer};
 * <li>crea un {@link CommonTokenStream} dal Lexer;
 * <li>passa il {@link CommonTokenStream} al {@link FOOLParser};
 * <li>costruisce l'albero e stampa eventuali errori lessicali;
 * <li>stampa l'albero AST.
 * </ul><p>
 */
public class Test {
    
    /**
	 * Mette in esecuzione il codice, caricando la stringa da un file prova.fool.
	 * 
	 * @param args argomenti del metodo main, inutili
	 * @throws Exception nel caso in cui vengano tirate eccezioni per errori vari
	 */
    public static void main(String[] args) throws Exception {
      
        String fileName = "prova.fool";
      
        CharStream chars = CharStreams.fromFileName(fileName);
        FOOLLexer lexer = new FOOLLexer(chars);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        FOOLParser parser = new FOOLParser(tokens);
        
        Node ast = parser.prog().ast;
        
        System.out.println("You had: "+lexer.lexicalErrors+" lexical errors and "+parser.getNumberOfSyntaxErrors()+" syntax errors.");

        System.out.println("Visualizing AST...");
        System.out.print(ast.toPrint(""));
        
    }
}
