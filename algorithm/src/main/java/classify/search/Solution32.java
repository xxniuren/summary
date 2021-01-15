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
        String s = "(()";
        int val = solution.longestValidParentheses(s);
        System.out.println(val);
    }

    public int longestValidParentheses(String s) {
        if (s == null || s.isEmpty()) return 0;
        List<Integer> list = new ArrayList<>();
        int[] val = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                list.add(i);
            } else {
                if (list.isEmpty()) {
                    continue;
                } else {
                    int pre = list.get(list.size() - 1);
                    list.remove(list.size() - 1);
                    val[pre] = 1;
                    val[i] = 1;
                }
            }
        }
        int maxLen = 0;
        int len = 0;
        for (int i = 0; i < val.length; i++) {
            if (val[i] == 0) {
                maxLen = len > maxLen ? len : maxLen;
                len = 0;
            } else {
                len++;
            }
        }
        return maxLen > len ? maxLen : len;
    }
}
