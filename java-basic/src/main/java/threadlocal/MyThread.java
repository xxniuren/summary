package threadlocal;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/5/11
 * @description:
 **/
public class MyThread extends Thread {

    private String threadName;
    public static ThreadLocal<String> threadLocal;
    public MyThread (ThreadLocal<String> threadLocalBuf) {
        threadLocal = threadLocalBuf;
    }

    @Override
    public void run() {
        threadName = Thread.currentThread().getName();
        threadLocal.set(threadName);
        System.out.println("MyThread run, threadName: " + threadName);
    }
}
