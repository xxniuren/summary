package online;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/7/28
 * @description:
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母
 **/
public class Solution17 {

    public static void main(String[] args) {
        Solution17 solution = new Solution17();
        String digits = "23";
        List<String> res = solution.letterCombinations(digits);
        System.out.println(res.toString());
    }

    public static final Map<Character, String> map = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return new ArrayList<>();
        backtrace(res, new StringBuilder(), digits, 0);
        return res;
    }

    public void backtrace(List<String> res, StringBuilder combination, String digits, int index) {
        if (index == digits.length()) {
            res.add(combination.toString());
        } else {
            Character c = digits.charAt(index);
            String ref = map.get(c);
            for (int i = 0; i < ref.length(); i++) {
                combination.append(ref.charAt(i));
                backtrace(res, combination, digits, index + 1);
                combination.deleteCharAt(combination.length() - 1);
            }
        }
    }

}
