package online;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/7/27
 * @description:
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，
 * 使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案
 *
 **/
public class Solution16 {

    public static void main(String[] args) {
        Solution16 solution = new Solution16();
        int nums[] = {0, 1, 2};
        int target = 0;
        int sumClosest = solution.threeSumClosest(nums, target);
        System.out.println(sumClosest);
    }

    /**
     * 功能：双指针解决问题
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) return Integer.MIN_VALUE;
        Arrays.sort(nums);
        int sum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int low = i + 1;
            int heigh = nums.length - 1;
            while (low < heigh) {
                int tSum = nums[i] + nums[low] + nums[heigh];
                if (Math.abs(target - tSum) < Math.abs(target - sum)) {
                    sum = tSum;
                }
                if (tSum > target) heigh--;
                else if (tSum < target) low++;
                else return tSum;
            }
        }
        return sum;
    }

}
