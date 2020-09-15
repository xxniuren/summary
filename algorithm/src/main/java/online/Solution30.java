package online;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/9/15
 * @description:
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序
 **/
public class Solution30 {
    public static void main(String[] args) {
        Solution30 solution = new Solution30();
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","good"};
        List<Integer> index = solution.findSubstring(s, words);
        System.out.println(index);
    }

    /**
     * 功能：查找子字符串
     *
     * @param s
     * @param words
     * @return
     * Map<String, Integer> wordsCount = new HashMap();
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words.length == 0) return res;
        int len = words.length;
        int wordSize = words[0].length();
        if (s.length() < len * wordSize) return res;
        Map<String, Integer> wordsCount = new HashMap<>();
        for (int i = 0; i < len; i++) {
            wordsCount.put(words[i], wordsCount.getOrDefault(words[i], 0) + 1);
        }
        for (int i = 0; i + len * wordSize <= s.length(); i++) {
            Map<String, Integer> wordsCountCp = new HashMap<>();
            wordsCountCp.putAll(wordsCount);
            List<String> list = new ArrayList<>();
            for (int j = i; j < i + len * wordSize; j += wordSize) {
                String str = s.substring(j, j + wordSize);
                if (wordsCountCp.containsKey(str) && wordsCountCp.get(str) > 0) {
                    list.add(str);
                    wordsCountCp.put(str, wordsCountCp.get(str) - 1);
                } else {
                    break;
                }
            }
            if (list.size() == len) res.add(i);
        }
        return res;
    }
}
