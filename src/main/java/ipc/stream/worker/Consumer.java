package ipc.stream.worker;

import java.io.OutputStream;

public class Consumer implements Runnable {

    private OutputStream outputStream;

    public Consumer(OutputStream outputStream){
        this.outputStream = outputStream;
    }

    @Override
    public void run() {

    }
}
