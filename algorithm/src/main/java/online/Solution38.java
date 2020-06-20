package online;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/5/11
 * @description:
 **/
public class Solution38 {

    public static void main(String[] args) {

    }

    public String countAndSay(int n) {
        if (n == 1) return "1";
        String str = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            char pre = str.charAt(0);
            for (int j = 1; j < str.length(); j++) {
                char next = str.charAt(j);
                if (pre == next) {
                    count++;
                } else {
                    sb.append(count).append(pre);
                    pre = next;
                    count = 1;
                }
            }
            sb.append(count).append(pre);
            str = sb.toString();
        }
        return str;
    }
}
