package classify.search;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2021/1/15
 * @description:
 **/
public class Solution41 {

    public static void main(String[] args) {
        Solution41 solution = new Solution41();
        int[] nums = {1};
        System.out.println(solution.firstMissingPositive(nums));
    }

    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        int[] numsCpy = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] <= nums.length) {
                numsCpy[nums[i] - 1] = 1;
            }
        }
        for (int i = 0; i < numsCpy.length; i++) {
            if (numsCpy[i] == 0) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}
