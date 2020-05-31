/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/5/31
 * @description:
 **/
public class Solution76 {

    public static void main(String[] args) {
        Solution76 solution = new Solution76();
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
    }


    public String minWindow(String s, String t) {
        int[] tmap = new int[256];
        int[] smap = new int[256]; //滑动窗口
        int start = 0;
        int left = -1;
        int right = -1;
        int len = Integer.MAX_VALUE;
        int count = t.length();
        for (int i = 0; i < t.length(); i++) tmap[t.charAt(i)]++;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            smap[c]++;
            if (smap[c] <= tmap[c]) count--;
            while (start <= i && count == 0) {
                char r = s.charAt(start);
                smap[r]--;
                if (smap[r] < tmap[r]) count++;
                if (count > 0) {
                    if (len > i - start + 1) {
                        left = start;
                        right = i;
                        len = i - start + 1;
                    }
                }
                start++;
            }
        }
        if (left == -1 ) return "";
        return s.substring(left, right + 1);
    }



















    public String minWindowBK(String s, String t) {
        int[] tmap = new int[256];
        for (int i = 0; i < t.length(); i++) tmap[t.charAt(i)]++;
        int count = t.length();
        int[] smap = new int[256];
        int left = -1, right = -1;
        int len = Integer.MAX_VALUE;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            smap[c]++;
            if (smap[c] <= tmap[c]) count--;
            while (start <= i && count == 0) {
                char h = s.charAt(start);
                smap[h]--;
                if (smap[h] <tmap[h]) count++;
                if (count > 0) {
                    if (len > i - start + 1) {
                        left = start;
                        right = i;
                        len = right - left + 1;
                    }
                }
                start++;
            }
        }
        if (left == -1) return "";
        return s.substring(left, right + 1);
    }

}
