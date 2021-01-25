package classify.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2021/1/15
 * @description:
 * // 最长有效括号
 **/
public class Solution32 {
    public static void main(String[] args) {
        Solution32 solution = new Solution32();
        String s = ")()())";
        int val = solution.longestValidParentheses(s);
        System.out.println(val);
    }

    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        List<Integer> list = new ArrayList();
        int[] data = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                list.add(i);
            } else if (c == ')') {
                if (list.isEmpty()) {
                    continue;
                } else {
                    int index = list.get(list.size() - 1);
                    data[index] = 1;
                    data[i] = 1;
                }
            }
        }
        int maxLen = 0, len = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == 0) {
                maxLen = maxLen > len ? maxLen : len;
                len = 0;
            } else {
                len++;
            }
        }
        return maxLen > len ? maxLen : len;
    }
}
