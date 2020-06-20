package online;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/5/26
 * @description: 第k个序列
 **/
public class Solution60 {

    public static void main(String[] args) {
        Solution60 solution = new Solution60();
        System.out.println(solution.getPermutation(4, 9));
    }

    /**
     * 使用的是 康托展开，代码简洁不少
     * @param n
     * @param k
     * @return
     */
    public String getPermutation(int n, int k) {
        int[] digit = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Integer> digitList = Arrays.stream(digit).boxed().collect(Collectors.toList());
        int[] factor = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
        StringBuilder sb = new StringBuilder();
        k--;
        while (n > 0) {
            int val = k / factor[n - 1];
            sb.append(digitList.get(val + 1));
            digitList.remove(val + 1);
            k = k % factor[n - 1];
            n--;
        }
        return sb.toString();
    }

    //总共有n位数
    //第一位数为：
    //如果 (k) / (n-1)! = 的整数 + 1
//    public String getPermutation(int n, int k) {
//        StringBuilder sb = new StringBuilder();
//        k--;
//        boolean[] isVisitsed = new boolean[n];
//        for (int i = 0; i < n; i++) isVisitsed[i] = false;
//        for (int i = n - 1; i > 0; i--) {
//            int fac = factorial(i);
//            int val = k / fac + 1;
//            int cnt = 0;
//            for (int r = 1; r <= n; r++) {
//                if (isVisitsed[r - 1] == false) cnt++;
//                if (cnt == val) {
//                    sb.append(r);
//                    isVisitsed[r - 1] = true;
//                    break;
//                }
//            }
//
//            k = k % fac;
//            if (k == 0) {
//                for (int j = 0; j < n; j++) {
//                    if (isVisitsed[j] == false) sb.append(j+1);
//                }
//                return sb.toString();
//            }
//        }
//        for (int j = 0; j < n; j++) {
//            if (isVisitsed[j] == false) sb.append(j+1);
//        }
//        return sb.toString();
//    }
//
//
//
//
//    /**
//     * 求阶乘
//     * @param n
//     * @return
//     */
//    private int factorial(int n) {
//        int res = 1;
//        for (int i = 1; i <= n; i++) {
//            res = res * i;
//        }
//        return res;
//    }
}
