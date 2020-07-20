package sort;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/4/8
 * @description: 冒泡排序，每次比较响铃两个元素大小
 * 最佳情况：T(n) = O(n)   最差情况：T(n) = O(n2)   平均情况：T(n) = O(n2)
 **/
public class BubbleSort {

    public int[] bubbleSort(int a[]) {
        if (a == null || a.length == 0) return a;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - i; j++) {
                if (a[i + 1] < a[i]) {
                    int tmp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = tmp;
                }
            }
        }
        return a;
    }
}
