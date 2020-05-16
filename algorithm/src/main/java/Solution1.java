import java.util.HashMap;
import java.util.Map;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/5/16
 * @description:
 **/
public class Solution1 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        Solution1 solution = new Solution1();
        solution.twoSum(nums, target);
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer sub = target - nums[i];
            if (map.containsKey(sub)) {
                return new int[]{map.get(sub), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}
