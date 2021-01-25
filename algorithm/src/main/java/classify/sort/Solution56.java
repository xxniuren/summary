package classify.sort;

import java.util.*;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2021/1/16
 * @description:
 **/
public class Solution56 {
    public static void main(String[] args) {
        int[][] intervals = {{1,3}, {2,6}, {8,10}, {15,18}};
        Solution56 solution = new Solution56();
        int[][] merge = solution.merge(intervals);
        System.out.println(merge.toString());
        Map<String, Object> map = new HashMap<>();
        map.put("aaa", "bbb");
    }

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[][]{};
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for (int[] interal : intervals) {
            int[] last = list.remove(list.size() - 1);
            if (last[1] < interal[0]) {
                list.add(last);
                list.add(interal);
            } else if (last[1] >= interal[0] && last[1] < interal[1]) {
                list.add(new int[]{last[0], interal[1]});
            } else {
                list.add(last);
            }
        }
        return list.toArray(new int[list.size()][2]);
    }
}
