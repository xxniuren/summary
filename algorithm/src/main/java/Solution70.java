/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/5/17
 * @description:
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * f(n) = f(n-1) + f(n-2)
 * 第一个台阶：1种走法
 * 第二个台阶：2种走法
 * 第三个台阶：3种走法
 * 第四个台阶：5种解法
 * 斐波那契函数, f(n)=f(n-1)+f(n-2) ，可以从上往下走，每次走一步 那下面还有f(n-1)种走法，走2步 有f(n-2)次解法
 *
 * 处理动态规划问题
 **/
public class Solution70 {

    public static void main(String[] args) {
        Solution70 solution = new Solution70();
        int count = solution.climbStairsDP(3);
        System.out.println(count);
        int[] coins = {3};
//        System.out.println(solution.coinChange(coins, 19));

//        int coinsWays = solution.coinWays(coins, 2);
//        System.out.println(coinsWays);
    }
    /**
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return climbStairs(n-1) + climbStairs(n-2);
    }**/

    public int climbStairs(int n) {
        int c1 = 1;
        int c2 = 2;
        if (n==1) return c1;
        if (n==2) return c2;
        for (int i = 3; i <= n; i++) {
            int tmp = c1 + c2;
            c1 = c2;
            c2 = tmp;
        }
        return c2;
    }

    public int climbStairsDP(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= 2; i++) {
            for (int j = 1; j <= n; j++) {
                if (j >= i) dp[j] += dp[j-i];
            }
        }
        return dp[n];
    }

    /**
     * 币种找零问题：
     * 给你不同面值的硬币数组coins和总金额amount。 编写一个函数来计算您需要对amount金额的进行找零的最少数量的硬币。
     * 如果这些金额不能由硬币的任何组合来找零，则返回'-1'。
     * dp(n) = Math.min(dp[n-coins[i] + 1])
     */
    public int coinChange(int[] coins, int amount) {
        if (coins.length <= 0 || amount <= 0) return 0;
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount;
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) //这个的目的是控制台阶跳跃的格数，该问题是为了求最优解
                dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    /**
     * 查看硬币总共组合数
     * 给你不同面值的硬币数组coins和总金额amount。 编写一个函数来计算组成该amount的组合的数量。
     * 每种硬币的个数是无限的
     * 这个题可以理解为：走台阶 可以走1步 2步 5步，总共的走法
     * f(n) = f(n-coins[0]) + f(n-coins[1]) + f(n-coins[2]) + ... + f(n-coins[k])
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinWays(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                //每经过一个拐点，多一种方法
                if (j >= coins[i]) dp[j] += dp[j-coins[i]];
            }
        }
        return dp[amount]; //这个还没想明白怎么做
//        if (coins.length <= 0 || amount <= 0) return 0;
//        int dp[] = new int[amount + 1];
//        for (int i = 1; i <= amount; i++) {
//            for (int j = 0; j < coins.length; j++) {
//                if (i >= j) dp[i] = dp[i - coins[j]] + 1;
//            }
//        }
    }

}
