/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/5/28
 * @description:
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * 输入为 非空 字符串且只包含数字 1 和 0。
 **/
public class Solution67 {
    public static void main(String[] args) {
        Solution67 solution = new Solution67();
        System.out.println(solution.addBinary("1010", "1011"));
    }

    /**
     * 求二进制加法
     *
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        // i = len(r) - k - 1;
        for (int i = 0; i < Math.max(a.length(), b.length()); i++) {
            int ai = i < a.length() ? a.charAt(a.length() - 1 - i) - '0' : 0;
            int bi = i < b.length() ? b.charAt(b.length() - 1 - i) - '0' : 0;
            sb.append((ai + bi + carry) % 2);
            carry = (ai + bi + carry) / 2;
        }
        if (carry > 0) sb.append(carry);
        return sb.reverse().toString();
    }
}
