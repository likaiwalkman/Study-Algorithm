package leetcode.p232;

public class Test {
    @org.junit.Test
    public void test1(){
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);

        int peek = myQueue.peek();
        int pop = myQueue.pop();
        System.out.println();
    }

    @org.junit.Test
    public void test2(){
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);
        int pop1 = myQueue.pop();
        myQueue.push(5);
        int pop2 = myQueue.pop();
        int pop3 = myQueue.pop();
        int pop4 = myQueue.pop();
        int pop5 = myQueue.pop();
        System.out.println();
    }
}

