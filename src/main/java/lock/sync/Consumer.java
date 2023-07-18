package lock.sync;

import org.openjdk.jol.info.ClassLayout;

import java.util.ArrayList;
import java.util.List;

public class Consumer extends Thread{
    public Consumer(List<Integer> list) {
        this.list = list;
        super.setName("consumer");
    }

    private List<Integer> list = new ArrayList();
    @Override
    public void run() {
        try {
            while (true){
                synchronized (list){
                    if (list.size() == 0) {
                        list.wait();
                        continue;
                    }
                    int last = list.get(list.size()-1);
                    System.out.println(Thread.currentThread()+" take: "+last);
                    System.out.println(ClassLayout.parseInstance(list).toPrintable());
                    list.remove(list.size()-1);
                    list.notify();
                }
            }
        }catch (Exception e){

        }

    }
}
