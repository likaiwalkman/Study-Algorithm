package pcotj.divideAndConquer.test;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.time.StopWatch;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

public class InspectBestSuitableThreadSize {
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        List<Callable<String>> requests = new ArrayList<Callable<String>>();
        for (int i = 0; i < (8 * 8 * 2); i++) {
            requests.add(callBaidu());
        }
        ExecutorService executorService = Executors.newFixedThreadPool(2*8);
        CompletionService<String> completionService = new ExecutorCompletionService<String>(executorService);
        StopWatch watch = new StopWatch();
        watch.start();
        for (Callable<String> request : requests) {
            completionService.submit(request);
        }
        executorService.shutdown();
        int size = requests.size();
        List<String> results = new LinkedList<String>();
        for (int i = 0; i < size; i++) {
            results.add(completionService.take().get());
        }
        watch.stop();
        System.out.println(watch.getTime());
        System.out.println(results);
    }
    static Callable<String> callBaidu() throws IOException {

        return new Callable<String>(){
            @Override
            public String call() throws Exception {
                try{
                    HttpClient client = new DefaultHttpClient();
                    HttpResponse httpResponse = client.execute(new HttpGet("http://cn.bing.com/search?q=jackie"));
                    return IOUtils.toString(httpResponse.getEntity().getContent());
                }catch (Exception e){
                    return null;
                }
            }
        };
    }
}
