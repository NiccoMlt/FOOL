package ast;

public class VarNode implements Node {
    private String id;
    private Node type;
    private Node exp;

    public VarNode (String i, Node t, Node v) {
        id=i;
        type=t;
        exp=v;
    }

    public String toPrint(String s) {
        return s+"Var:" + id +"\n"
			   +type.toPrint(s+"  ")  
               +exp.toPrint(s+"  ") ; 
    }

    //public Node typeCheck() {return null;}
}  