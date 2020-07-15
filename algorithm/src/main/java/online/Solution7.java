package online;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/7/15
 * @description: 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转
 **/
public class Solution7 {

    public static void main(String[] args) {
        int x = 1534236469;
        Solution7 solution = new Solution7();
        System.out.println(solution.reverse(x));
    }

    public int reverse(int x) {
        boolean isPos = x >= 0;
        long res = 0;
        int absX = Math.abs(x);
        while (absX != 0) {
            if (res * 10 + absX % 10 >= Integer.MAX_VALUE) return 0;
            res = res * 10 + absX % 10;
            absX = absX / 10;
        }
        int val = (int) res == res ? (int) res : 0;
        return isPos ? val : -1 * val;
    }

}
