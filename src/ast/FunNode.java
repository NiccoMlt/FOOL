package ast;
import java.util.ArrayList;

public class FunNode implements Node {
    private String id;
    private Node type; 
    private ArrayList<Node> parlist = new ArrayList<Node>(); // campo "parlist" che è lista di Node
    private ArrayList<Node> declist = new ArrayList<Node>(); 
    private Node exp;

    public FunNode (String i, Node t) {
        id=i;
        type=t;
    }

    public void addDec (ArrayList<Node> d) {
        declist=d;
    }

    public void addBody (Node b) {
        exp=b;
    }  

    public void addPar (Node p) { //metodo "addPar" che aggiunge un nodo a campo "parlist"
        parlist.add(p);  
    }

    public String toPrint(String s) {
		String parlstr="";
		for (Node par:parlist){
            parlstr+=par.toPrint(s+"  ");
        }
		String declstr="";
		for (Node dec:declist){
            declstr+=dec.toPrint(s+"  ");
        }
	    return s+"Fun:" + id +"\n"
			   +type.toPrint(s+"  ")
			   +parlstr
			   +declstr
               +exp.toPrint(s+"  ") ; 
    }

    //public Node typeCheck() {return null;}
}  