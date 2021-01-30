package threadlocal;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2021/1/27
 * @description:
 **/
public class PrintClass implements Runnable {
    String printContent;
    Object object;
    public PrintClass (String printContent, Object object) {
        this.printContent = printContent;
        this.object = object;
    }

    public void run() {
        while (true) {
            synchronized (object) {
                object.notify();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(printContent);
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
