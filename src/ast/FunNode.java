package ast;
import java.util.ArrayList;

public class FunNode implements Node {
    private String id;
    private Node type;
    // campo parlist per i parametri che è una lista di Node (inizializzata ad una lista vuota)
    private ArrayList<Node> declist=new ArrayList<Node>();
    private Node exp;
  
    public FunNode (String i, Node t) {
        id=i;
        type=t;
    }
  
    // metodo addPar che aggiunge un ParNode al campo parlist
  
    public void addDec (ArrayList<Node> d) {
        declist=d;
    }

    public void addBody (Node e) {
        exp=e;
    }

    public String toPrint(String s) {
        String declstr="";
        for (Node dec:declist) {
            declstr+=dec.toPrint(s+"  ");
        }
        return s+"Fun:"+id+ "\n" +
            type.toPrint(s+"  ") +
            // stringa lista parametri
            declstr +
            exp.toPrint(s+"  ") ;
    }
}  