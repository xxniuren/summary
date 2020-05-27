/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/5/27
 * @description: 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 **/
public class Solution63 {
    public static void main(String[] args) {
        Solution63 solution = new Solution63();
        int[][] obstacleGrid = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(solution.uniquePathsWithObstacles(obstacleGrid));
    }

    /**
     * 用动态规划 + 限制条件做，如果网格有障碍物，则将网格权重值设置为0
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        if (row == 0) return 0;
        int col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (obstacleGrid[i][j] == 1) continue;
                if (i == 0 && j == 0) {dp[0][0] = 1;continue;}
                if (i == 0) {dp[i][j] = dp[i][j-1];continue;};
                if (j == 0) {dp[i][j] = dp[i-1][j];continue;}
                if (dp[i - 1][j] != 0) dp[i][j] += dp[i - 1][j];
                if (dp[i][j - 1] != 0) dp[i][j] += dp[i][j - 1];
            }
        }
        return dp[row-1][col-1];
    }

    /**
     * 太难处理边界条件了
     *
     * @param obstacleGrid
     * @return
     */
    @Deprecated
    public int uniquePathsWithObstaclesBk(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || row == 0 || col == 0) return 0;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (obstacleGrid[i][j] == 1) obstacleGrid[i][j] = 0;
                else {
                    if (i == 0 || j == 0) obstacleGrid[i][j] = 1;
                    else {
                        obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                    }
                }
            }
        }
        return obstacleGrid[row - 1][col - 1];
    }

}
