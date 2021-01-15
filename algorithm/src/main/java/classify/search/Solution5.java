package classify.search;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2021/1/15
 * @description:
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 **/
public class Solution5 {

    public static void main(String[] args) {
        Solution5 solution = new Solution5();
        String s = "ac";
        String s1 = solution.longestPalindrome(s);
        System.out.println(s1);
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        if (s.length() == 1) return s;
        int left = 0, right = 0;
        int maxLen = 0;
        for (int i = 1; i < s.length(); i++) {
            int len1 = extendByCenter(s, i, i);
            int len2 = extendByCenter(s, i - 1, i);
            if (len1 >= len2) {
                if (maxLen < len1) {
                    left = i - len1 / 2;
                    right = i + len1 / 2;
                    maxLen = len1;
                }
            } else {
                if (maxLen < len2) {
                    left = i - len2 / 2;
                    right = i + len2 / 2 - 1;
                    maxLen = len2;
                }
            }
        }
        return s.substring(left, right + 1);
    }

    public int extendByCenter(String s, int left, int right) {
        int maxLen = 1;
        while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
            maxLen = right - left + 1;
            left--;
            right++;
        }
        return maxLen;
    }
}
