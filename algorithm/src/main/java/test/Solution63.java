package test;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/12/15
 * @description:
 **/
public class Solution63 {

    public static void main(String[] args) {
        Solution63 solution = new Solution63();
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        int res = solution.uniquePathsWithObstacles(obstacleGrid);
        System.out.println(res);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        if (row == 0) return 0;
        int col = obstacleGrid[0].length;
        int dp[][] = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //如果该点为障碍点，则设置该点为0
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                // 如果该点为起始点，设置为1
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                // 如果该点在横坐标上，则设置该点为前一个点的dp
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
                // 如果该点在纵坐标上，则设置该点为上一个点的dp
                if (i == 0) {
                    dp[i][j] = dp[i][j - 1];
                    continue;
                }
                // 如果该点的左边点是障碍物，则设置dp为上一个点的dp
                if (obstacleGrid[i - 1][j] != 0) {
                    dp[i][j] = dp[i][j-1];
                    continue;
                }
                // 如果该点的上边点是障碍物，则设置dp为左边点的dp
                if (obstacleGrid[i][j - 1] != 0) {
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
                // 都不是的情况下，该点的dp为左边点和上边点dp的和
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[row - 1][col - 1];
    }

}
