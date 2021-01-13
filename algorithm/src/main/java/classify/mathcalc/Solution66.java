package classify.mathcalc;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2021/1/13
 * @description:
 **/
public class Solution66 {
    public int[] plusOne(int[] digits) {
        // 从低位往高位找，如果不是9 则加一返回，否则将对应值置为0
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        return newDigits;
    }
}
