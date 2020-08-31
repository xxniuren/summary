package online;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/8/18
 * @description:
 * 这题需要重点再看看
 **/
public class Solution22 {

    public static void main(String[] args) {
        Solution22 solution = new Solution22();
        List<String> res = solution.generateParenthesis(3);
        System.out.println(res.toString());
    }


    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res, "", 0, 0, n);
        return res;
    }


    /**
     *
     * @param res
     * @param s
     * @param left
     * @param right
     * @param n
     */
    public void helper(List<String> res, String s, int left, int right, int n) {
        if (left < right || left > n || right > n) return;
        if (left == n && right == n) res.add(s);
        helper(res, s + "(", left + 1, right, n);
        helper(res, s + ")", left, right + 1, n);
    }


    public List<String> generateParenthesis_(int n) {
        List<String> res = new ArrayList<>();
        helper_(res, new StringBuilder(), n, n);
        return res;
    }

    public void helper_(List<String> res, StringBuilder sb, int left, int right) {
        if (left > right || left < 0 || right < 0) return;
        if (left == 0 && right == 0) {
            res.add(sb.toString());
            return;
        }
        sb.append("(");
        helper_(res, sb, left - 1, right);
        sb.deleteCharAt(sb.length() - 1);
        sb.append(")");
        helper_(res, sb, left, right - 1);
        sb.deleteCharAt(sb.length() - 1);
    }

}
