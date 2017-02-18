package asyn.jetty.client;

import concurrent.threadPool.copy.Executors;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.client.api.Response;
import org.eclipse.jetty.client.api.Result;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class AppTest {
    public static void main(String[] args) throws Exception {
        String PATH = "/Users/victor/git/out.txt";
        //System.setOut(new PrintStream(new FileOutputStream(PATH)));

        HttpClient client = new HttpClient();
        client.setConnectBlocking(false);
        client.setConnectTimeout(1000);
        client.setStopTimeout(1000);
        client.setMaxConnectionsPerDestination(1000);
        client.setMaxRequestsQueuedPerDestination(10000);
        client.setRequestBufferSize(2*1024);
        client.setExecutor(Executors.newFixedThreadPool(50));
        client.start();

        for (int i = 1; i <= 10000; i++) {

            System.err.println(i+" enqueue");
//        }
            client.newRequest("http://www.baidu.com/img/baidu_jgylogo3.gif")
                    .onRequestFailure(new Request.FailureListener() {
                        public void onFailure(Request request, Throwable failure) {
                            System.out.println("qf "+System.currentTimeMillis());
                        }
                    })
                    .onRequestSuccess(new Request.SuccessListener() {
                        public void onSuccess(Request request) {
                            System.out.println("qs "+System.currentTimeMillis());
                        }
                    })
                    .onResponseFailure(new Response.FailureListener() {
                        public void onFailure(Response response, Throwable failure) {
                            System.out.println("sf "+System.currentTimeMillis());
                        }
                    })
                    .onResponseSuccess(new Response.SuccessListener() {
                        public void onSuccess(Response response) {
                            System.out.println("ss "+System.currentTimeMillis());
                        }
                    })
                    .send(new Response.CompleteListener() {
                        public void onComplete(Result result) {
                            System.out.println("cp "+System.currentTimeMillis());
                        }
                    });
        }
    }
}
