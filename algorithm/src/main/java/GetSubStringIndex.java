package leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/4/26
 * @description:
 **/
public class GetSubStringIndex {
    public int[] func(String s, ArrayList<String> subStrs) {
        if (s.isEmpty() || subStrs.isEmpty()) {
            return null;
        }
        int subStrsLen = subStrs.stream().collect(Collectors.summingInt(String::length));
        for (int strIndex = 0; strIndex <= s.length() - subStrsLen; strIndex++) {
            String subStr = s.substring(strIndex, strIndex+subStrsLen);
            Queue<String> queue = new LinkedList<>(subStrs);
            int count = 0;
            while (!queue.isEmpty()) {
                // pop出来的所有单词均不满足时退出
                int queueSize = queue.size();
                while (queueSize > 0) {
                    String word = queue.poll();
                }
            }
        }
        return null;
    }
}
