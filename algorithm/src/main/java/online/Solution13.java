package online;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/7/20
 * @description:
 **/
public class Solution13 {

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap(){
            {
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }
        };

        int res = 0;
        int last = 0;
        int now = 0;
        for (int len = s.length() - 1; len >= 0; len--) {
            now = map.getOrDefault(s.charAt(len), -1);
            res = now < last ? res - now : res + now;
            last = now;
        }
        return res;
    }

}
