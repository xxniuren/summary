package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/12/11
 * @description:
 **/
public class Solution57 {

    // 后续多看一下二分查找

    public static void main(String[] args) {
        Solution57 solution = new Solution57();
        int[][] intervals = new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};
        int[][] res = solution.insert(intervals, newInterval);
        int len = res.length;
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) return new int[][]{newInterval};
        intervals = this.insertArr(intervals, newInterval);
        int len = intervals.length;
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for (int i = 1; i < len; i++) {
            int[] last = res.remove(res.size() - 1);
            int[] curr = intervals[i];

            // 如果curr[0] > last[1] 则均放进去
            if (curr[0] > last[1]) {
                res.add(last);
                res.add(curr);
            } else if (curr[0] <= last[1] && curr[1] > last[1]) {
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

    /**
     * 插入数组
     *
     * @param intervals
     * @param newInterval
     * @return
     */
    public int[][] insertArr(int[][] intervals, int[] newInterval) {
        int[][] arr = new int[intervals.length + 1][2];
        int index = 0;
        boolean isInsert = false;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] < newInterval[0] || isInsert) {
                arr[index] = intervals[i];
            } else {
                arr[index++] = newInterval;
                arr[index] = intervals[i];
                isInsert = true;
            }
            index++;
        }
        return arr;
    }

}
