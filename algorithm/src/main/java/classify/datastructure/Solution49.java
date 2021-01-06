package classify.datastructure;

import java.util.*;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2021/1/6
 * @description:
 **/
public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            List<String> list = map.getOrDefault(new String(cs), new ArrayList());
            map.put(new String(cs), list);
        }
        return new ArrayList<>(map.values());
    }
}
