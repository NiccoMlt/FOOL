package ast;

public class MultNode implements Node {
    private Node left;
    private Node right;

    public MultNode (Node l, Node r) {
        left=l;
        right=r;
    }

    public String toPrint(String s) {
        return s+"Mult\n" + left.toPrint(s+"  ")  
                     + right.toPrint(s+"  ") ; 
    }

    //public Node typeCheck() {return null;}
}  