package threadlocal;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/5/11
 * @description:
 **/
public class ThreadLocalExample {
    public static ThreadLocal<String> threadLocal = new ThreadLocal<String>();

    public static void main(String[] args) {
        ThreadLocalExample example = new ThreadLocalExample();
        example.run();
    }

    public void run () {
        for (int i = 0; i < 3; i++) {
            MyThread myThread = new MyThread(threadLocal);
            myThread.start();
            String threadName = Thread.currentThread().getName();
            String threadNameIn = threadLocal.get();
            if (threadName.equals(threadNameIn)) {
                System.out.println("success to get threadName in threadLocal " + threadName);
            }
        }
    }
}
