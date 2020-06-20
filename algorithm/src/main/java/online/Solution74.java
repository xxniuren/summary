package online;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/5/30
 * @description:
 *
 * 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *
 **/
public class Solution74 {
    public static void main(String[] args) {
//        int[][] matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        int[][] matrix = new int[][]{{}};
        int target = 3;
        Solution74 solution = new Solution74();
        System.out.println(solution.searchMatrix(matrix, target));

    }

    /**
     * 查找目标数据，从上往下，从后往前查找
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length) {
            if (matrix[row][col] < target) row++;
            else break;
        }
        if (row == matrix.length) return false;
        while (col >= 0) {
            if (matrix[row][col] > target) col--;
            else if (matrix[row][col] == target) return true;
            else return false;
        }
        return false;
    }
}
