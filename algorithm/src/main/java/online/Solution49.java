package online;

import java.util.*;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/5/22
 * @description:
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 **/
public class Solution49 {
    public static void main(String[] args) {
        Solution49 solution49 = new Solution49();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(solution49.groupAnagrams(strs));
    }

    /**
     * 功能：通过hashMap来实现
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, ArrayList<String>> res = new HashMap<>();
        for (String str : strs) {
           char[] c = str.toCharArray();
           Arrays.sort(c);
           ArrayList<String> arrayList = res.containsKey(new String(c)) ? res.get(new String(c)) : new ArrayList<>();
           arrayList.add(str);
           res.put(new String(c), arrayList);
        }
        return new ArrayList<>(res.values());
    }
}
