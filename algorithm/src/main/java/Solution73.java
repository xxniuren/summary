/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/5/30
 * @description:
 *
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法
 *
 * 输入:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 *
 **/
public class Solution73 {

    public static void main(String[] args) {
        Solution73 solution = new Solution73();
        int[][] matrix = new int[][]{{1,1,1},{1,0,1},{1,1,1}};
        solution.setZeroes(matrix);
    }

    public void setZeroes(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        if (matrix.length == 0) return;
        for (int i = 0; i < row.length; i++) row[i] = false;
        boolean[] col = new boolean[matrix[0].length];
        for (int i = 0; i < col.length; i++) col[i] = false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (row[i] || col[j]) matrix[i][j] = 0;
            }
        }
    }

}
