import java.util.LinkedList;
import java.util.List;

/**
 * looped list: IT'S JUST FOR TEST USE, NOT TO USE IN　PROD ENV,
 *   IT WILL RESULT IN DEAD LOOP!
 * Created by likai on 2017/1/24.
 */
public class LoopedList<E> {

    public static void main(String[] args) {
        LoopedList nullLoopedList = new LoopedList(null);
        LoopedList emptyLoopedList = new LoopedList(new LinkedList());
        LinkedList ones = new LinkedList();
        ones.add("1");
        LoopedList oneLoopedList = new LoopedList(ones);
        LinkedList twos = new LinkedList();
        twos.add("1");
        twos.add("2");
        LoopedList twoLoopedList = new LoopedList(twos);
        LinkedList tri = new LinkedList();
        tri.add("1");
        tri.add("2");
        tri.add("3");
        LoopedList threeLoopedList = new LoopedList(tri);

        //Could be replace with above LoopedList to test border condition
        LoopedList target = threeLoopedList;
        while (target.hasNext()) {
            target.next();
            System.out.println(target.get());
        }
    }
    private Node<E> head = new Node<E>();
    private Node<E> tail = new Node<E>();
    private Node<E> pos = head;
    {
        head.next = tail;
        tail.next = head;
    }
    public LoopedList(List<E> list){
        if (list == null || list.size() == 0) return;
        for (E e : list) {
            Node<E> newNode = new Node<E>();
            newNode.val = e;
            newNode.next = pos.next;
            pos.next = newNode;
        }
        pos = head;
    }
    public boolean hasNext(){
        return !( head.next == tail);
    }
    public E get(){
        return pos.val;
    }
    public void next(){
        if (!hasNext()){
            return;
        } else {
            pos = pos.next;
            if (pos == head || pos == tail){
                next();
            }
        }
    }
}

class Node<E> {
    Node next;
    public E val;
}
