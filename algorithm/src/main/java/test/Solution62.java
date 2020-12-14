package test;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/12/14
 * @description:
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 * 问总共有多少条不同的路径？
 *
 **/
public class Solution62 {

    public static void main(String[] args) {
        Solution62 solution = new Solution62();
        System.out.println(solution.uniquePaths(3, 7));
    }

    /**
     * 动态规划求解，dp表示 从预设点到当前点总共的走法，例如 走到 (2,0)这个坐标，只能从(1,0)才能走到
     * 但是走到(2,1)坐标，可以从(2,0),(1,1)两个点走到，如果是边缘那么只有一种解法，如果不是边缘，那么解法和
     * 该点的左边和上边的解法有关系
     * @param m
     * @param n
     * @return
     *
     * 解法可以理解为到达方法
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // 如果m=0 或 n=0 有1种到达方法
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j ==0) {
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m-1][n-1];
    }


}
