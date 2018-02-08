grammar SimpleExp;

@lexer::members {
	int lexicalErrors=0;
}

// PARSER RULES

prog 	: exp {System.out.println("Parsing finished!");} ;

exp 	: term exp2 ;
exp2 	: PLUS exp | /* epsilon */ ;

term 	: value term2 ;
term2	: TIMES term | /* epsilon */ ;

value	: NUM | LPAR exp RPAR ;

// LEXER RULES

PLUS	: '+';
TIMES	: '*';
LPAR	: '(';
RPAR	: ')';
NUM		: '0' | ('1'..'9')('0'..'9')* ;
WHITESP	: (' '|'\n'|'\t'|'\r')+ -> channel(HIDDEN);
COMMENT : '/*' .*? '*/' -> channel(HIDDEN);

ERR		: . { System.out.println("Invalid char: "+ getText()); lexicalErrors++; } -> channel(HIDDEN);
	 
