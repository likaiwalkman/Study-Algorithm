package download;

import concurrent.threadPool.copy.Executors;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws Exception {
        int fileNo = 0;

        int threadSum = 10;
        //String middlePath = "1000kb/hls";
        //String middlePath = "500kb/hls";
        String middlePath = "hls";
        String endpoint = "https://cdn82.com:10082";
        String diskBasePath = "/Users/victor/Movies/ts/";

        String indexUrl = endpoint+"/"+fileNo+"/"+middlePath+"/index.m3u8";
        String dir = diskBasePath+fileNo;
        File dirFile = new File(dir);

        if (!dirFile.exists()) {
            dirFile.mkdir();
        }
        File filesDir = new File(dir + "/files");
        if (!filesDir.exists()) {
            filesDir.mkdir();
        }
        String indexFile = dir+"/index.m3u8";

        Process p = Runtime.getRuntime().exec(String.format("wget %s -O %s", indexUrl, indexFile));
        int errorCodeOuter = p.waitFor();
        long indexFileLength = new File(indexFile).length();
        System.out.println(indexFile+" length: "+indexFileLength+" errorCode: "+errorCodeOuter);

        List<String> rawLines = IOUtils.readLines(new FileInputStream(indexFile));
        List<String> tsFileNames = rawLines.stream().filter(line->!line.startsWith("#")).collect(Collectors.toList());

        System.out.println("ts file count: "+tsFileNames.size());

        ExecutorService executorService = Executors.newFixedThreadPool(threadSum);
        AtomicInteger counter = new AtomicInteger();
        List<Callable<Void>> tasks = tsFileNames.stream().map(fileName -> (Callable<Void>) () -> {
            String url = String.format(endpoint+"/"+fileNo+"/"+middlePath+"/%s", fileName);

            String destFileName = String.format(diskBasePath+fileNo+"/files/%s", fileName);

            Process process = Runtime.getRuntime().exec(String.format("wget %s -O %s", url, destFileName));
            int errorCode = process.waitFor();

            InputStream inputStream = process.getInputStream();
            String output = IOUtils.toString(inputStream);
            long length = new File(destFileName).length();
            int counterVal = counter.incrementAndGet();
            String line = fileName+" length: "+length+" errorCode: "+errorCode+ "output: "+ output +" fileDownloadedCount: "+counterVal;
            System.out.println(line);
            return null;
        }).collect(Collectors.toList());
        List<Future<Void>> futures = executorService.invokeAll(tasks);
        for (Future<Void> future : futures) {
            future.get();
        }
        executorService.shutdown();

        merge(fileNo, diskBasePath);
        File[] filesDirFiles = filesDir.listFiles();
        for (File fileDirFile : filesDirFiles) {
            fileDirFile.delete();
        }
        filesDir.delete();
    }

    private static void merge(int fileNo, String diskBasePath) throws IOException {

        String dir = diskBasePath+fileNo;
        String indexFile = dir+"/index.m3u8";
        List<String> rawLines = IOUtils.readLines(new FileInputStream(indexFile));
        List<String> tsFileNames = rawLines.stream().filter(line->!line.startsWith("#")).collect(Collectors.toList());


        FileOutputStream outputStream = new FileOutputStream(diskBasePath + fileNo +"/index.ts");
        for (String fileName : tsFileNames) {
            IOUtils.copy(new FileInputStream(diskBasePath + fileNo +"/files/"+fileName), outputStream);
        }
    }
}
