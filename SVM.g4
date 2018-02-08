/**
 * Il seguente codice viene utilizzato da ANTLR per generare codice Java delle classi del parse e del lexer.
 */
grammar SVM;

@header {
    import java.util.HashMap;
}

// Campi o metodi della classe del lexer che viene generata
@lexer::members {
    int lexicalErrors=0;
}

@parser::members {
      
    int[] code = new int[ExecuteVM.CODESIZE];    
    private int i = 0;
    
    private HashMap<String,Integer> labelAdd = new HashMap<String,Integer>();
    private HashMap<Integer,String> labelRef = new HashMap<Integer,String>();
        
}

/*------------------------------------------------------------------
 * PARSER RULES
 *------------------------------------------------------------------*/
/* controlla la struttura della grammatica */

assembly:
      ( PUSH        n=NUMBER    { // push NUMBER on the stack
            code[i++] = PUSH; 
            code[i++] = Integer.parseInt($n.text);
        }
      | PUSH LABEL  l=LABEL     { // push the location address pointed by LABEL on the stack
            code[i++] = PUSH;
            labelRef.put(i++,$l.text);
        }
      | POP                     { // pop the top of the stack
            code[i++] = POP;
        }
      | ADD                     { // replace the two values on top of the stack with their sum
            code[i++] = ADD;
        }
      | SUB                     { // pop the two values v1 and v2 (respectively) and push v2-v1
            code[i++] = SUB;
        }
      | MULT                    { // replace the two values on top of the stack with their product
            code[i++] = MULT;
        }
      | DIV                     { // pop the two values v1 and v2 (respectively) and push v2/v1
            code[i++] = DIV;
        }
      | STOREW                  { // pop two values: the second one is written at the memory address pointed by the first one
            code[i++] = STOREW;
        }
      | LOADW                   { // read the content of the memory cell pointed by the top of the stack and replace the top of the stack with such value
            code[i++] = LOADW;
        }
      | l=LABEL COL             { // LABEL points at the location of the subsequent instruction
            labelAdd.put($l.text,i);
        }
      | BRANCH l=LABEL          { // jump at the instruction pointed by LABEL
            code[i++] = BRANCH;
            labelRef.put(i++,$l.text);
        }
      | BRANCHEQ l=LABEL        { // pop two values and jump if they are equal
            code[i++] = BRANCHEQ;
            labelRef.put(i++,$l.text);
        }
      | BRANCHLESSEQ l=LABEL    { //pop two values and jump if the second one is less or equal to the first one
            code[i++] = BRANCHLESSEQ;
            labelRef.put(i++,$l.text);
        }
      | JS                      { // pop one value from the stack: copy the instruction pointer in the RA register and jump to the popped value
            code[i++] = JS;
        }
      | LOADRA                  { // push in the stack the content of the RA register
            code[i++] = LOADRA;
        }
      | STORERA                 { // pop the top of the stack and copy it in the RA register
            code[i++] = STORERA;
        }
      | LOADRV                  { // push in the stack the content of the RV register
            code[i++] = LOADRV;
        }
      | STORERV                 { // pop the top of the stack and copy it in the RV register
            code[i++] = STORERV;
        }
      | LOADFP                  { // push in the stack the content of the FP register
            code[i++] = LOADFP;
        }
      | STOREFP                 { // pop the top of the stack and copy it in the FP register
            code[i++] = STOREFP;
        }
      | COPYFP                  { // copy in the FP register the current stack pointer
            code[i++] = COPYFP;
        }
      | LOADHP                  { // push in the stack the content of the HP register
            code[i++] = LOADHP;
        }
      | STOREHP                 { // pop the top of the stack and copy it in the HP register
            code[i++] = STOREHP;
        }
      | PRINT                   { // visualize the top of the stack without removing it
            code[i++] = PRINT;
        }
      | HALT                    { // terminate the execution
            code[i++] = HALT;
        }
      )*{
            for (Integer refAdd: labelRef.keySet()) {
                code[refAdd]=labelAdd.get(labelRef.get(refAdd));
		    } 
        };
     
/*------------------------------------------------------------------
 * LEXER RULES
 *------------------------------------------------------------------*/
 /* controlla la struttura dei token */

PUSH        : 'push' ;
POP         : 'pop' ;
ADD         : 'add' ;
SUB         : 'sub' ;
MULT        : 'mult' ;
DIV         : 'div' ;
STOREW      : 'sw' ;
LOADW       : 'lw' ;
BRANCH      : 'b' ;
BRANCHEQ    : 'beq' ;
BRANCHLESSEQ:'bleq' ;
JS          : 'js' ;
LOADRA      : 'lra' ;
STORERA     : 'sra' ;
LOADRV      : 'lrv' ;
STORERV     : 'srv' ;
LOADFP      : 'lfp' ;
STOREFP     : 'sfp' ;
COPYFP      : 'cfp' ;
LOADHP      : 'lhp' ;
STOREHP     : 'shp' ;
PRINT       : 'print' ;
HALT        : 'halt' ;
 
COL      : ':' ;
LABEL    : ('a'..'z'|'A'..'Z')('a'..'z' | 'A'..'Z' | '0'..'9')* ;
NUMBER   : '0' | ('-')?(('1'..'9')('0'..'9')*) ;

WHITESP  : (' '|'\t'|'\n'|'\r')+ -> channel(HIDDEN) ;

ERR      : . { System.out.println("Invalid char: "+ getText()); lexicalErrors++; } -> channel(HIDDEN); 
