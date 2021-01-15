package classify.search;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2021/1/15
 * @description:
 **/
public class Solution35 {
    public static void main(String[] args) {
        Solution35 solution = new Solution35();
        int[] nums = {1,3,5,5,5,6};
        int target = 5;
        System.out.println(solution.searchInsert(nums, target));
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right + 1;
    }
}
