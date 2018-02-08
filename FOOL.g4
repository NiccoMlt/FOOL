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

prog returns [Node ast] : e=exp {$ast=$e.ast;} SEMIC ; // ProgNode ha un campo Node
	 	
exp	returns [Node ast] : t=term {$ast=$t.ast;} 
                         (PLUS t=term {$ast=new PlusNode($ast,$t.ast);})* ; 
 	
term returns [Node ast] : f=factor {$ast=$f.ast;} 
                         (TIMES f=factor {$ast=new TimesNode($ast,$f.ast);})* ; 
	 
factor returns [Node ast] : v=value {$ast=$v.ast;} (EQ value)* ;  // EqNode
  	          	
value returns [Node ast] : 
      i=INTEGER {$ast=new IntNode(Integer.parseInt($i.text));}  
	| TRUE   // BoolNode(true) ha un campo boolean
	| FALSE  // BoolNode(false) ha un campo boolean
	| LPAR e=exp RPAR {$ast=$e.ast;} 
	| IF exp THEN CLPAR exp CRPAR // IfNode ha 3 campi Node
		   ELSE CLPAR exp CRPAR 
	| PRINT LPAR exp RPAR // PrintNode ha un campo Node	
 	; 

  		
/*------------------------------------------------------------------
 * LEXER RULES
 *------------------------------------------------------------------*/
SEMIC	: ';' ;
EQ	    : '==' ;
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
