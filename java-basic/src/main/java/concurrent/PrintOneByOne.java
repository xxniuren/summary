package concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2021/1/23
 * @description:
 **/
public class PrintOneByOne {

    public static boolean flag = true;
    public static Lock lock = new ReentrantLock();
    ThreadLocal threadLocal = new ThreadLocal();

    public static void main(String[] args) throws InterruptedException {
        Thread helloThread = new PrintHello();
        Thread worldThread = new PrintWorld();
        helloThread.start();
        Thread.sleep(1000);
        worldThread.start();
    }

    static class PrintHello extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; ) {
                try {
                    lock.lock();
                    while (flag) {
                        System.out.println("Hello");
                        flag = !flag;
                        i++;
                    }
                } finally {
                    lock.unlock();
                }

            }
        }
    }

    static class PrintWorld extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; ) {
                try {
                    lock.lock();
                    while (!flag) {
                        System.out.println("World");
                        i++;
                        flag = !flag;
                    }
                } finally {
                    lock.unlock();
                }

            }
        }
    }

}
