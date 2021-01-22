package classify.concurrent;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2021/1/20
 * @description:
 **/
public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runner(), "Runner");
        thread.start();
        //
        Thread.sleep(10);
        thread.interrupt();
        // sleep 3s
        System.out.println("Thread: " + thread.isInterrupted());
    }

    static class Runner implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
//                    return;
                }
            }
        }
    }
}
