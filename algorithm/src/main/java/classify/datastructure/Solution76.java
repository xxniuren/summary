package classify.datastructure;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2021/1/9
 * @description:
 **/
public class Solution76 {
    public String minWindow(String s, String t) {
        int start = 0;
        int left = -1, right = -1;
        int max = Integer.MAX_VALUE;
        int cnt = t.length();
        char[] sc = new char[256], tc = new char[256];
        for (int i = 0; i < t.length(); i++) {
            tc[t.charAt(i)]++;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sc[c]++;
            if (sc[c] <= tc[c]) cnt--;
            while (start <= i && cnt == 0) {
                char r = s.charAt(start);
                sc[r]--;
                if (sc[r] < tc[r]) cnt++;
                if (cnt > 0) {
                    if (max > i - start + 1) {
                        left = start;
                        right = i;
                        max = i - start + 1;
                    }
                }
                start++;
            }
        }
        if (left == -1) return "";
        return s.substring(left, right + 1);
    }
}
