package online;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/5/28
 * @description:
 * 该题可以放一放，没有太大的价值；
 **/
public class Solution65 {
    public static void main(String[] args) {
        String s = "1.2f";
        Solution65 solution = new Solution65();
        System.out.println(solution.isNumber(s));
    }
    public boolean isNumber(String s) {
        if (s.contains("F") || s.contains("f") || s.contains("d") || s.contains("D")) {
            return false;
        }
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
