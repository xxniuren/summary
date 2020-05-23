/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/5/23
 * @description: 最大子序和
 **/
public class Solution53 {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        Solution53 solution = new Solution53();
        System.out.println(solution.maxSubArray(nums));
    }

    /**
     * 查找最优解，动态转移方程：dp[i] = Math.max(dp[i-1] + nums[i], nums[i])
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 0;
        dp[0] = nums[0] > 0 ? nums[0] : 0;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = max < dp[i] ? dp[i] : max;
        }
        return max;
    }
}
