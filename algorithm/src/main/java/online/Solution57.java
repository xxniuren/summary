package online;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/5/25
 * @description: 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 **/
public class Solution57 {

    public static void main(String[] args) {
        int[][] intervals = {{1, 5}};
        int[] newInterval = {2, 3};
        Solution57 solution = new Solution57();
        System.out.println(solution.insert(intervals, newInterval));
    }

    /**
     * 引用之前的排序
     * @param intervals
     * @param newInterval
     * @return
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) return new int[][]{newInterval};
        int insertIndex = binarySearch(intervals, newInterval);
        List<int[]> sortList = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (i != insertIndex) {
                sortList.add(intervals[i]);
            } else {
                if (intervals[insertIndex][0] == newInterval[0]) {
                    sortList.add(new int[]{newInterval[0], Math.max(intervals[i][1], newInterval[1])});
                } else if (intervals[insertIndex][0] < newInterval[0]){
                    sortList.add(intervals[insertIndex]);
                    sortList.add(newInterval);
                } else {
                    sortList.add(newInterval);
                    sortList.add(intervals[insertIndex]);
                }
            }
        }
        List<int[]> list = new ArrayList<>();
        list.add(sortList.get(0));
        for (int i = 1; i < sortList.size(); i++) {
            int[] last = list.remove(list.size() - 1);
            //吸收元素
            if (last[1] >= sortList.get(i)[0] && last[1] <= sortList.get(i)[1]) {
                list.add(new int[]{last[0], sortList.get(i)[1]});
                continue;
            } else if (last[1] < sortList.get(i)[0]) {
                list.add(last);
                list.add(sortList.get(i));
            } else {
                //当前元素结合是上一个元素集合的子集 不吸收
                list.add(last);
            }
        }
        return list.toArray(new int[list.size()][2]);
    }

    /**
     * 查找通过二分查找，减少时间复杂度
     * @param intervals
     * @param newInterval
     * @return
     */
    private int binarySearch(int[][] intervals, int[] newInterval) {
        int start = 0;
        int end = intervals.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (intervals[mid][0] == newInterval[0]) {
                return mid;
            }
            if (intervals[mid][0] < newInterval[0]) {
                start = mid + 1;
            } else end = mid;
        }
        return end;
    }
}
