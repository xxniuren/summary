package classify.search;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2021/1/15
 * @description:
 **/
public class Solution9 {

    public static void main(String[] args) {
        Solution9 solution = new Solution9();
        int x = 121;
        System.out.println(solution.isPalindrome(x));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        String s = new Integer(x).toString();
        int start = 0, end = 0;
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
        while (start >= 0 && end <= s.length() - 1 && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        if (start == -1 && end == s.length()) {
            return true;
        } else {
            return false;
        }
    }
}
