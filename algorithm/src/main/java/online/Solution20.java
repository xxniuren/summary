package online;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/7/29
 * @description:
 * 有效的括号, 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 1. 左括号必须用相同类型的右括号闭合。
 * 2. 左括号必须以正确的顺序闭合
 **/
public class Solution20 {

    public static void main(String[] args) {
        Solution20 solution = new Solution20();
        String s = "}";
        System.out.println(solution.isValid(s));
    }

    public boolean isValid(String s) {
        if (s == null) return false;
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            switch (c) {
                case '(':
                case '{':
                case '[':
                    list.add(c);
                    break;
                case ')':
                    if (list.isEmpty() == false && list.get(list.size() - 1) == '(') {
                        list.remove(list.size() - 1);
                        break;
                    } else {
                        return false;
                    }
                case '}':
                    if (list.isEmpty() == false && list.get(list.size() - 1) == '{') {
                        list.remove(list.size() - 1);
                        break;
                    } else {
                        return false;
                    }
                case ']':
                    if (list.isEmpty() == false && list.get(list.size() - 1) == '[') {
                        list.remove(list.size() - 1);
                        break;
                    } else {
                        return false;
                    }
                default:
                    break;
            }
        }
        return list.isEmpty();
    }

}
