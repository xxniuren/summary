/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/6/15
 * @description:
 *
 * f(n) = f(0)f(n-1) + f(2)*f(n-2)
 **/
public class Solution96 {

    public static void main(String[] args) {
        Solution96 solution = new Solution96();
        System.out.println(solution.numTrees(2));
    }
    //backtrace
    public int numTrees(int n) {
        if (n ==0 || n == 1) return 1;
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res += numTrees(i - 1) * numTrees(n - i);
        }
        return res;
    }
}
