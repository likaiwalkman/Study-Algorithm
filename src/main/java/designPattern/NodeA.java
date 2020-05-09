public class NodeA implements Node {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void print(){
        System.out.println("I'm NodeA");
    }
}
