/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/5/22
 * @description: 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 **/
public class Solution50 {
    public static void main(String[] args) {
        Solution50 solution = new Solution50();
        int x = 2;
        int i = 5;
        System.out.println(solution.myPow(x, i));
    }

    public double myPow(double x, int n) {
        double res = 1;
        for (int i = n; i != 0; i = i / 2) {
            if (i % 2 != 0) res *= x;
            x = x * x;
        }
        return (n >= 0) ? res : 1.0 / res;
    }

}
