package classify.dp;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/12/27
 * @description:
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和
 **/
public class Solution53 {
    // 最大子序列和
    public static void main(String[] args) {
        Solution53 solution = new Solution53();
        int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
        int max = solution.maxSubArray(nums);
        System.out.println(max);
    }

    // 动态转移方程：dp[i] = Math.max(dp[i - 1] + nums[i], nums[i])
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 0;
        dp[0] = nums[0] > 0 ? nums[0] : 0;
        for (int i = 1; i <= nums.length - 1; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = max > dp[i] ? max : dp[i];
        }
        return max;
    }

}
