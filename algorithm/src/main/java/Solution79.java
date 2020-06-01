/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/5/30
 * @description:
 *
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 例如：
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 *
 **/
public class Solution79 {

    public static void main(String[] args) {
        Solution79 solution = new Solution79();
        char[][] board = new char[][]{{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
        String word = "ABCB";
        System.out.println(solution.exist(board, word));
    }

    public boolean exist(char[][] board, String word) {
        int rowTotal = board.length;
        int colTotal = board[0].length;
        if (rowTotal == 0) return false;
        boolean[][] isVisited = new boolean[rowTotal][colTotal];
        for (int i = 0; i < rowTotal; i++) {
            for (int j = 0; j < colTotal; j++) {
                if (board[i][j] == word.charAt(0)) {
                    //进入helper函数
                    boolean isSuccess = helper(board, word, i, j, 0, isVisited);
                    if (isSuccess) return true;
                }
            }
        }
        return false;
    }

    private boolean helper(char[][] board, String word, int row, int col, int index, boolean[][] isVisited) {
        if (index >= word.length()) return true;
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return false;
        if (isVisited[row][col]) return false;
        if (board[row][col] != word.charAt(index)) return false;
        isVisited[row][col] = true;
        if (helper(board, word, row - 1, col, index + 1, isVisited) || helper(board, word, row + 1, col, index + 1, isVisited) ||
                helper(board, word, row, col - 1, index + 1, isVisited) || helper(board, word, row, col + 1, index + 1, isVisited)) {
            return true;
        }
        isVisited[row][col] = false;
        return false;

    }
}
