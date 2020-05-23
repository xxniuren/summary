import java.util.ArrayList;
import java.util.List;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/5/23
 * @description: n皇后问题
 *
 * 输入: 4
 * 输出: [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 *
 **/
public class Solution51 {
    public static void main(String[] args) {
        int n = 4;
        Solution51 solution = new Solution51();
        List<List<String>> res = solution.solveNQueens(n);
        System.out.println(res);
    }

    /**
     * 功能：解决n皇后问题
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = initBoard(n);
        backtrace(res, board, 0);
        return res;
    }


    //回溯皇后
    public void backtrace(List<List<String>> res, char[][] board, int row) {
        if (row == board.length) {
            generate(res, board);
            return;
        }
        for (int col = 0; col < board.length; col++) {
            //一个个查看
            if (isValid(board, row, col)) {
                //1. board填充
                board[row][col] = 'Q';
                //2. 进入下一列查找
                backtrace(res, board, row + 1);
                //3. 本列board复原
                board[row][col] = '.';
            }
        }
    }

    /**
     * 初始化board
     * @param n
     * @return
     */
    private char[][] initBoard(int n) {
        char[][] board = new char[n][n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                board[row][col] = '.';
            }
        }
        return board;
    }

    //判断该点是否可以放Q
    private boolean isValid(char[][] board, int row, int col) {
        //首先判断该列上有没有Q
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == 'Q') return false;
        }
        //判断左上对角线是否有Q，是对角线，不是点，所以这里需要循环
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        //判断右上对角线是否有Q，是对角线
        for (int i = row - 1, j = col + 1; i >= 0 && j <= board.length - 1; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }

    /**
     * 生成输出数据
     * @param res
     * @param board
     */
    private void generate(List<List<String>> res, char[][] board) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < board.length; j++) {
                sb.append(board[i][j]);
            }
            list.add(sb.toString());
        }
        res.add(list);
    }

}
