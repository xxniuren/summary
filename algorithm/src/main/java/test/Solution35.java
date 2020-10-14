package test;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/10/13
 * @description:
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素
 **/
public class Solution35 {
    /**
     *  1 2 3 4 5
     *
     **/

    public static void main(String[] args) {
        Solution35 solution = new Solution35();
        int[] nums = {1,3,5,6};
        int target = 5;
        int index = solution.searchInsert(nums, target);
        System.out.println(index);
    }

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        //查找最后一个出现的位置
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        return end + 1;
    }
}
