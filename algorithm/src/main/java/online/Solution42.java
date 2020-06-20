package online;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/5/15
 * @description:
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 地址：https://leetcode-cn.com/problems/trapping-rain-water/
 * 例如：[0,1,0,2,1,0,1,3,2,1,2,1]，找特定点左边最大的和右边最大的小的，然后减去本身大小，则为该点能接到的雨水大小
 * 例如  第3个点 0， 能接到最大的水为 min(1, 3) = 1, 1-0 = 1 能接的水为单位1，
 * 对边界问题需要搞清楚，往左边和右边查找时，可以查找到最边界。
 *
 **/
public class Solution42 {

    public static void main(String[] args) {
        final Solution42 solution = new Solution42();
        final int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        final int caps = solution.dpTrap(height);
        System.out.println(caps);
    }

    public Integer trap(int[] height) {
        int caps = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int leftMax = 0, rightMax = 0;
            int left = i - 1, right = i + 1;
            while (left >= 0) {
                leftMax = height[left] > leftMax ? height[left] : leftMax;
                left--;
            }
            while (right <= height.length - 1) {
                rightMax = height[right] > rightMax ? height[right] : rightMax;
                right++;
            }
            int cap = Math.min(leftMax, rightMax) - height[i];
            caps = cap > 0 ? caps + cap : caps;
        }
        return caps;
    }

    /**
     * 这个解体思路是：加一个记忆功能，用动态规划来做，减少循环次数
     * @param height
     * @return
     */
    public Integer dpTrap(int[] height) {
        int caps = 0;
        int[][] dp = new int[height.length][2];
        for (int i = 1; i < height.length - 1; i++) {
            dp[i][0] = height[i-1] > dp[i-1][0] ? height[i-1] : dp[i-1][0];
        }
        for (int i = height.length - 2; i > 0; i--) {
            dp[i][1] = height[i+1] > dp[i+1][1] ? height[i+1] : dp[i+1][1];
        }
        for (int i = 1; i < height.length - 1; i++) {
            int cap = Math.min(dp[i][0], dp[i][1]) - height[i];
            if (cap > 0) caps += cap;
        }
        return caps;
    }

}
