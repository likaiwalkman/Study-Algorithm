package redisson;

import org.redisson.Redisson;
import org.redisson.api.RKeys;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class Demo {
    public static void main(String[] args) {

        //ConnectionWatchdog

        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://127.0.0.1:6379")
                .setDatabase(0);

        RedissonClient client = Redisson.create(config);

        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replace("-", "");
        System.out.println(uuid);
        uuid = "test_lock";
        RLock rLock = client.getLock(uuid);
        try {
            boolean b = rLock.tryLock(50, 8000, TimeUnit.MICROSECONDS);
            System.out.println(b);
            b = rLock.tryLock(50, 8000, TimeUnit.MICROSECONDS);
            System.out.println(b);
            RKeys keys = client.getKeys();
            long count = keys.count();
            System.out.println("keys count: "+ count);
            Iterator<String> iterator = keys.getKeys().iterator();
            int index = 0;
            while (iterator.hasNext()) {
                String next = iterator.next();
                System.out.println(index+": "+next);
                index++;
            }
            Thread.sleep(2000);
            rLock.unlock();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
