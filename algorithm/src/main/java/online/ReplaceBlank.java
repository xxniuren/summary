package online;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/4/7
 * @description:
 **/
public class ReplaceBlank {

    public void replaceBlank(final String s) {
        int len = s.length();
        int blankNum = 0;
        char[] ch = s.toCharArray();
        for (char c : ch) {
            if (c == ' ') {
                blankNum++;
            }
        }
        int aheadPos = len;
        int backPos = len + 2 * blankNum;
        while (aheadPos >= 0) {
            if (ch[aheadPos] == ' ') {
                ch[backPos--] = '0';
                ch[backPos--] = '2';
                ch[backPos--] = '%';
            } else {
                ch[backPos--] = ch[aheadPos];
            }
            aheadPos--;
        }
        ch.toString();
    }
}
