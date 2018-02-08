package ast;

import lib.FOOLlib;

public class EqualNode implements Node {

  private Node left;
  private Node right;
  
  public EqualNode (Node l, Node r) {
   left=l;
   right=r;
  }
  
  public String toPrint(String s) {
   return s+"Equal\n" + left.toPrint(s+"  ")   
                      + right.toPrint(s+"  ") ; 
  }
    
  public Node typeCheck() {
	Node l= left.typeCheck();  
	Node r= right.typeCheck();  
    if ( !(FOOLlib.isSubtype(l, r) || FOOLlib.isSubtype(r, l)) ) {
      System.out.println("Incompatible types in equal");
	  System.exit(0);	
    }  
    return new BoolTypeNode();
  }
  
  //public String codeGeneration() {return "";}
  
}  