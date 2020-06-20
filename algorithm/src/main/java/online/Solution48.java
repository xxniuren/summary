package online;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/5/20
 * @description:
 **/
public class Solution48 {
    public static void main(String[] args) {
        Solution48 solution = new Solution48();
        int[][] matrix = {{1,4,7},{2,5,8},{3,6,9}};
        solution.rotate(matrix);
        System.out.println(matrix);
    }

    public void rotate(int[][] matrix) {
        //一张图先上下反转，然后对角反转
        int row = matrix.length;
        int col = matrix[0].length;
        //将列上下反转
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][col - j - 1];
                matrix[i][col - j - 1] = tmp;
            }
        }
        //按对角线反转
        for (int j = 0; j < col - 1; j++) {
            for (int i = 0; i < j; i++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

    }


}
