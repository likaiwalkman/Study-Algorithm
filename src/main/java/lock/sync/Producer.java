package lock.sync;

import org.openjdk.jol.info.ClassLayout;

import java.util.ArrayList;
import java.util.List;

public class Producer extends Thread{
    public Producer(List<Integer> list) {
        this.list = list;
        super.setName("producer");
    }

    private List<Integer> list = new ArrayList();
    @Override
    public void run() {
        try {
            while (true){
                synchronized (list){
                    if (list.size() > 100) {
                        list.wait();
                        //continue;
                    }
                    if (list.size() == 0) {
                        list.add(1);
                    }else{
                        int last = list.get(list.size()-1);
                        int newOne = last+1;
                        System.out.println(Thread.currentThread()+" produce: "+newOne);
                        System.out.println(ClassLayout.parseInstance(list).toPrintable());
                        list.add(newOne);
                    }
                    list.notify();
                }
            }
        }catch (Exception e){

        }

    }
}
