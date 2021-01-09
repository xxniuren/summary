package classify.datastructure;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2021/1/7
 * @description:
 **/
public class Solution55 {

    public static void main(String[] args) {
        Solution55 solution = new Solution55();
        int[] nums = {3,2,1,0,4};
        boolean canJump = solution.canJump(nums);
        System.out.println(canJump);
    }
    // 从后往前计算，每个节点都会算一遍
    public boolean canJump(int[] nums) {
        if (nums.length == 0) return true;
        int lastIndex = nums.length - 1; // 最后一个节点的位置
        for (int i = nums.length - 2; i >= 0; i--) {
            if ((lastIndex - i) < nums[i]) {
                lastIndex = i;
            }
        }
        return lastIndex == 0;
    }
}
