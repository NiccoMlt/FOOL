package ast;

public class PrintNode implements Node {
    private Node exp;
  
    public PrintNode (Node v) {
        exp=v;
    }

    public String toPrint(String s) {
        return s+"Print\n" + exp.toPrint(s+"  ") ;
    }  
}  