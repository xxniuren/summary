package online;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/7/20
 * @description:
 * 最长前缀
 **/
public class Solution14 {
    public static void main(String[] args) {
        Solution14 solution = new Solution14();
        String[] strs = {"abcd", "abc", "abd", "ab"};
        String s = solution.longestCommonPrefix(strs);
        System.out.println(s);
    }
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        int len = this.getMaxLen(strs[0], strs);
        return strs[0].substring(0, len);
    }

    public int getMaxLen(String firstWord, String[] strs) {
        int len = 0;
        for (int i = 0; i < firstWord.length(); i++) {
            char c = firstWord.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() - 1 < i || strs[j].charAt(i) != c) {
                    return len;
                }
            }
            len++;
        }
        return len;
    }
}
