package online;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/7/28
 * @description:
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组
 *
 *
 **/
public class Solution18 {

    public static void main(String[] args) {
        Solution18 solution = new Solution18();
        int[] nums = {1,-2,-5,-4,-3,3,3,5};
        int target = -11;
        List<List<Integer>> vals = solution.fourSum(nums, target);
        System.out.println(vals.toString());
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        if(nums == null || nums.length < 4) return new ArrayList<>();
        List<List<Integer>> vals = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i ++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j ++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) continue;
                int low = j + 1;
                int heigh = nums.length - 1;
                while (low < heigh) {
                    int sum = nums[i] + nums[j] + nums[low] + nums[heigh];
                    if (sum == target) {
                        List<Integer> val = Arrays.asList(nums[i], nums[j], nums[low], nums[heigh]);
                        vals.add(val);
                        low++;
                        heigh--;
                        while (low < heigh && nums[low] == nums[low - 1]) low++;
                        while (low < heigh && nums[heigh] == nums[heigh + 1]) heigh--;
                    } else if (sum < target) {
                        low++;
                    } else heigh--;
                }
            }
        }
        return vals;
    }
}
