package classify.pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2021/1/14
 * @description:
 **/
public class Solution18 {

    public static void main(String[] args) {
        Solution18 solution = new Solution18();
        int nums[] = {1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> lists = solution.fourSum(nums, target);
        System.out.println(lists.toString());
    }

    // 四数之和
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) return new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length -2; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) continue;
                int twoSum = target - nums[i] - nums[j];
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int actualSum = nums[left] + nums[right];
                    if (actualSum == twoSum) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left - 1]) left++;
                        while (left < right && nums[right] == nums[right + 1]) right--;
                    } else if (actualSum < twoSum) {
                        left++;
                    } else {
                        right--;
                    }
                }

            }
        }
        return res;
    }

}
