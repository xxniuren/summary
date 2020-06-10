/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/6/10
 * @description:
 **/
public class Solution91 {
    public static void main(String[] args) {
        Solution91 solution = new Solution91();
        String s = "226";
        System.out.println(solution.numDecodings(s));
    }

    /**
     * 用动态规划来处理，正常情况下：
     *  dp[n] = dp[n-1] + dp[n-2]
     *  如果m[n] = 0，而且 0< m[i-1] < 3，dp[n] = dp[n - 2]
     *  如果m[n] != 0，而且 m[i-1]m[i] > 26， dp[n] = dp[n-1]
     *
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        int len = s.length();
        if (len == 0) return 0;
        char[] chars = s.toCharArray();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = chars[0] == '0' ? 0 : 1;
        for (int i = 2; i <= len; i++) {
            if (chars[i - 1] != '0') dp[i] = dp[i - 1];
            int val = (chars[i - 2] - '0') * 10 + chars[i - 1] - '0';
            if (val >= 10 && val <= 26) dp[i] += dp[i-2];
        }
        return dp[len];
    }
}
