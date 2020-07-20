package sort;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/7/18
 * @description: 选择排序
 * 1. 初始状态：无序区为R[1..n]，有序区为空；
 * 2. 第i趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为R[1..i-1]和R(i..n）。该趟排序从当前无序区中-选出关键字最小的记录 R[k]，将它与无序区的第1个记录R交换，使R[1..i]和R[i+1..n)分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区；
 * 3. n-1趟结束，数组有序化了
 *
 * 最佳情况：T(n) = O(n2)  最差情况：T(n) = O(n2)  平均情况：T(n) = O(n2)
 **/
public class SelectionSort {
    public int[] sort(int a[]) {
        if (a == null || a.length == 0) {
            return null;
        }
        for (int i = 0; i < a.length; i++) {
            int minIndex = i;
            for (int j = i; j < a.length; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
                int tmp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = tmp;
            }
        }
        return a;
    }
}
