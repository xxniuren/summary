package online;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/5/6
 * @description:
 **/
public class Solution33 {

    public static void main(String[] args) {
        int[] array = {1, 3};
        int target = 3;
        Solution33 solution = new Solution33();
        int val = solution.search(array, target);
        System.out.println(val);
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            //左边有序
            if (nums[mid] >= nums[left]) {
                if (nums[left] <= target && target < nums[mid]) right = mid - 1;
                else left = mid + 1;
            } else {
                if (nums[mid] < target && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return -1;
    }
}
