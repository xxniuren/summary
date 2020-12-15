package test;

import online.Solution5;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/12/15
 * @description:
 *
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 **/
public class Solution64 {

    public static void main(String[] args) {
        Solution64 solution = new Solution64();
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        int minPathSum = solution.minPathSum(grid);
        System.out.println(minPathSum);
    }

    public int minPathSum(int[][] grid) {
        int row = grid.length;
        if (row == 0) return Integer.MIN_VALUE;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                    continue;
                }
                if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                    continue;
                }
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }

}
