package ast;
import java.util.ArrayList;

import lib.FOOLlib;

public class CallNode implements Node {

  private String id;
  private STentry entry;
  private ArrayList<Node> parlist = new ArrayList<Node>(); 
  
  public CallNode (String i, STentry st, ArrayList<Node> p) {
   id=i;
   entry=st;
   parlist=p;
  }
  
  
  public String toPrint(String s) {
		 String parlstr="";
		 for (Node par:parlist){parlstr+=par.toPrint(s+"  ");};
	     return s+"Call:" + id +"\n" +
			   entry.toPrint(s+"  ") +  
			   parlstr;
  }
  
  public Node typeCheck() {	 
		 ArrowTypeNode t=null;
	     if (entry.getType() instanceof ArrowTypeNode) t=(ArrowTypeNode) entry.getType(); 
	     else {
	       System.out.println("Invocation of a non-function "+id);
	       System.exit(0);
	     }
	     ArrayList<Node> p = t.getParList();
	     if ( !(p.size() == parlist.size()) ) {
	       System.out.println("Wrong number of parameters in the invocation of "+id);
	       System.exit(0);
	     } 
	     for (int i=0; i<parlist.size(); i++) 
	       if ( !(FOOLlib.isSubtype( (parlist.get(i)).typeCheck(), p.get(i)) ) ) {
	         System.out.println("Wrong type for "+(i+1)+"-th parameter in the invocation of "+id);
	         System.exit(0);
	       } 
	     return t.getRet();
  }
  
  //public String codeGeneration() {return "";}
    
}  