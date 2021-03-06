package asyn.jetty.client;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynReqTest {
    static String PATH = "http://localhost:8080";

    public static void main(String[] args) throws IOException, InterruptedException {
        int             times    = 1000;

        long now = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            new Req(null).run();
        }
        System.out.println(System.currentTimeMillis() - now);

        //System.exit(0);
        ExecutorService executor = Executors.newFixedThreadPool(10);
        long            time     = System.currentTimeMillis();
        CountDownLatch  latch    = new CountDownLatch(times);
        System.out.println(new Date());
        for (int i = 0; i < times; i++) {
            executor.execute(new Req(latch));
        }
        latch.await();
        executor.shutdown();
        System.out.println(times + "times cost mills " + (System.currentTimeMillis() - time));
    }

    static class Req implements Runnable {
        private CountDownLatch latch;

        public Req(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                HttpClient client = new DefaultHttpClient();
                client.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 5000);
                HttpResponse response   = client.execute(new HttpGet(PATH));
                int          statusCode = response.getStatusLine().getStatusCode();
                System.out.println(""+statusCode +" " + new Date());
            } catch (Exception e) {
                System.out.println("ERR " + e);
            } finally {
                if (latch != null) {
                    latch.countDown();
                }
            }
        }
    }
}
