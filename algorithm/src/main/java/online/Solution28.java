package online;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/9/10
 * @description:
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 **/
public class Solution28 {

    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "issip";
        Solution28 solution = new Solution28();
        int index = solution.strStr(haystack, needle);
        System.out.println(index);
    }

    /**
     * 功能：字符串查找
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if (needle.equals("") || (haystack.equals("") && needle.equals(""))) return 0;
        if (haystack.length() < needle.length()) return -1;
        if (haystack.length() == needle.length() && haystack == needle) return 0;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (haystack.length() - i < needle.length()) return -1;
                int j = 1;
                for (; j < needle.length(); j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        break;
                    }
                }
                if (needle.length() == j) return i;
            }
        }
        return -1;
    }
}
