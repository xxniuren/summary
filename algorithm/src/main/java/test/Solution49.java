package test;

import online.Solution4;

import java.util.*;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/12/8
 * @description:
 *
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串
 **/
public class Solution49 {

    public static void main(String[] args) {
        Solution49 solution = new Solution49();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = solution.groupAnagrams(strs);
        System.out.println(lists);
    }
    /**
     * 用map存放结果
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] c = str.toCharArray();
            Arrays.sort(c);
            List<String> values = res.getOrDefault(new String(c), new ArrayList<>());
            values.add(str);
            res.put(new String(c), values);
        }
        return new ArrayList<>(res.values());
    }
}
