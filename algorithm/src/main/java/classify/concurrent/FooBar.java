package classify.concurrent;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2021/1/20
 * @description:
 **/
class FooBar {
    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    public static void main(String[] args) throws InterruptedException {
        FooBar fooBar = new FooBar(3);
//        Thread thread1 = new Thread(fooBar.new PrintFoo());
//        Thread thread2 = new Thread(fooBar.new PrintBar());
//        thread1.start();
//        Thread.sleep(10);
//        thread2.start();
//        Thread thread = new Thread();

        MyThread thread3 = fooBar.new MyThread();
        thread3.start();

        MyThread thread4 = fooBar.new MyThread();
        thread4.start();


    }

    class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("run: " + Thread.currentThread().getName());
        }
    }

    private final Object object = new Object();

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (object) {
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                object.notifyAll();
                object.wait();
            }


        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (object) {
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printBar.run();
                object.notifyAll();
                object.wait();
            }
        }
    }

    public class PrintFoo implements Runnable {

        @Override
        public void run() {
            System.out.println("foo");
        }
    }

    public class PrintBar implements Runnable {

        @Override
        public void run() {
            System.out.println("bar");
        }
    }
}
