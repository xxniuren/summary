package classify.mathcalc;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2021/1/12
 * @description:
 **/
public class Solution8 {
    public int myAtoi(String str) {
        if (str == null || str.trim().length() == 0) return 0;
        str = str.trim();
        char firstChar = str.charAt(0);
        int pos = 0, symb = 1;
        if (firstChar == '+') {
            pos++;
        } else if (firstChar == '-') {
            pos++;
            symb = -1;
        }
        long res = 0;
        for (; pos < str.length(); pos++) {
            char c = str.charAt(pos);
            if (c >= '0' && c <= '9') {
                // 注意边界条件则可
                if (res * 10 + c - '0' > Integer.MAX_VALUE) return symb == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                res = res * 10 + c - '0';
            } else {
                return (int) res == res ? symb * (int) res : 0;
            }
        }
        return (int) res == res ? symb * (int) res : 0;
    }
}
