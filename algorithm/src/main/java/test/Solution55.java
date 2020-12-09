package test;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/12/9
 * @description:
 **/
public class Solution55 {

    public static void main(String[] args) {
        Solution55 solution = new Solution55();
        int nums[] = {3,2,1,0,4};
        boolean canJump = solution.canJump(nums);
        System.out.println(canJump);
    }
    // 判断lastIndex - i <= nums[i] 是的话则更新lastIndex
    public boolean canJump(int[] nums) {
        if (nums.length == 0) return true;
        int lastIndex = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (lastIndex - i <= nums[i]) lastIndex = i;
        }
        return lastIndex == 0;
    }

}
