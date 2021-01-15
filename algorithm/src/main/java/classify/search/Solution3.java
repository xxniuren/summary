package classify.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2021/1/15
 * @description:
 **/
public class Solution3 {

    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        String s = "abcabcbb";
        int count = solution.lengthOfLongestSubstring(s);
        System.out.println(count);
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            List<Character> list = new ArrayList();
            int j = i;
            for ( ;j < s.length(); j++) {
                if (list.contains(s.charAt(j))) {
                    break;
                }
                list.add(s.charAt(j));
            }
            maxLen = Math.max(j - i, maxLen);
        }
        return maxLen;
    }
}
