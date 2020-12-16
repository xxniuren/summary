package test;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/12/16
 * @description:
 **/
public class Solution66 {

    public String addBinary(String a, String b) {
        // 记录进位
        int carry = 0;
        StringBuilder sb = new StringBuilder();
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
