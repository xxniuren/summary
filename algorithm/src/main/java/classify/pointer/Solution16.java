package classify.pointer;

import java.util.Arrays;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2021/1/14
 * @description:
 **/
public class Solution16 {

    public static void main(String[] args) {
        Solution16 solution = new Solution16();
        int[] nums = {-3, -2, -5, 3, -4};
        int target = -1;
        int res = solution.threeSumClosest(nums, target);
        System.out.println(res);
    }

    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) return 0;
        int value = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length - 3; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int tSum = nums[i] + nums[left] + nums[right];
                value = Math.abs(value - target) > Math.abs(tSum - target) ? tSum : value;
                if (tSum == target) return tSum;
                else if (tSum < target) left++;
                else right--;
            }
        }
        return value;
    }

//    public int threeSumClosest(int[] nums, int target) {
//        if (nums == null || nums.length < 3) return Integer.MIN_VALUE;
//        Arrays.sort(nums);
//        int result = nums[0] + nums[1] + nums[2];
//        for (int i = 0; i < nums.length - 2; i++) {
//            int left = i + 1;
//            int right = nums.length - 1;
//            while (left < right) {
//                int val = nums[i] + nums[left] + nums[right];
//                if (val == target) {
//                    return target;
//                }
//                // 在这里判断离target是否最近
//                if (Math.abs(result - target) > Math.abs(val - target)) {
//                    result = val;
//                }
//                if (val > target) right--;
//                else left++;
//            }
//        }
//        return result;
//    }

}
