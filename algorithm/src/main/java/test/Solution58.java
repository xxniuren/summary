package test;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/12/12
 * @description:
 **/
public class Solution58 {

    public static void main(String[] args) {
        Solution58 solution = new Solution58();
        String s = " ";
        int index = solution.lengthOfLastWord(s);
        System.out.println(index);
    }

    // 查找最后一个单词的长度
    public int lengthOfLastWord(String s) {
        if (s.length() == 0) return 0;
        int len = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') len++;
            else if (len != 0) return len;
        }
        return len;
    }


}
