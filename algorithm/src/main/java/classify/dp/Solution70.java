package classify.dp;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/12/27
 * @description:
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 *
 **/
public class Solution70 {
    public static void main(String[] args) {
        Solution70 solution = new Solution70();
        int n = 3;
        System.out.println(solution.climbStairs(n));
    }
    // 用动态规划做 dp[i] = dp[i - 1] + dp[i - 2];
    // dp[1] = 1; dp[2] = 2;
    public int climbStairs(int n) {
        // 可以通过斐波拉切函数做，也可以通过动态规划做
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        if (n <= 2) return dp[n];
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}
