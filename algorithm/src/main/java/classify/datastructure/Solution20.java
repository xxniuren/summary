package classify.datastructure;


import java.util.ArrayList;
import java.util.List;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2021/1/9
 * @description:
 **/
public class Solution20 {

    public static void main(String[] args) {
        String s = "()[]{}";
        Solution20 solution = new Solution20();
        boolean valid = solution.isValid(s);
        System.out.println(valid);
    }

    // 手工运算
    public boolean isValid(String s) {
       if (s == null) return false;
       char[] cs = s.toCharArray();
       List<Character> list = new ArrayList<>();
       for (char c : cs) {
            switch (c) {
                case '[':
                case '{':
                case '(':
                    list.add(c);
                    break;
                case ']':
                    if (!list.isEmpty() && list.get(list.size() - 1) == '[') {
                        list.remove(list.size() - 1);
                        break;
                    }
                    return false;
                case '}':
                    if (!list.isEmpty() && list.get(list.size() - 1) == '{') {
                        list.remove(list.size() - 1);
                        break;
                    }
                    return false;
                case ')':
                    if (!list.isEmpty() && list.get(list.size() - 1) == '(') {
                        list.remove(list.size() - 1);
                        break;
                    }
                    return false;
                default:
                    return false;
            }
       }
       return list.isEmpty();
    }
}
