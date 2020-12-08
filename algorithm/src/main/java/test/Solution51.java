package test;

import online.Solution4;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/12/8
 * @description:
 * n皇后问题，在一个(x, y) 坐标对应的行、列、左右对角线均没有皇后
 * 每行，每列，每条左 右对角线均只有一个Q
 **/
public class Solution51 {

    public static void main(String[] args) {
        Solution51 solution = new Solution51();
        List<List<String>> res = solution.solveNQueens(4);
        System.out.println(res);
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        //初始化board
        char[][] board = this.initBoard(n);
        // 回溯对象
        backtrack(res, board, 0);
        return res;
    }

    public void backtrack(List<List<String>> res, char[][] board, int row) {
        if (row == board.length) {
            // 生成对象，row最后一行处理完后就可以直接输出
            this.generate(res, board);
            return;
        }
        for (int col = 0; col < board.length; col++) {
            // 判断是否满足皇后条件，如果满足的化则进入下一行查找，
            if (isValid(board, row, col)) {
                board[row][col] = 'Q';
                // 直接进入下一行查找
                backtrack(res, board, row + 1);
                board[row][col] = '.';
            }
        }
    }

    public boolean isValid(char[][] board, int row, int col) {
        // 判断该列是否有Q
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == 'Q') return false;
        }
        // 判断左上对角线是否有Q，左下对角线没有操作，所以不需要关注
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        // 判断右上对角线是否有Q，右下对角线没有操作，所以不需要关注
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
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
