package classify.datastructure;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2021/1/7
 * @description:
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置
 **/
public class Solution55 {

    public static void main(String[] args) {
        Solution55 solution = new Solution55();
        int[] nums = {3,2,3,0,4};
        boolean canJump = solution.canJump(nums);
        System.out.println(canJump);
    }
    // 从后往前计算，每个节点都会算一遍
    public boolean canJump(int[] nums) {
        if (nums.length == 0) return true;
        int lastIndex = nums.length - 1; // 最后一个节点的位置
        for (int i = nums.length - 2; i >= 0; i--) {
            // 贪心算法，能跳就跳
            if ((lastIndex - i) < nums[i]) {
                lastIndex = i;
            }
        }
        return lastIndex == 0;
    }
}
