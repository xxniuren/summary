package threadlocal;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2021/1/23
 * @description:
 **/
public class ThreadLocalTest {

    private static final ThreadLocal<Integer> threadLocals = new ThreadLocal<Integer>() {
        @Override
        public Integer initialValue() {
            return 0;
        }
    };

    public static void main(String[] args) {
        final Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Runnable() {
                public void run() {
                    for (int j = 0; j < 10; j++) {
                        // threadLocals.get 是获取当前线程的 threadLocalMap中的
                        threadLocals.set(threadLocals.get() + 1);
                    }
                    System.out.println("Thread: " + Thread.currentThread().getName() + ", val: " + threadLocals.get());
                }
            });
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
    }
}
