package classify.mathcalc;


/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2021/1/12
 * @description:
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 **/
public class Solution7 {

    public static void main(String[] args) {
        Solution7 solution = new Solution7();
        System.out.println(solution.reverse(1534236469));
    }

    public int reverse(int x) {
        boolean symb = x > 0;
        int absX = Math.abs(x);
        long res = 0;
        while (absX > 0) {
            if (res * 10 + absX % 10 > Integer.MAX_VALUE) return 0;
            res = res * 10 + absX % 10;
            absX = absX / 10;
        }
        int val = res == (int) res ? (int)res : 0;
        return symb ? val : val * -1;
    }
}
