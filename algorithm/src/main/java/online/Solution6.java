package online;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/7/14
 * @description:
 *
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列
 **/
public class Solution6 {

    public static void main(String[] args) {
        String s = "LEETCODEISHIRING";
        int numRows = 3;
        Solution6 solution = new Solution6();
        String cs = solution.convert(s, numRows);
        System.out.println(cs);
    }

    public String convert(String s, int numRows) {
        if (s == null || s.isEmpty()) return "";
        if (numRows == 1) return s;
        List<StringBuffer> lists = new ArrayList<>();
        for (int i = 0; i < Math.min(s.length(), numRows); i++) {
            lists.add(new StringBuffer());
        }
        int curPos = 0;
        boolean down = false;
        for (char c : s.toCharArray()) {
            lists.get(curPos).append(c);
            if (curPos == 0 || curPos == numRows - 1) down = !down;
            curPos += down ? 1 : -1;
        }
        String res = "";
        for (int i = 0; i < lists.size(); i++) {
            res += lists.get(i).toString();
        }
        return res;
    }
}
