package sort;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/7/18
 * @description: 插入排序
 * 1. 从第一个元素开始，该元素可以认为已经被排序；
 * 2. 取出下一个元素，在已经排序的元素序列中从后向前扫描；
 * 3. 如果该元素（已排序）大于新元素，将该元素移到下一位置；
 * 4. 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
 * 5. 将新元素插入到该位置后；
 * 6. 重复步骤2~5。
 *
 * 最佳情况：T(n) = O(n2)  最差情况：T(n) = O(n2)  平均情况：T(n) = O(n2)
 *
 **/
public class InsertionSort {
    public int[] sort(int a[]) {
        if (a == null || a.length == 0) {
            return null;
        }
        for (int i = 1; i < a.length; i++) {
            int curr = a[i + 1];
            int index = i;
            while (index >= 0 && curr < a[index]) {
                a[index + 1] = a[index];
                index--;
            }
            a[index + 1] = curr;
        }
        return a;
    }
}
