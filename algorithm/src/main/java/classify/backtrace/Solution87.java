package classify.backtrace;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2021/1/1
 * @description:
 *
 * 给定一个字符串 s1，我们可以把它递归地分割成两个非空子字符串，从而将其表示为二叉树。
 *
 * 下图是字符串 s1 = "great" 的一种可能的表示形式。
 *
 **/
public class Solution87 {
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) return true;
        if (!equals(s1.toCharArray(), s2.toCharArray())) return false; //剪枝
        int len = s1.length();
        for (int i = 1; i < len; i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i, len), s2.substring(i, len))) {
                return true;
            }
            if (isScramble(s1.substring(0, i), s2.substring(len - i, len)) && isScramble(s1.substring(i, len), s2.substring(0, len - i))) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(char[] s1, char[] s2) {
        if (s1.length != s2.length) return false;
        int[] s1Cnt = new int[26];
        int[] s2Cnt = new int[26];
        for (char c : s1) s1Cnt[c - 'a']++;
        for (char c : s2) s2Cnt[c - 'a']++;
        for (int i = 0; i < 26; i++) {
            if (s1Cnt[i] != s2Cnt[i]) return false;
        }
        return true;
    }
}
