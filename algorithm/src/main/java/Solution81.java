/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/6/1
 * @description: 假设按照升序排序的数组在预先未知的某个点上进行了旋转
 **/
public class Solution81 {
    public static void main(String[] args) {
        int[] nums = {2,5,6,0,0,1,2};
        int target = 3;
        Solution81 solution = new Solution81();
        System.out.println(solution.search(nums, target));
    }

    /**
     * 功能：查询数组中是否存在目标值
     *
     * @param nums
     * @param target
     * @return
     */
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            while (left < right && nums[left] == nums[left + 1]) left++;
            while (left < right && nums[right - 1] == nums[right]) right--;
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return true;
            //左边有序
            if (nums[mid] >= nums[left]) {
                if (nums[left] <= target && target < nums[mid]) right = mid - 1;
                else left = mid + 1;
            } else {
                if (nums[mid] < target && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return false;
    }
}
