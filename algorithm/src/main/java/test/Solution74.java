package test;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/12/20
 * @description:
 **/
public class Solution74 {
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        int target = 13;
        Solution74 solution = new Solution74();
        boolean b = solution.searchMatrix(matrix, target);
        System.out.println(b);
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        // 先从上往下找，查找第一个大于target的行，然后从右往左找
        int row = 0;
        for (; row < matrix.length; row++) {
            if (matrix[row][matrix[row].length - 1] == target) return true;
            if (matrix[row][matrix[row].length - 1] > target) {
                break;
            }
        }
        if (row == matrix.length) return false;

        //然后从后往前找
        int col = matrix[0].length - 1;
        for (; col >= 0; col--) {
            if (matrix[row][col] == target) {
                return true;
            }
        }
        return false;
    }
}
