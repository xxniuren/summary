package classify.mathcalc;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2021/1/13
 * @description:
 **/
public class Solution48 {

    /**
     * 先上下反转，然后按照对角线反转
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length <= 1) return;
        int row = matrix.length;
        int col = matrix[0].length;
        // 上下反转
        for (int i = 0; i < row / 2; i++) {
            for (int j = 0; j < col; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[row - i - 1][j];
                matrix[row - i - 1][j] = tmp;
            }
        }
        // 按照对角线反转
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}
