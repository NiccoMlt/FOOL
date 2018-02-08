import java.io.*;
import org.antlr.v4.runtime.*;


public class Test {
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
