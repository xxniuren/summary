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
public class Solution15 {

    public static void main(String[] args) {
        Solution15 solution = new Solution15();
        int nums[] = {-1,0,1,2,-1,-4};
        List<List<Integer>> lists = solution.threeSum(nums);
        System.out.println(lists.toString());
    }

    // 双指针问题
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int target = -1 * nums[i];
            if (target < 0) continue;
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int twoSum = nums[left] + nums[right];
                if (twoSum == target) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (twoSum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }
}
