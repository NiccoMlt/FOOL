package ast;

public class PlusNode implements Node {
    private Node left;
    private Node right;
  
    public PlusNode(Node l, Node r) {
        left=l;
        right=r;
    }
  
    public String toPrint(String s) {
        return s+"Plus\n" + left.toPrint(s+"  ")  
                     + right.toPrint(s+"  ") ; 
    }
}  