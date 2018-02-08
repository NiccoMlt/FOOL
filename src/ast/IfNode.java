package ast;

public class IfNode implements Node {
    private Node cond;
    private Node th;
    private Node el;

    public IfNode (Node c, Node t, Node e) {
        cond=c;
        th=t;
        el=e;
    }

    public String toPrint(String s) {
        return s+"If\n" + cond.toPrint(s+"  ") 
                 + th.toPrint(s+"  ")   
                 + el.toPrint(s+"  ") ; 
    }

    //public Node typeCheck() {return null;}
}  