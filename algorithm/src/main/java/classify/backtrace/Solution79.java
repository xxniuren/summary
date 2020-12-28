package classify.backtrace;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/12/23
 * @description:
 **/
public class Solution79 {

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
        String word = "ABCCED";
        Solution79 solution = new Solution79();
        boolean exist = solution.exist(board, word);
        System.out.println(exist);
    }

    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] visit = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0)) {
                   boolean exist = backtrace(board, word, i, j, 0, visit);
                   if (exist) { return true; }
                }
            }
        }
        return false;
    }

    public boolean backtrace(char[][] board, String word, int row, int col, int index, boolean[][] visited) {
        if (index >= word.length()) {
            return true;
        }
        if (row < 0 || row >= board.length || col < 0 || col > board[0].length) {
            return false;
        }
        if (visited[row][col]) return false;
        if (board[row][col] != word.charAt(index)) return false;
        visited[row][col] = true;
        // 上走一格 下走一格 左走一格 右走一格
        if (backtrace(board, word, row - 1, col, index + 1, visited) || backtrace(board, word, row + 1, col, index + 1, visited) ||
         backtrace(board, word, row, col - 1, index + 1, visited) || backtrace(board, word, row, col + 1, index + 1, visited)) {
            return true;
        }
        // 状态清理
        visited[row][col] = false;
        return false;
    }
}
