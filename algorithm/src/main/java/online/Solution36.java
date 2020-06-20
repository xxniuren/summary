package online;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/5/9
 * @description:
 **/
public class Solution36 {
    public static void main(String[] args) {
        char[][] board = {{1,2,3}};
        Solution36 solution = new Solution36();
        boolean res = solution.isValidSudoku(board);
        System.out.println(res);
    }

    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][0];
        int[][] col = new int[9][9];
        int[][] block = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int val = board[i][j] - '1';
                    int blockIndex = i / 3 + j / 3 * 3;
                    row[i][val] += 1;
                    col[j][val] += 1;
                    block[blockIndex][val] += 1;
                    if (row[i][val] > 1 || col[j][val] > 1 || block[blockIndex][val] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
