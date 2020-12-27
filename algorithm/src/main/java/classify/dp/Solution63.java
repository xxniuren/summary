package classify.dp;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/12/27
 * @description:
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 **/
public class Solution63 {

    public static void main(String[] args) {
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        Solution63 solution = new Solution63();
        int i = solution.uniquePathsWithObstacles(obstacleGrid);
        System.out.println(i);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) return 0;
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 如果是障碍点，路径为0
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                // 如果是0点，则路径为1
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                // 如果是x边缘点
                if (i == 0) {
                    dp[i][j] = dp[i][j - 1];
                    continue;
                }
                // 如果是y边缘点
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
                // 如果左边是障碍点
                if (obstacleGrid[i][j - 1] == 1) {
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
                // 如果右边是障碍点
                if (obstacleGrid[i - 1][j] == 1) {
                    dp[i][j] = dp[i][j - 1];
                    continue;
                }
                // 其他
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[row - 1][col - 1];
    }

}
