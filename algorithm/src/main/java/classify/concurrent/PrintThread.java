package classify.concurrent;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2021/1/30
 * @description:
 **/
public class PrintThread implements Runnable {

    String printContent;
    Object object;

    public PrintThread (String printContent, Object object) {
        this.printContent = printContent;
        this.object = object;
    }

    public void run() {
        while (true) {
            synchronized (object) {

                object.notify(); // 等到线程可用之后才会进行通知
                System.out.println(Thread.currentThread().getName() + "@" + printContent);
                try {
                    Thread.sleep(1000);
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

}
