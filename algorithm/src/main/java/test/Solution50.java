package test;

import online.Solution4;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/12/8
 * @description:
 **/
public class Solution50 {

    public static void main(String[] args) {
        Solution50 solution = new Solution50();
        double res = solution.myPow(2.0, -3);
        System.out.println(res);
    }

    public double myPow(double x, int n) {
        double res = 1;
        if (n == 0) return 1;
        boolean isPostive = n > 0 ? true : false;
        for (int i = 0; i < Math.abs(n); i++) {
            res = res * x;
        }
        return isPostive ? res : 1.0 / res;
    }
}
