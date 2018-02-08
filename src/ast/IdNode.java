package ast;

public class IdNode implements Node {
    private String id;
    private STentry entry;
  
    public IdNode (String i, STentry st) {
        id=i;
        entry=st;
    }
  
    public String toPrint(String s) {
        return s+"Id:" + id +"\n"+
            entry.toPrint(s+"  ");
    }
}  