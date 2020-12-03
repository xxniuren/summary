package test;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/12/3
 * @description:
 *
 *
 **/
public class Solution41 {

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        Solution41 solution = new Solution41();
        int res = solution.firstMissingPositive(nums);
        System.out.println(res);
    }

    /**
     * 查找第一个丢失的正整数
     * @param nums
     * @return
     *
     * [3,4,-1,1]
     * [1, 0, 1, 1]
     *
     */
    public int firstMissingPositive(int[] nums) {
        int[] numsCpy = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] <= nums.length) {
                numsCpy[nums[i] - 1] = 1;
            }
        }
        for (int i = 0; i < numsCpy.length; i++) {
            if (numsCpy[i] != 1) {
                return i + 1;
            }
        }
        return numsCpy.length + 1;
    }
}
