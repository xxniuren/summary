package test;

import online.Solution4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/12/9
 * @description:
 **/
public class Solution56 {

    public static void main(String[] args) {
        Solution56 solution = new Solution56();
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] res = solution.merge(intervals);
        System.out.println(res.toString());
    }

    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len == 0) return new int[][]{};
        // 将intervals 按照左边值排序
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for (int i = 1; i < len; i++) {
            int[] last = res.remove(res.size() - 1);
            int[] curr = intervals[i];

            // 如果curr[0] > last[1] 则均放进去
            if (curr[0] > last[1]) {
                res.add(last);
                res.add(curr);
            } else if (curr[0] < last[1] && curr[1] > last[1]) {
                // 如果curr[0] < last[1] && curr[1] > last[1] 则吸收掉
                last[1] = curr[1];
                res.add(new int[]{last[0], last[1]});
            } else {
                // 其他 不做处理
                res.add(last);
            }

        }
        return res.toArray(new int[res.size()][2]);
    }
}
