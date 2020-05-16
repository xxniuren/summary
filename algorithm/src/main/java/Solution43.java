/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/5/15
 * @description: 这题需要了解的是，两个数相乘可以理解为：
 *         1 2 3
 *         4 5 6
 *      -----------
 *        6  12  18
 *    5  10  15
 * 4  8  12
 * -----------------
 * 如上所叙述的加法，(0,0), (0,1)&(1,0), (0,2)&(1,1)&(2,0) 这些是要在一起相加的。
 * 该题思路不难，难点在于边界判断，太费时间了
 **/
public class Solution43 {

    public static void main(String[] args) {
        String num1 = "0";
        String num2 = "0";
        Solution43 solution = new Solution43();
        System.out.println(solution.multiply(num1, num2));
    }

    public String multiply(final String num1, final String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        char[] num1Char = num1.toCharArray();
        char[] num2Char = num2.toCharArray();
        int[] val = new int[num1.length() + num2.length() - 1];
        for (int i = num2.length() - 1; i >= 0; i--) {
            for (int j = num1.length() - 1; j >= 0; j--) {
                val[i+j] += (num1Char[j] - '0') * (num2Char[i] - '0');
            }
        }
        int carry = 0;
        StringBuffer sb = new StringBuffer();
        for (int i = val.length - 1; i >= 0; i--) {
            sb.append((carry + val[i]) % 10);
            carry = (carry + val[i]) / 10;
        }
        if (carry > 0) sb.append(carry);
        int end = sb.length() - 1;
        while (end >= 0) {
            if (sb.charAt(end) == '0') end--;
            else break;
        }
        StringBuffer nsb = new StringBuffer();
        for (int i = 0; i <= end; i++) {
            nsb.append(sb.charAt(i));
        }
        nsb.reverse();
        return nsb.toString();
    }
}
