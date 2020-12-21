package test;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/12/21
 * @description:
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 **/
public class Solution76 {
    public String minWindow(String s, String t) {
        // 使用滑动窗口计算，smap表示输入窗口，tmap表示比对窗口
        int[] tmap = new int[256];
        int[] smap = new int[256];
        int start = 0;
        int len = Integer.MAX_VALUE;
        int left = -1;
        int right = -1;
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
                //表明现在数据已经不是最小集了。
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
