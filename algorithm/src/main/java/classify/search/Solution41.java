package classify.search;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2021/1/15
 * @description:
 **/
public class Solution41 {

    public static void main(String[] args) {
        Solution41 solution = new Solution41();
        int[] nums = {1};
        System.out.println(solution.firstMissingPositive(nums));
    }

    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        int[] numsNew = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] < numsNew.length) {
                numsNew[nums[i]] = 1;
            }
        }
        for (int i = 1; i < numsNew.length; i++) {
            if (numsNew[i] == 0) {
                return i;
            }
        }
        return numsNew.length;
    }
}
