import ast.Node;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Test {
	public static void main(final String[] args) throws Exception {
		for (int i = 0; i < 4; i++) {
			test("test" + (i + 1) + ".fool");
		}
	}

	public static void test(final String fileName) throws IOException {
		final CharStream chars = CharStreams.fromFileName(fileName);
		final FOOLLexer lexer = new FOOLLexer(chars);
		final CommonTokenStream tokens = new CommonTokenStream(lexer);
		final FOOLParser parser = new FOOLParser(tokens);

		final Node ast = parser.prog().ast; // generazione AST con Id associate a relative entry symbol table

		System.out.println("You had: " + lexer.lexicalErrors + " lexical errors and " + parser.getNumberOfSyntaxErrors()
				+ " syntax errors.");

		System.out.println("Visualizing AST...");
		System.out.print(ast.toPrint(""));

		final Node type = ast.typeCheck(); // type-checking bottom-up
		System.out.println(type.toPrint("Type checking ok! Type of the program is: "));

		// CODE GENERATION prova.fool.asm
		final String code = ast.codeGeneration();
		final BufferedWriter out = new BufferedWriter(new FileWriter(fileName + ".asm"));
		out.write(code);
		out.close();

		System.out.println("Code generated! Assembling and running generated code.");

		final CharStream charsASM = CharStreams.fromFileName(fileName + ".asm");
		final SVMLexer lexerASM = new SVMLexer(charsASM);
		final CommonTokenStream tokensASM = new CommonTokenStream(lexerASM);
		final SVMParser parserASM = new SVMParser(tokensASM);

		parserASM.assembly();

		System.out.println("You had: " + lexerASM.lexicalErrors + " lexical errors and "
				+ parserASM.getNumberOfSyntaxErrors() + " syntax errors.");
		if (lexerASM.lexicalErrors > 0 || parserASM.getNumberOfSyntaxErrors() > 0) {
			System.exit(1);
		}

		System.out.println("Starting Virtual Machine...");
		final ExecuteVM vm = new ExecuteVM(parserASM.code);
		vm.cpu();
	}
}
