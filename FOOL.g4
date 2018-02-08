/*
 * Esempio
 * 
 * Input    :=    1+2+3
 * 
 * Output   := 	   +
 *               /   \
 *              +     3
 *             / \
 *            1   2
 * 
 */
grammar FOOL;

@header {
import ast.*;
}

@lexer::members {
int lexicalErrors=0;
}


/*------------------------------------------------------------------
 * PARSER RULES
 *------------------------------------------------------------------*/

prog : exp SEMIC ; 
	 	
exp	: term (PLUS term)* ; 
 	
term : factor (TIMES factor)* ; 
	 
factor : value (EQ value)* ;	 	
  	          	
value	: 
    INTEGER   
	| TRUE      
	| FALSE     
	| LPAR exp RPAR   
	| IF exp THEN CLPAR exp CRPAR 
		   ELSE CLPAR exp CRPAR 
	| PRINT LPAR exp RPAR	
 	; 

  		
/*------------------------------------------------------------------
 * LEXER RULES
 *------------------------------------------------------------------*/
SEMIC	: ';' ;
EQ	: '==' ;
PLUS	: '+' ;
TIMES	: '*' ;
INTEGER : ('-')?(('1'..'9')('0'..'9')*) | '0';
TRUE	: 'true' ;
FALSE	: 'false' ;
LPAR 	: '(' ;
RPAR	: ')' ;
CLPAR 	: '{' ;
CRPAR	: '}' ;
IF 	: 'if' ;
THEN 	: 'then' ;
ELSE 	: 'else' ;
PRINT	: 'print' ; 

 
WHITESP : (' '|'\t'|'\n'|'\r')+ -> channel(HIDDEN) ;
COMMENT : '/*' (.)*? '*/' -> channel(HIDDEN) ;

ERR	    : . { System.out.println("Invalid char: "+ getText()); lexicalErrors++; } -> channel(HIDDEN); 
