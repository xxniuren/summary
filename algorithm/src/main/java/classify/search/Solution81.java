package classify.search;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/12/29
 * @description:
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 *
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 **/
public class Solution81 {

    public static void main(String[] args) {
        Solution81 solution = new Solution81();
        int nums[] = {2,5,6,0,0,1,2};
        System.out.println(solution.search(nums, 0));
    }

    // 二分查找
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        // 后面了解一下，这个什么时候用 小于等于，什么时候用小于 边界判断有什么不一致的；
        while (left <= right) {
            while (left < right && nums[left] == nums[left + 1]) left++;
            while (left < right && nums[right] == nums[right - 1]) right--;
            int mid = (left + right) / 2;
            if (nums[mid] == target) return true;
            // 左边有序
            if (nums[left] <= nums[mid]) {
                //
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
                // 右边有序
            } else {
                if (nums[right] >= target && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }

}
