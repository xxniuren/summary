/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/5/27
 * @description: 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * dp[m][n] = min{dp[m-1][n], dp[m][n-1]} + grid[m][n]
 **/
public class Solution64 {

    public static void main(String[] args) {
        Solution64 solution = new Solution64();
        int[][] gird = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(solution.minPathSum(gird));
    }
    /**
     * 功能：求最短路径
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        if (row == 0) return Integer.MAX_VALUE;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) dp[i][j] = grid[i][j];
                else if (i == 0) dp[i][j] = dp[i][j - 1] + grid[i][j];
                else if (j == 0) dp[i][j] = dp[i - 1][j] + grid[i][j];
                else {
                    dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]) + grid[i][j];
                }
            }
        }
        return dp[row-1][col-1];
    }

}
