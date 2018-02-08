package ast;
import java.util.ArrayList;

public class CallNode implements Node {
    private String id;
    private STentry entry;
    private ArrayList<Node> parlist = new ArrayList<Node>(); 

    public CallNode (String i, STentry st, ArrayList<Node> p) {
        id=i;
        entry=st;
        parlist=p;
    }

    public String toPrint(String s) {
        String parlstr="";
        for (Node par:parlist){
            parlstr+=par.toPrint(s+"  ");
        }
        return s+"Call:" + id +"\n" +
			   entry.toPrint(s+"  ") +  
			   parlstr;
    }

    public Node typeCheck() {
        return null;
    }
    
    //ESERC: regola (con subtyping) vista a lezione 
    // recupero tipo (deve essere ArrowTypeNode) da STentry
    // errori possibili (che indicano, in ordine, i controlli da fare):
    //     "Invocation of a non-function "+id
    //     "Wrong number of parameters in the invocation of "+id
    //     "Wrong type for "+i+"-th parameter in the invocation of "+id
    // leggere tipo parametri e tipo di ritorno da un ArrowTypeNode tramite 
    //     i suoi metodi getRet() e getParList() (crearli)
    // dopo i check ritorno il tipo di ritorno 
    
}  