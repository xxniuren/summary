package classify.mathcalc;


import java.util.ArrayList;
import java.util.List;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2021/1/12
 * @description:
 *
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * 用一个指针表明现在在哪一行
 **/
public class Solution6 {

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        Solution6 solution = new Solution6();
        System.out.println(solution.convert(s, 3));
    }




    public String convert(String s, int numRows) {
        if (s == null || s.isEmpty()) return "";
        if (numRows == 1) return s;
        List<StringBuffer> buffers = new ArrayList<>();
        for (int i = 0; i < Math.min(s.length(), numRows); i++) {
            buffers.add(new StringBuffer());
        }
        int row = 0;
        boolean down = false;
        for (char c : s.toCharArray()) {
            buffers.get(row).append(c);
            if (row == 0 || row == numRows - 1) down = !down;
            row += down ? 1: -1;
        }
        String res = "";
        for (StringBuffer sb : buffers) {
            res += sb.toString();
        }
        return res;
    }
}
