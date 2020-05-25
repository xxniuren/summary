/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/5/25
 * @description:
 **/
public class Solution58 {
    public static void main(String[] args) {
        Solution58 solution = new Solution58();
        System.out.println(solution.lengthOfLastWord("Hello World"));
    }

    public int lengthOfLastWord(String s) {
        if (s.length() == 0) return 0;
        int spaceCnt = s.length() - 1;
        for (; spaceCnt >= 0; spaceCnt--) {
            if (s.charAt(spaceCnt) != ' ') break;
        }
        for (int i = spaceCnt; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                return spaceCnt - i;
            }
        }
        return spaceCnt + 1;
    }
}
