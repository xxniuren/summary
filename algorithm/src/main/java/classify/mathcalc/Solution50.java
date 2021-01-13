package classify.mathcalc;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2021/1/13
 * @description:
 **/
public class Solution50 {

    public static void main(String[] args) {
        Solution50 solution = new Solution50();
        System.out.println(solution.myPow(2.0, -2));
    }

    public double myPow(double x, int n) {
        double res = 1;
        for (int i = n; i != 0; i = i / 2) {
            if (i % 2 != 0) res *= x;
            x *= x;
        }
        return n > 0 ? res : 1 / res;
    }
}
