package test;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/12/18
 * @description: 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 **/
public class Solution70 {

    public static void main(String[] args) {
        Solution70 solution = new Solution70();
        System.out.println(solution.climbStairs(3));
    }

    public int climbStairs(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        if (n == 1) return dp[0];
        dp[1] = 2;
        if (n == 2) return dp[1];
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

}
