package ast;
import java.util.ArrayList;

public class ProgLetInNode implements Node {
    private ArrayList<Node> declist;
    private Node exp;

    public ProgLetInNode (ArrayList<Node> d, Node e) {
        declist=d;
        exp=e;
    }

    public String toPrint(String s) {
        String declstr="";
        for (Node dec:declist){
            declstr+=dec.toPrint(s+"  ");
        }
        return s+"ProgLetIn\n" + declstr + exp.toPrint(s+"  ") ; 
    }

    //public Node typeCheck() {return null;}
}  