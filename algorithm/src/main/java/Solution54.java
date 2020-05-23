import java.util.ArrayList;
import java.util.List;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/5/23
 * @description:
 **/
public class Solution54 {


    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3},{4, 5, 6 },{7, 8, 9 }};
        int[][] matrix1 = {};
        Solution54 solution = new Solution54();
        System.out.println(solution.spiralOrder(matrix1));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        while (true) {
            //先从左往右走
            for (int col = left; col <= right; col++) {
                res.add(matrix[top][col]);
            }
            if (top < bottom) top++;
            else break;
            //从上往下走
            for (int row = top; row <= bottom; row++) {
                res.add(matrix[row][right]);
            }
            if (right > left) right--;
            else break;
            //从右往左走
            for (int col = right; col >= left; col--) {
                res.add(matrix[bottom][col]);
            }
            if (bottom > top) bottom--;
            else break;
            //从下往上走
            for (int row = bottom; row >= top; row--) {
                res.add(matrix[row][left]);
            }
            if (left < right) left++;
            else break;
        }
        return res;
    }

}
