
import java.util.ArrayList;
import java.util.List;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/4/29
 * @description:
 **/
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s.length() == 0)  return 0;
        List<Integer> stack = new ArrayList<Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && s.charAt(i) == ')' && s.charAt(stack.get(stack.size() - 1)) == '(') {
                stack.remove(stack.size() - 1);
            } else {
                stack.add(i);
            }
        }
        stack.add(s.length());
        int maxLen = 0;
        for (int i = 0; i < stack.size() - 1; i++) {
            int len = stack.get(i + 1) - stack.get(i);
            if (maxLen < len) {
                maxLen = len;
            }
        }
        return maxLen;
    }
}
