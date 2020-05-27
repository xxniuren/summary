/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/5/27
 * @description:
 **/
public class Solution66 {

    public static void main(String[] args) {
        Solution66 solution = new Solution66();
        System.out.println(solution.plusOne(new int[]{9}));
    }

    /**
     *
     *
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        //全是9，返回
        int[] tmp = new int[digits.length + 1];
        tmp[0] = 1;
        return digits;
    }
}
