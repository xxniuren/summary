package online;

import java.util.Stack;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/10/5
 * @description: 最长有效括号
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 **/
public class Solution32 {

    public static void main(String[] args) {
        Solution32 solution = new Solution32();
        String s = "(()";
        int maxLen = solution.longestValidParentheses(s);
        System.out.println(maxLen);
    }
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] val = new int[s.length()];
        Stack<Integer> indexVals = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                indexVals.push(i);
            } else {
                if (indexVals.isEmpty()) {
                    continue;
                } else {
                    int index = indexVals.pop();
                    val[index] = 1;
                    val[i] = 1;
                }
            }
        }
        int maxLen = 0;
        int currLen = 0;
        for (int i = 0; i < val.length; i++) {
            if (val[i] == 1) {
                currLen++;
            } else {
                maxLen = maxLen < currLen ? currLen : maxLen;
                currLen = 0;
            }
        }
        maxLen = maxLen < currLen ? currLen : maxLen;
        return maxLen;
    }
}
