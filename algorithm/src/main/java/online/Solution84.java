package online;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/6/4
 * @description: 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * dp[n] = Math.max(dp[n-1], Math.min(dp[n-1]/n-1, height[n]) * (n + 1), height[n])
 * 不能使用动态规划来做，无法从子序列中寻找最优解。
 **/
public class Solution84 {
    public static void main(String[] args) {
        Solution84 solution = new Solution84();
        int heights[] = new int[]{2, 1, 5, 6, 2, 3};
        System.out.println(solution.largestRectangleArea(heights));
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        for (int i = 0; i < heights.length; i++) {
            //从右往左走
            left[i] = i;
            while (left[i] - 1 >= 0 && heights[left[i] - 1] > heights[i]) {
                left[i] = left[i] - 1;
            }
        }
        int[] right = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            //从左往右走
            right[i] = i;
            while (right[i] + 1 < n && heights[right[i] + 1] > heights[i]) {
                right[i] = right[i] + 1;
            }
        }
        int res = -1;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, (right[i] - left[i] + 1) * heights[i]);
        }
        return res;
    }
}
