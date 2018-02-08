grammar FOOL;

@header {
import java.util.ArrayList;
import java.util.HashMap;	
import ast.*;
}

@parser::members {
private int nestingLevel = 0;
private ArrayList<HashMap<String,STentry>> symTable = new ArrayList<HashMap<String,STentry>>();
//livello ambiente con dichiarazioni piu' esterno è 0 (invece che 1 nelle slides)
//il "fronte" della lista di tabelle è "symTable.get(nestingLevel)"
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
    | LET {HashMap<String,STentry> hm= new HashMap<String,STentry>();
    	   symTable.add(hm);
          }
          d=declist IN e=exp SEMIC  
          {$ast = new ProgLetInNode($d.astlist,$e.ast);
           symTable.remove(nestingLevel);
          }
	;
 	 	 
declist returns [ArrayList<Node> astlist] 
    : {$astlist= new ArrayList<Node>();}
      (
            (   VAR i=ID COLON t=type ASS e=exp 
                {VarNode v = new VarNode($i.text,$t.ast,$e.ast);
                 $astlist.add(v);	
                 HashMap<String,STentry> hm=symTable.get(nestingLevel);
                 if (hm.put($i.text, new STentry(nestingLevel)) != null) 
                   {System.out.println("Var id "+$i.text+" at line "+$i.line+" already declared"); 
                   	System.exit(0);
                   } 
                }
              | FUN i=ID COLON t=type 
                {FunNode f = new FunNode($i.text,$t.ast);
                 $astlist.add(f);	
                 HashMap<String,STentry> hm=symTable.get(nestingLevel);
                 if (hm.put($i.text, new STentry(nestingLevel)) != null) 
                   {System.out.println("Fun id "+$i.text+" at line "+$i.line+" already declared"); 
                   	System.exit(0);
                   }                  
                 // entro dentro un nuovo scope
                 nestingLevel++;
                 HashMap<String,STentry> hmn= new HashMap<String,STentry>();
    	         symTable.add(hmn);
                 }                
                LPAR 
                (ID COLON type 
                 {//creare il ParNode
                  //lo attacco al FunNode invocando addPar 
                  //aggiungo una STentry alla hashmap hmn
                 }
                  (COMMA ID COLON type
                 {//creare il ParNode
                  //lo attacco al FunNode invocando addPar 
                  //aggiungo una STentry alla hashmap hmn
                 }
                  )*      
                )?
                RPAR 
                (LET d=declist IN {f.addDec($d.astlist);})? e=exp 
                {f.addBody($e.ast);
                 symTable.remove(nestingLevel--);                	
                } 
            ) SEMIC 
          )+
        ; 	 	 

type returns [Node ast]
     : INT             {$ast = new IntTypeNode();}       		      
     | BOOL  		   {$ast = new BoolTypeNode();}        	
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
	| i=ID  
	  { //cerco la dichiarazione dentro la symbol table
	  	int j=nestingLevel;
	  	STentry entry=null;
	    while (j>=0 && entry==null)
	      entry=symTable.get(j--).get($i.text);	    
        if (entry==null)
          { System.out.println("Id "+$i.text+" at line "+$i.line+" not declared"); 
            System.exit(0); }
	  	$ast = new IdNode($i.text,entry);
	  }
 	; 

  		
/*------------------------------------------------------------------
 * LEXER RULES
 *------------------------------------------------------------------*/
 
COLON : ':' ;
COMMA : ',' ;
EQ  : '==' ;
ASS : '=' ;
SEMIC	: ';' ;
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
LET : 'let' ;
IN  : 'in' ;
VAR : 'var' ;
FUN : 'fun' ;
INT : 'int' ;
BOOL  : 'bool' ;
 
ID  : ('a'..'z'|'A'..'Z') ('a'..'z'|'A'..'Z'|'0'..'9')* ;

WHITESP : (' '|'\t'|'\n'|'\r')+ -> channel(HIDDEN) ;
COMMENT : '/*' (.)*? '*/' -> channel(HIDDEN) ;

ERR	    : . { System.out.println("Invalid char: "+ getText()); lexicalErrors++; } -> channel(HIDDEN); 
