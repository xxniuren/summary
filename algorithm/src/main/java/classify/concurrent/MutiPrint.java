package classify.concurrent;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2021/1/30
 * @description:
 **/
public class MutiPrint {

    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        Thread thread1 = new Thread(new PrintThread("A", object));
        thread1.start();
        Thread.sleep(1000);
        Thread thread2 = new Thread(new PrintThread("B", object));
        thread2.start();
    }

}
