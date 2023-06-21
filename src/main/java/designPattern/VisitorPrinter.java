package designPattern;

import designPattern.NodeA;
import designPattern.NodeB;
import designPattern.Visitor;

public class VisitorPrinter implements Visitor {

    @Override
    public void visit(NodeA node) {
        node.print();
    }

    @Override
    public void visit(NodeB node) {
        node.print();
    }
}
