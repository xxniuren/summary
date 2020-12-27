package classify.dp;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/12/27
 * @description:
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 * 题目数据保证答案肯定是一个 32 位的整数。
 **/
public class Solution91 {

    public static void main(String[] args) {
        Solution91 solution = new Solution91();
        String s = "12";
        int i = solution.numDecodings(s);
        System.out.println(i);
    }

    public int numDecodings(String s) {
        int len = s.length();
        if (len == 0) return 0;
        int[] dp = new int[len + 1];
        dp[0] = 1;
        char[] chars = s.toCharArray();
        dp[1] = chars[0] == '0' ? 0 : 1 ;
        for (int i = 2; i <= s.length(); i++) {
            if (chars[i - 1] != '0') {
                dp[i] = dp[i - 1];
            }
            int val = (chars[i - 2] - '0') * 10 + (chars[i - 1] - '0');
            if (val >= 10 && val <= 26) dp[i] += dp[i - 2];
        }
        return dp[len];
    }

}
