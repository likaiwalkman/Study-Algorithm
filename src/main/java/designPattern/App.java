package designPattern;

public class App {

    public static void main(String[] args) {
        Visitor visitor = new VisitorPrinter();
        Node nodeA = new NodeA();
        nodeA.accept(visitor);
    }
}
