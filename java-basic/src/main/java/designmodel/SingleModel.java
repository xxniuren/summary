package designmodel;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2021/1/23
 * @description:
 **/
public class SingleModel {
    // 通过volatile 来禁止指令重排序，JMM中，内存对象的初始化为：申请内存，初始化对象，对象赋值；
    // 可能由于指令重排序出现：申请内存，对象赋值，初始化对象；另一个线程拿到的对象实例可能还没有初始化
    private volatile static Instance instance;

    public static volatile Instance instance1 = new SingleModel().new Instance();

    public static Instance lazyGet() {
        if (null == instance) {
            synchronized (SingleModel.class) {
                if (null == instance) {
                    instance = new SingleModel().new Instance();
                }
            }
        }
        return instance;
    }

    public static Instance hugeryGet() {
        return instance1;
    }

    public class Instance {

    }
}
