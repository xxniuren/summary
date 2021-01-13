package classify.mathcalc;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2021/1/13
 * @description:
 **/
public class Solution73 {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        // 强行计算
        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];
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
