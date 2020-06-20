package online;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/5/30
 * @description: 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * <p>
 * 使用dp条件：
 * 1. 存在最优子结构；
 * 2. 存在多重子问题；
 * <p>
 * 例如例子 hor -> ro，从长度3转换成长度2，
 * 1. 已知 从 hor -> r 从长度3转换成长度1，那么再加一个o 就可以从长度3转换成长度2了。
 * 2. 已知 从 ho -> r 从长度2转换成长度1，那么对于新加上的元素进行替换就行。
 * 3. 已知 从 ho -> ro，从长度2转换成长度2，那么删除最后一个元素则可。
 * <p>
 * 例如：想将长度变成
 * 那么存在三种情况：
 * 从(0,2) -> (1,2) 做删除操作
 * 从(0,1) -> (1,2) 做替换操作
 * 从(1,1) -> (1,2) 做删除操作
 *
 * 参考视频：https://www.bilibili.com/video/BV1nx411M7sg?from=search&seid=2386425673420711977
 **/
public class Solution72 {
    public static void main(String[] args) {
        Solution72 solution = new Solution72();
        System.out.println(solution.minDistance("horse", "ros"));
    }
    /**
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word2.length() + 1][word1.length() + 1];
        for (int i = 0; i < word2.length() + 1; i++) dp[i][0] = i;
        for (int i = 0; i < word1.length() + 1; i++) dp[0][i] = i;
        for (int i = 1; i < word2.length() + 1; i++) {
            for (int j = 1; j < word1.length() + 1; j++) {
                if (word2.charAt(i - 1) == word1.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i-1][j-1]), dp[i][j-1]) + 1;
                }
            }
        }
        return dp[word2.length()][word1.length()];
    }
}
