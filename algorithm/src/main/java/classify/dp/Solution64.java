package classify.dp;

import java.util.*;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/12/27
 * @description:
 **/
public class Solution64 {

    public static void main(String[] args) {
        Solution64 solution = new Solution64();
        int grid[][] = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(solution.minPathSum(grid));
        Map<String, String> map = new HashMap<>();
        map.put("aa", "bb");

        List<String> list = new LinkedList<>();
        list.add("a");
    }

    public int minPathSum(int[][] grid) {
        if (null == grid && grid.length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
        }
        return dp[row - 1][col - 1];
    }

}
