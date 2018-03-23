package lib;

import java.util.ArrayList;

import ast.*;

public class FOOLlib {
    
  private static int labCount=0; 

  private static int funLabCount=0; 
  
  private static String funCode="";
  
  //valuta se il tipo "a" è <= al tipo "b", dove "a" e "b" sono tipi di base: int o bool
  public static boolean isSubtype (Node a, Node b) {
      if (a instanceof ArrowTypeNode && b instanceof ArrowTypeNode) {
          final Node retA = ((ArrowTypeNode) a).getRet();
          final Node retB = ((ArrowTypeNode) b).getRet();
          final ArrayList<Node> parA = ((ArrowTypeNode) a).getParList();
          final ArrayList<Node> parB = ((ArrowTypeNode) b).getParList();
          
          // Controllo il numero di parametri e la covarianza dei tipi di ritorno
          boolean isSubtype = parA.size() == parB.size() && isSubtype(retA, retB);
          
          if(isSubtype) {
              for(int i = 0; i < parA.size(); i++) {
                  // Controllo la controvarianza dei tipi di parametri
                  isSubtype = isSubtype && isSubtype(parB.get(i), parA.get(i));
              }
          }
          
          return isSubtype;
      } else {
          return a.getClass().equals(b.getClass()) || ((a instanceof BoolTypeNode) && (b instanceof IntTypeNode));  
      }
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
