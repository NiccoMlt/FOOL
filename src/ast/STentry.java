package ast;
public class STentry {

    //type
    private int nl;

    public STentry (int n) {
        nl=n;
    }

    public String toPrint(String s) {
	   return s+"STentry: nestlev " + Integer.toString(nl) +"\n";  
    }
}  