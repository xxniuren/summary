package threadlocal;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/5/11
 * @description:
 **/
public class MyThread extends Thread {

    private String threadName;

    @Override
    public void run() {
        threadName = Thread.currentThread().getName();
        ThreadLocalExample.threadLocal.set(threadName);
        System.out.println("MyThread run, threadName: " + threadName);
    }
}
