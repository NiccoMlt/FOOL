package lib;

import ast.*;

public class FOOLlib {
  //valuta se il tipo "a" è <= al tipo "b", dove "a" e "b" sono tipi di base: int o bool
  public static boolean isSubtype (Node a, Node b) {
	return a.getClass().equals(b.getClass()) ||
	    	   ( (a instanceof BoolTypeNode) && (b instanceof IntTypeNode) );  
  }
	
}
