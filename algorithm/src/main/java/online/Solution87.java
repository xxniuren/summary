package online;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/6/6
 * @description: 给定一个字符串 s1，我们可以把它递归地分割成两个非空子字符串，从而将其表示为二叉树。
 * 就是按照
 **/
public class Solution87 {
    public static void main(String[] args) {
        Solution87 solution = new Solution87();
        String s1 = "great";
        String s2 = "rgeat";
        System.out.println(solution.isScramble(s1, s2));
    }

    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) return true;
        if (!equals(s1.toCharArray(), s2.toCharArray())) return false;
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

    /**
     * 做剪枝判断
     * @param s1
     * @param s2
     * @return
     */
    public boolean equals(char[] s1, char[] s2) {
        if (s1.length != s2.length) return false;
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        for (char cs1 : s1) s1Count[cs1 - 'a']++;
        for (char cs2 : s2) s2Count[cs2 - 'a']++;
        for (int i = 0; i < s1Count.length; i++) {
            if (s1Count[i] != s2Count[i]) return false;
        }
        return true;
    }
}
