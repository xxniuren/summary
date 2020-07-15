package online;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/7/15
 * @description:
 *  请你来实现一个 atoi 函数，使其能将字符串转换成整数
 **/
public class Solution8 {
    public static void main(String[] args) {
        Solution8 solution = new Solution8();
        String str = "-91283472332";
        str = "";
        int res = solution.myAtoi(str);
        System.out.println(res);
    }

    public int myAtoi(String str) {
        if (str == null || str.trim().equals("")) return 0;
        str = str.trim();
        //获取第一位
        char firsChar = str.charAt(0);
        int pos = 0, symb = 1;
        long res = 0;
        if (firsChar == '+') pos = 1;
        else if (firsChar == '-') {
            pos = 1;
            symb = -1;
        }
        //循环往后遍历，直到异常退出
        for (; pos < str.length(); pos++) {
            char c = str.charAt(pos);
            if (c >= '0' && c <= '9') {
                res = res * 10 + c - '0';
                if (res > Integer.MAX_VALUE) return symb == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            } else  {
                return (int) res == res ? symb * (int) res : 0;
            }
        }
        return (int) res == res ? symb * (int) res : 0;
    }
}
