import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/5/23
 * @description:
 * 给出一个区间的集合，请合并所有重叠的区间
 **/
public class Solution56 {
    public static void main(String[] args) {
        int[][] intervals = {{1,4},{2,3}};
        Solution56 solution = new Solution56();
        System.out.println(solution.merge(intervals));
    }

    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n == 0) return new int[][]{};
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        list.add(intervals[0]);
        for (int i = 1; i < n; i++) {
            int[] last = list.remove(list.size() - 1);
            //吸收元素
            if (last[1] >= intervals[i][0] && last[1] <= intervals[i][1]) {
                list.add(new int[]{last[0], intervals[i][1]});
                continue;
            } else if (last[1] < intervals[i][0]) {
                list.add(last);
                list.add(intervals[i]);
            } else {
                //当前元素结合是上一个元素集合的子集 不吸收
                list.add(last);
            }
        }
        return list.toArray(new int[list.size()][2]);
    }

    /**
     * 功能：转换
     * @param objects
     * @return
     */
    private int[][] convert(Object[] objects) {
        int[][] val = new int[objects.length][2];
        for (int row = 0; row < objects.length; row++) {
            int[] ele = (int[]) objects[row];
            for (int col = 0; col < ele.length; col++) {
                val[row][col] = ele[col];
            }
        }
        return val;
    }
}
