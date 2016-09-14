package nio;

public interface Settings {
    int K = 1024;
    int KB = K;
    int MB = K * KB;
    int count = 10;//255 * KB;

    boolean BLOCKING_SWITCH = true;

    int SERVER_PORT = 80;
    String SERVER_HOST = "www.baidu.com";
}
