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

prog	returns [Node ast]
	: e=exp SEMIC	
          {$ast = new ProgNode($e.ast);}
	;
	 	 
exp	returns [Node ast]
 	: f=term {$ast= $f.ast;}
 	    (PLUS l=term
 	     {$ast= new PlusNode ($ast,$l.ast);}
 	    )*
 	;
 	
term	returns [Node ast]  
	: f=factor {$ast= $f.ast;}
	    (TIMES l=factor
	     {$ast= new TimesNode ($ast,$l.ast);}
	    )*
	;
	
factor	returns [Node ast]  //
	: f=value {$ast= $f.ast;}
	    (EQ l=value 
	     {$ast= new EqualNode ($ast,$l.ast);}
	    )*
 	;	 	
 	          	
value	returns [Node ast]
	: n=INTEGER   
	  {$ast= new IntNode(Integer.parseInt($n.text));}  
	| TRUE 
	  {$ast= new BoolNode(true);}  //
	| FALSE
	  {$ast= new BoolNode(false);}  //
	| LPAR e=exp RPAR
	  {$ast= $e.ast;}  
	| IF x=exp THEN CLPAR y=exp CRPAR  //
		   ELSE CLPAR z=exp CRPAR 
	  {$ast= new IfNode($x.ast,$y.ast,$z.ast);}	 
	| PRINT LPAR e=exp RPAR	//
	  {$ast= new PrintNode($e.ast);} 	
 	; 

  		
/*------------------------------------------------------------------
 * LEXER RULES
 *------------------------------------------------------------------*/
SEMIC	: ';' ;
EQ	: '==' ;
PLUS	: '+' ;
TIMES	: '*' ;
INTEGER	: ('-')?(('1'..'9')('0'..'9')*) | '0';
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
