package test;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/12/16
 * @description:
 **/
public class Solution65 {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                // 退出出口
                digits[i]++;
                return digits;
            }
            // 这里将是9的那位设置为0
            digits[i] = 0;
        }
        // 全是9 则新增一位。
        int[] tmp = new int[digits.length + 1];
        tmp[0] = 1;
        return tmp;
    }
}
