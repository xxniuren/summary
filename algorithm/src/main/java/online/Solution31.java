package online;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/9/16
 * @description:
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 **/
public class Solution31 {
    public static void main(String[] args) {
        int[] nums = {1,5,8,4,7,6,5,3,1};
        Solution31 solution = new Solution31();
        solution.nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int firstOrderIndex = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                firstOrderIndex = i;
                break;
            }
        }
        if (firstOrderIndex == -1) {
            Arrays.sort(nums);
            return;
        }
        int minLagerIndex = -1;
        int minLagerValue = Integer.MAX_VALUE;
        for (int i = nums.length - 1; i > firstOrderIndex; i--) {
            if (nums[i] > nums[firstOrderIndex] && nums[i] < minLagerValue) {
                minLagerValue = nums[i];
                minLagerIndex = i;
            }
        }
        int tmp = nums[firstOrderIndex];
        nums[firstOrderIndex] = nums[minLagerIndex];
        nums[minLagerIndex] = tmp;

        Arrays.sort(nums, firstOrderIndex + 1, nums.length);
    }
}
