package ast;

public class TimesNode implements Node {
    private Node left;
    private Node right;
  
    public TimesNode (Node l, Node r) {
        left=l;
        right=r;
    }

    public String toPrint(String s) {
        return s+"Times\n" + left.toPrint(s+"  ")  
                     + right.toPrint(s+"  ") ; 
    }
}  