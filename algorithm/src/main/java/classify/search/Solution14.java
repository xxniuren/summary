package classify.search;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2021/1/15
 * @description:
 **/
public class Solution14 {

    public static void main(String[] args) {
        Solution14 solution = new Solution14();
        String[] strs = {"flowe", "flow", "flight"};
        String s = solution.longestCommonPrefix(strs);
        System.out.println(s);
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        String fStr = strs[0];
        int cnt = 0;
        for (; cnt < fStr.length(); cnt++) {
            char c = fStr.charAt(cnt);
            for (int j = 1; j < strs.length; j++) {
                String lStr = strs[j];
                if (cnt > lStr.length() - 1) {
                    return fStr.substring(0, cnt);
                }
                if (lStr.charAt(cnt) != c) {
                    return fStr.substring(0, cnt);
                }
            }
        }
        return fStr.substring(0, cnt);
    }
}
