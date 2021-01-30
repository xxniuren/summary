package threadlocal;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2021/1/27
 * @description:
 **/
public class BetweenPrint {

    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        Thread thread1 = new Thread(new PrintClass("A", object));
        Thread thread2 = new Thread(new PrintClass("B", object));
        thread1.start();
        Thread.sleep(1000);
        thread2.start();
    }
//    public static void main(String[] args) throws InterruptedException {
//        final Object object = new Object();
//        Thread thread1 = new Thread(new Runnable() {
//            public void run() {
//                while (true) {
//                    synchronized (object) {
//                        object.notify();
//                        System.out.println("A");
//                        try {
//                            object.wait();
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//            }
//        });
//        Thread thread2 = new Thread(new Runnable() {
//            public void run() {
//                while (true) {
//                    synchronized (object) {
//                        object.notify();
//                        System.out.println("B");
//                        try {
//                            object.wait();
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//            }
//        });
//        thread1.start();
//        Thread.sleep(1000);
//        thread2.start();
//    }

}
