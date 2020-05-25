/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/5/25
 * @description: 螺旋矩阵
 **/
public class Solution59 {

    public static void main(String[] args) {
        Solution59 solution = new Solution59();
        int[][] res = solution.generateMatrix(3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println(res[i][j]);
            }
        }
    }

    //upper = 0, bottom = n-1, left = 0, right = n - 1;
    public int[][] generateMatrix(int n) {
        if (n == 0) return new int[][]{};
        if (n == 1) return new int[][]{{1}};
        int[][] res = new int[n][n];
        int top = 0, left = 0;
        int bottom = n - 1, right = n - 1;
        int val = 0;
        while (val < n * n) {
            //先从左往右走
            for (int col = left; col <= right; col++) {
                res[top][col] = val + 1;
                val++;
            }
            if (top < bottom) top++;
            else break;
            //然后从上往下走
            for (int row = top; row <= bottom; row++) {
                res[row][right] = val + 1;
                val++;
            }
            if (right > left) right--;
            else break;
            //然后从右往左走
            for (int col = right; col >= left; col--) {
                res[bottom][col] = val + 1;
                val++;
            }
            if (bottom > top) bottom--;
            else break;
            //然后从下往上走
            for (int row = bottom; row >= top; row--) {
                res[row][left] = val + 1;
                val++;
            }
            if (left < right) left++;
            else break;

        }
        return res;
    }
}
