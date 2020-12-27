package classify.dp;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/12/27
 * @description:
 *
 * 给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。
 *
 * 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
 *
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
 * 提示：a + b 意味着字符串 a 和 b 连接。
 *
 **/
public class Solution97 {

    public static void main(String[] args) {
        Solution97 solution = new Solution97();
        String s1 = "dbbca", s2 = "aabcc", s3 = "aadbbcbcac";
        boolean interleave = solution.isInterleave(s1, s2, s3);
        System.out.println(interleave);
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        int s1Len = s1.length();
        int s2Len = s2.length();
        int s3Len = s3.length();
        if (s1Len + s2Len != s3Len) return false;
        boolean[][] dp = new boolean[s2Len + 1][s1Len + 1];
        dp[0][0] = true;
        // 横向s1
        for (int i = 1; i <= s1Len; i++) {
            dp[0][i] = (s1.charAt(i - 1) == s3.charAt(i - 1)) && dp[0][i - 1] ? true : false;
        }
        // 纵向s2
        for (int i = 1; i <= s2Len; i++) {
            dp[i][0] = (s2.charAt(i - 1) == s3.charAt(i - 1)) && dp[i - 1][0] ? true : false;
        }

        for (int i = 1; i <= s2Len; i++) {
            for (int j = 1; j <= s1Len; j++) {
                // 如果是横向相等
                if (s3.charAt(i + j - 1) == s1.charAt(j - 1) && dp[i][j - 1]) {
                    dp[i][j] = true;
                } else if (s3.charAt(i + j - 1) == s2.charAt(i - 1) && dp[i - 1][j]) {
                    // 如果是纵向相等
                    dp[i][j] = true;
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[s2Len][s1Len];
    }

}
