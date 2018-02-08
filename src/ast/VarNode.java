package ast;
//import java.util.ArrayList;

public class VarNode implements Node {
    private String id;
    private Node type;
    private Node exp;
  
    public VarNode (String i, Node t, Node e) {
        id=i;
        type=t;
        exp=e;
    }

    public String toPrint(String s) {
        return s+"Var:"+id+ "\n" + 
            type.toPrint(s+"  ") +
            exp.toPrint(s+"  ") ;
    }
}  