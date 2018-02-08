package ast;

public class TimesNode implements Node {

	public Node left;
	public Node right;
	
	public TimesNode (Node l, Node r) {
		left=l;
		right=r;
	}
	
	public String toPrint(String indent) {
		  return indent+"Times\n"+
				  left.toPrint(indent+"  ")+
				  right.toPrint(indent+"  ");
	}
}
