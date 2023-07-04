import scala.collection.Map$;

import java.io.*;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Q2 {
    public long findDuplicateTimesMostNumber(File input) throws Exception{
        String fileDir = input.getParentFile().getAbsolutePath();

        // divide and conquer
        String[] oneToFour =  new String[4];
        for (int i = 1; i <= 4; i++) {
            oneToFour[i-1] = fileDir + "file1.txt";
        }

        File[] segments = new File[4];
        for (int i = 0; i < segments.length; i++) {
            segments[i] = new File(oneToFour[i]);
        }

        FileOutputStream[] segmentFosArr = new FileOutputStream[4];
        for (int i = 0; i < segmentFosArr.length; i++) {
            segmentFosArr[i] = new FileOutputStream(segments[i]);
        }

        long segmentFileSize = input.length() / 4;
        FileInputStream ins = new FileInputStream(input);
        long count = 0;
        int b = -1;
        while ( (b=ins.read()) != -1 ){
            int fileIndex = ((Long)(count / segmentFileSize)).intValue();
            segmentFosArr[fileIndex].write(b);
        }


        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<Future<PriorityQueue<long[]>>> futures = new ArrayList<>();

        //use multi-thread to speed up performance.
        for (File segment : segments) {
            Future<PriorityQueue<long[]>> future = executorService.submit(new Callable<PriorityQueue<long[]>>() {
                @Override
                public PriorityQueue<long[]> call() throws Exception {
                    try {
                        PriorityQueue<long[]> priorityQueue = top4Number(segment);
                        return priorityQueue;
                    } catch (Exception e) {
                        //err handle
                    }
                    return null;
                }
            });
            futures.add(future);
        }

        List<PriorityQueue<long[]>> partialResults = new ArrayList<>();
        for (Future<PriorityQueue<long[]>> future : futures) {
            PriorityQueue<long[]> partialResult = future.get();
            partialResults.add(partialResult);
        }
        executorService.shutdownNow();

        HashMap<Long, Long> finalResult = new HashMap<>();
        for (PriorityQueue<long[]> partialResult : partialResults) {
            while (!partialResult.isEmpty()) {
                long[] poll = partialResult.poll();
                if (!finalResult.containsKey(poll[0])) {
                    finalResult.put(poll[0], poll[1]);
                }else {
                    Long oldDupTimes = finalResult.get(poll[0]);
                    finalResult.put(poll[0], oldDupTimes + poll[1]);
                }
            }
        }

        long maxDup = 0;
        long maxDupNum = 0;
        for (Map.Entry<Long, Long> entry : finalResult.entrySet()) {
            if (entry.getValue() > maxDup) {
                maxDupNum = entry.getKey();
                maxDup = entry.getValue();
            }
        }

        return maxDupNum;


    }

    public PriorityQueue<long[]> top4Number(File segmentFile) throws Exception{
        // 4-element heap
        PriorityQueue<long[]> priorityQueue = new PriorityQueue<>(new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                if (o2[1] > o1[1]) {
                    return 1;
                }else if(o2[1] < o1[1]){
                    return -1;
                }else {
                    return 0;
                }
            }
        });
        Map<Long, Long> map = new HashMap<>();
        FileInputStream ins = new FileInputStream(segmentFile);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(ins));
        String line = null;

        while ((line = bufferedReader.readLine()) != null){
            long num = Long.parseLong(line);
            long[] item = new long[2];
            item[0] = num;
            if (!map.containsKey(num)) {
                map.put(num, 1L);
                item[1] = 1;
            }else {
                Long old = map.get(num);
                map.put(num, old+1);
                item[1] = old+1;
            }
            long[] peek = priorityQueue.peek();


            /*if (item[1] > peek[1] && priorityQueue.size() < 4) {
                priorityQueue.poll();
                priorityQueue.offer(item);
            }*/

            if (priorityQueue.size() < 4) {
                priorityQueue.poll();
                priorityQueue.offer(item);
            }else {
                if (item[1] > peek[1]) {
                    priorityQueue.poll();
                    priorityQueue.offer(item);
                }
            }



        }
        return priorityQueue;
    }
}
