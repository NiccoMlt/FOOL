package ast;

public class PlusNode implements Node {

	public Node left;
	public Node right;
	
	public PlusNode (Node l, Node r) {
		left=l;
		right=r;
	}
	
	public String toPrint(String indent) {
		  return indent+"Plus\n"+
				  left.toPrint(indent+"  ")+
				  right.toPrint(indent+"  ");
	}
	
}
