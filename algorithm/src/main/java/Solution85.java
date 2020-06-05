/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/6/5
 * @description: 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 **/
public class Solution85 {

    public static void main(String[] args) {
        char[][] matrix = new char[][]{{'1', '0', '1', '1', '1'}, {'0', '1', '0', '1', '0'}, {'1', '1', '0', '1', '1'}, {'1', '1', '0', '1', '1'},
                {'0', '1', '1', '1', '1'}};
//        char[][] matrix = new char[][]{{'0'}};
        Solution85 solution = new Solution85();
        System.out.println(solution.maximalRectangle(matrix));
    }

    /**
     * 感觉题解思路不太容易想到
     *
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        if (row == 0) return 0;
        int col = matrix[0].length;
        //初始化dp
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = (j >= 1) ? dp[i][j - 1] + 1 : 1;
                }
            }
        }
        //遍历数组内部每个元素，往上查找，找出最大的area
        int area = -1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dp[i][j] == 0) continue;
                int minHeight = dp[i][j];
                for (int k = i; k >= 0 && dp[k][j] > 0; k--) {
                    int wide = i - k + 1;
                    minHeight = Math.min(minHeight, dp[k][j]);
                    area = Math.max(wide * minHeight, area);
                }
            }
        }
        return area == -1 ? 0 : area;
    }

}
