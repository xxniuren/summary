package online;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/5/23
 * @description: 跳跃游戏
 **/
public class Solution55 {

    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        Solution55 solution = new Solution55();
        System.out.println(solution.canJump(nums));
    }

    /**
     * 跳跃思路：从后往前遍历数组，如果前面有数可以跳跃到最后一行，则把前面数组之后的数组删除
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (nums.length == 0) return true;
        int lastIndex = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if ((lastIndex - i) <= nums[i]) lastIndex = i;
        }
        return lastIndex == 0;
    }

}
