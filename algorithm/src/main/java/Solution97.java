/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/6/16
 * @description:
 * 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
 * 示例1：
 *   输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 *   输出: true
 *
 * 示例2：
 *   输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 *   输出: false
 **/
public class Solution97 {
    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        Solution97 solution = new Solution97();
        solution.isInterleave(s1, s2, s3);
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        int s1Len = s1.length();
        int s2Len = s2.length();
        int s3Len = s3.length();
        if (s1Len + s2Len != s3Len) return false;
        Boolean dp[][] = new Boolean[s1Len + 1][s2Len + 1];
        dp[0][0] = true;
        for (int i = 1; i <= s1Len; i++) {
            dp[i][0] = s1.charAt(i - 1) == s3.charAt(i - 1) && dp[i - 1][0] ;
        }
        for (int j = 1; j <= s2Len; j++) {
            dp[0][j] = s2.charAt(j - 1) == s3.charAt(j - 1) && dp[0][j - 1];
        }
        for (int i = 1; i <= s1Len; i++) {
            for (int j = 1; j <= s2Len; j++) {
                if (s3.charAt(i + j - 1) == s1.charAt(i - 1) && dp[i - 1][j]) {
                    dp[i][j] = true;
                } else if (s3.charAt(i + j - 1) == s2.charAt(j - 1) && dp[i][j - 1]) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[s1Len][s2Len];
    }
}
