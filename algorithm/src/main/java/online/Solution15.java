package online;

import java.util.*;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/7/22
 * @description:
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * 1. 排序数组
 * 2. 定义三个指针 i j k
 * 3. 遍历i，将三个数组之和变成两个数组之和，两个数之和用双指针处理
 **/
public class Solution15 {

    public static void main(String[] args) {
        Solution15 solution = new Solution15();
        int nums[] = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> vals = solution.threeSum(nums);
        System.out.println(vals.toString());
    }

    /**
     * 功能：三个和相加
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> vals = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) continue;
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            //双指针
            int target = 0 - nums[i];
            int heigh = nums.length - 1;
            int low = i + 1;
            while (low < heigh) {
                int tmpVal = nums[low] + nums[heigh];
                if (tmpVal == target) {
                    List<Integer> val = Arrays.asList(nums[i], nums[low], nums[heigh]);
                    vals.add(val);
                    low++;
                    heigh--;
                    while (low < heigh && nums[low] == nums[low-1]) low++;
                    while (low < heigh && nums[heigh] == nums[heigh + 1]) heigh--;
                } else if (tmpVal < target) low++;
                else heigh--;
            }
        }
        return vals;
    }
}
