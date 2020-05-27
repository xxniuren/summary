/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/5/27
 * @description:
 *
 * 走台阶问题，一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 *
 * dp[m][n] = dp[m-1][n] + dp[m][n-1] 动态转移方程，dp[0][1] = 1, dp[1][0] = 1
 **/
public class Solution62 {
    public static void main(String[] args) {
        Solution62 solution = new Solution62();
        System.out.println(solution.uniquePaths(3, 7));
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) dp[i][j] = 1;
                else dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }
}
