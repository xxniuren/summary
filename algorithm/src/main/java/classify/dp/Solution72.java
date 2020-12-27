package classify.dp;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/12/27
 * @description:
 **/
public class Solution72 {

    public static void main(String[] args) {
        Solution72 solution = new Solution72();
        String word1 = "horse";
        String word2 = "ros";
        System.out.println(solution.minDistance(word1, word2));
    }

    public int minDistance(String word1, String word2) {
        // 从word2 转换为word1
        int[][] dp = new int[word2.length() + 1][word1.length() + 1];
        // 从word2 转换为0的步骤
        for (int i = 0; i < word2.length() + 1; i++) dp[i][0] = i;
        for (int i = 0; i < word1.length() + 1; i++) dp[0][i] = i;
        for (int i = 1; i < word2.length() + 1; i++) {
            for (int j = 1; j < word1.length() + 1; j++) {
                if (word2.charAt(i - 1) == word1.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[word2.length()][word1.length()];
    }

}
