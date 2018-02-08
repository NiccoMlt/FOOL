package ast;

public class IntNode implements Node {

	public int integer;
	
	public IntNode (int i) {
		integer=i;
	}
	
	public String toPrint(String indent) {
		  return indent+"Int:"+integer+"\n";
	}
	
}
