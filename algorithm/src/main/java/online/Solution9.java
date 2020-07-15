package online;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/7/15
 * @description:
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数
 **/
public class Solution9 {

    public static void main(String[] args) {
        Solution9 solution = new Solution9();
        int x = 33543;
        System.out.println(solution.isPalindrome(x));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        String s = new Integer(x).toString();
        int start, end;
        if (s.length() % 2 == 0) {
            start = s.length() / 2 - 1;
            end = s.length() / 2;
        } else {
            start = s.length() / 2;
            end = s.length() / 2;
        }
        return isPalindrome(s, start, end);
    }

    public boolean isPalindrome(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        if (start == -1 && end == s.length()) return true;
        else return false;
    }

}
