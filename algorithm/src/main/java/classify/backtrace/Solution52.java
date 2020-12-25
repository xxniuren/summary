package classify.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/12/25
 * @description:
 **/
public class Solution52 {

    public static void main(String[] args) {
        Solution52 solution = new Solution52();
        int size = solution.totalNQueens(4);
        System.out.println(size);
    }

    public int totalNQueens(int n) {
        List<List<String>> lists = new ArrayList<>();
        char[][] board = initBoard(n);
        backtrace(lists, board, 0);
        return lists.size();
    }

    public void backtrace(List<List<String>> lists, char[][] board, int row) {
        if (row == board.length) {
            generate(lists, board);
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if (isVaild(board, row, col)) {
                board[row][col] = 'Q';
                backtrace(lists, board, row + 1);
                board[row][col] = '.';
            }
        }
    }


    public boolean isVaild(char[][] board, int row, int col) {
        // 检测该列上是否有Q
        for (int i = 0; i <= row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // 检查左上角是否有Q
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // 检查右上角是否有Q
        for (int i = row - 1, j = col + 1; i >= 0 && j <= board.length - 1; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public char[][] initBoard(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        return board;
    }

    public void generate(List<List<String>> lists, char[][] board) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < board.length; j++) {
                sb.append(board[i][j]);
            }
            list.add(sb.toString());
        }
        lists.add(list);
    }
}
