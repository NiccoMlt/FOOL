/**
 * Il seguente codice viene utilizzato da ANTLR per generare codice Java delle classi del parse e del lexer.
 */
grammar SimpleExp;

// Campi o metodi della classe del lexer che viene generata
@lexer::members {
	int lexicalErrors=0;
}

// PARSER RULES
/* controlla la struttura della grammatica */

prog 	: exp {System.out.println("Parsing finished!");} ; /* utilizzato per stampare qualcosa */

exp 	: term exp2 ;
exp2 	: PLUS exp | /* epsilon */ ;

term 	: value term2 ;
term2	: TIMES term | /* epsilon */ ;

value	: NUM | LPAR exp RPAR ;

// LEXER RULES
/*
 * controlla la struttura dei token
 * immaginare di avere in input una stringa
 * es. 54*3+(2*43)
 * return implicito
 */

PLUS	: '+';
TIMES	: '*';
LPAR	: '(';
RPAR	: ')';
//NUM2	: '0' | [1-9][0-9]* ;
NUM		: '0' | ('1'..'9')('0'..'9')* ;
WHITESP	: (' '|'\n'|'\t'|'\r')+ -> channel(HIDDEN); /* non ritorna nulla al parser */
COMMENT : ('/*')(.*?)('*/') -> channel(HIDDEN); /* gestisce i commenti */ /* l'aggiunta di ? nella stella di Kleene bypassa la regola del maximal match */

ERR		: . { System.out.println("Invalid char: "+ getText()); lexicalErrors++; } -> channel(HIDDEN); /* esegue il codice java e non ritorna nulla al parser */
	 
