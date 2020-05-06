package leetcode;

import java.security.Signature;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/4/6
 * @description:
 **/
public class Singleton {
    private volatile static Singleton instance = null;
    private Singleton instance3 = null;
    private Singleton () {}

    public static Singleton getInstance() {
        if (null == instance) {
            synchronized (Singleton.class) {
                instance = new Singleton();
            }
        }
        return instance;
    }

    public static Singleton getInstance1() {
        return SingletonHolder.instance1;
    }

    public static class SingletonHolder {
        private static Singleton instance1 = new Singleton();
        public Singleton test() {
            return instance;
        }
    }

}
