package online;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/7/14
 * @description:
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000
 **/
public class Solution5 {

    public static void main(String[] args) {
        Solution5 solution = new Solution5();
        String s = "ac";
        String str = solution.longestPalindrome(s);
        System.out.println(str);
    }

    public String longestPalindrome(String s) {
        if (s.length() == 0) return "";
        int start = 0;
        int end = 0;
        int maxLen = 0;
        for (int i = 1; i < s.length(); i++) {
            int len1 = extendByCenter(s, i, i);
            int len2 = extendByCenter(s, i - 1, i);
            if (len1 > maxLen) {
                start = i - len1 / 2;
                end = i + len1 / 2;
                maxLen = len1;
            }
            if (len2 > maxLen) {
                start = i - len2 / 2;
                end = i + len2 / 2 - 1;
                maxLen = len2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int extendByCenter(String s, int lo, int hi) {
        int maxLen = 1;
        while (lo >= 0 && hi < s.length() && s.charAt(lo) == s.charAt(hi)) {
            maxLen = hi - lo + 1;
            lo--;
            hi++;
        }
        return maxLen;
    }

}
