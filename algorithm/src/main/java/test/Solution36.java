package test;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/10/13
 * @description:
 **/
public class Solution36 {

    public static void main(String[] args) {
        char[][] board = new char[9][9];
        board[0] = new char[]{'5','3','.','.','7','.','.','.','.'};
        board[1] = new char[]{'6','.','.','1','9','5','.','.','.'};
        board[2] = new char[]{'.','9','8','.','.','.','.','6','.'};
        board[3] = new char[]{'8','.','.','.','6','.','.','.','3'};
        board[4] = new char[]{'4','.','.','8','.','3','.','.','1'};
        board[5] = new char[]{'7','.','.','.','2','.','.','.','6'};
        board[6] = new char[]{'.','6','.','.','.','.','2','8','.'};
        board[7] = new char[]{'.','.','.','4','1','9','.','.','5'};
        board[8] = new char[]{'.','.','.','.','8','.','.','7','9'};
        Solution36 solution = new Solution36();
        solution.isValidSudoku(board);
    }

    public boolean isValidSudoku(char[][] board) {
        boolean[][] rowFlag = new boolean[9][9];
        boolean[][] colFlag = new boolean[9][9];
        boolean[][] cellFlag = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] >= '1' && board[i][j] <= '9') {
                    int pos = board[i][j] - '1';
                    if (rowFlag[i][pos] || colFlag[pos][j] || cellFlag[3 * (i / 3) + j / 3][pos]) return false;
                    rowFlag[i][pos] = true;
                    colFlag[pos][j] = true;
                    cellFlag[3 * (i / 3) + j / 3][pos] = true;
                }
            }
        }
        return true;
    }

}
