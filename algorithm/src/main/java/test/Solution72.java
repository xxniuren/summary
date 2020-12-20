package test;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/12/20
 * @description:
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数
 **/
public class Solution72 {

    public static void main(String[] args) {
        Solution72 solution = new Solution72();
        String word1 = "horse", word2 = "ros";
        System.out.println(solution.minDistance(word1, word2));
    }

    public int minDistance(String word1, String word2) {
        //
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        //base case
        for (int i = 0; i < word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < word2.length(); j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i < word1.length() + 1; i++) {
            for (int j = 1; j < word2.length() + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i][j - 1], dp[i - 1][j - 1]),
                            dp[i- 1][j]);
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

}
