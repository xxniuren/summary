package sort;

import java.util.Arrays;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/7/18
 * @description: 归并排序
 * 1. 把长度为n的输入序列分成两个长度为n/2的子序列；
 * 2. 对这两个子序列分别采用归并排序；
 * 3. 将两个排序好的子序列合并成一个最终的排序序列。
 *
 * 最佳情况：T(n) = O(n)  最差情况：T(n) = O(nlogn)  平均情况：T(n) = O(nlogn)
 **/
public class MergeSort {

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] a = {2,9,2,4,6,3,1,7};
        int[] res = mergeSort.sort(a);
        System.out.println(res.toString());
    }

    public int[] sort(int a[]) {
        if (null == a || a.length < 2) return a;
        int mid = a.length / 2;
        int[] m = Arrays.copyOfRange(a, 0, mid);
        int[] r = Arrays.copyOfRange(a, mid, a.length);
        return merge(sort(m), sort(r));
    }

    public int[] merge(int[] m, int[] r) {
        int[] res = new int[m.length + r.length];
        for (int index = 0, i = 0, j = 0; index < res.length; index++) {
            if (i >= m.length) {
                res[index] = r[j++];
            } else if (j >= r.length) {
                res[index] = m[i++];
            } else if (m[i] < r[j]) {
                res[index] = m[i++];
            } else {
                res[index] = r[j++];
            }
        }
        return res;
    }
}
