package ast;

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
}  