package jvm.app;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InspectGC {
    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            public void run() {
                try {
                    new ServerSocket(9999).accept();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        List<List<String>> outerList = new LinkedList<List<String>>();
        while (true) {
            Thread.sleep(1);
            outerList.add(new ArrayList<String>(1000));
        }
    }
}
