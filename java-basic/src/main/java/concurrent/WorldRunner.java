package concurrent;

import java.util.concurrent.locks.Lock;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2021/1/23
 * @description:
 **/
public class WorldRunner implements Runnable {

    public Lock lock;
    public static volatile boolean flag;

    public WorldRunner (Lock lock, boolean flag) {
        this.lock = lock;
        this.flag = flag;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                lock.lock();
                while (!flag) {
                    System.out.println("World");
                    flag = !flag;
                }
            } finally {
                lock.unlock();
            }

        }
    }
}
