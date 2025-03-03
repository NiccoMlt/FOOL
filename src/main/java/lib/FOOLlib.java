package lib;

import ast.BoolTypeNode;
import ast.IntTypeNode;
import ast.Node;

public class FOOLlib {
    
  private static int labCount=0; 

  private static int funLabCount=0; 
  
  private static String funCode="";
  
  //valuta se il tipo "a" è <= al tipo "b", dove "a" e "b" sono tipi di base: int o bool
  public static boolean isSubtype (Node a, Node b) {
	return a.getClass().equals(b.getClass()) ||
	    	   ( (a instanceof BoolTypeNode) && (b instanceof IntTypeNode) );  
  }
  
  public static String freshLabel() {
	  return "label"+(labCount++);
  }

  public static String freshFunLabel() {
	  return "function"+(funLabCount++);
  }

  public static void putCode(String c) {
	  funCode+="\n"+c; //aggiunge una linea vuota di separazione prima della funzione
  }
  
  public static String getCode() {
	  return funCode; 
  }

}
