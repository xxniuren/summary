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
        int nums[] = {0, 0, 0};
        List<List<Integer>> lists = solution.threeSum(nums);
        System.out.println(lists.toString());
    }

    // 双指针问题
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList();
        }
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList();
        for (int i = 0; i <= nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int sub = 0 - nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == sub) {
                    lists.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left - 1] == nums[left]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (sum < sub) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return lists;
    }
}
