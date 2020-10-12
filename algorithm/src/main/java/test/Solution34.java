package test;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/10/12
 * @description:
 * 在排序数组中查找元素的第一个和最后一个位置
 **/
public class Solution34 {

    public static void main(String[] args) {
        Solution34 solution34 = new Solution34();
        int nums[] = new int[]{2, 2};
        int[] val = solution34.searchRange(nums, 3);
        System.out.println(val[0] + "," + val[1]);
    }

    /**
     * 排序数组中寻找第一个和最后一个元素的位置
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int upper = -1, bound = -1;
        int left = 0;
        int right = nums.length - 1;
        bound = this.searchLeftIndex(nums, left, right, target);
        if (bound > nums.length - 1 || nums[bound] != target) return new int[]{-1, -1};
        left = 0;
        right = nums.length - 1;
        upper = searchRightIndex(nums, left, right, target);
        return new int[]{bound, upper};
    }

    /**
     * 功能：找到最左边的那个值
     *
     * @param nums
     * @param left
     * @param right
     * @param target
     * @return
     */
    public int searchLeftIndex(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }

    /**
     * 功能：找到最右边的那个值
     *
     * @param nums
     * @param left
     * @param right
     * @param target
     * @return
     */
    public int searchRightIndex(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return right;
    }
//    /**
//     * 排序数组中寻找第一个和最后一个元素的位置
//     * @param nums
//     * @param target
//     * @return
//     */
//    public int[] searchRange(int[] nums, int target) {
//        if (nums == null || nums.length == 0) {
//            return new int[]{-1, -1};
//        }
//        int upper = -1, bound = -1;
//        int left = 0;
//        int right = nums.length - 1;
//        bound = this.searchLeftIndex(nums, left, right, target);
//        if (bound == -1) return new int[]{-1, -1};
//        left = 0;
//        right = nums.length - 1;
//        upper = searchRightIndex(nums, left, right, target);
//        return new int[]{bound, upper};
//    }
//
//    /**
//     * 功能：找到最左边的那个值
//     *
//     * @param nums
//     * @param left
//     * @param right
//     * @param target
//     * @return
//     */
//    public int searchLeftIndex(int[] nums, int left, int right, int target) {
//        while (left <= right) {
//            int mid = (right - left) / 2 + left;
//            if (nums[mid] < target) left = mid + 1;
//            else right = mid - 1;
//        }
//        if (nums[left] != target) return -1;
//        else return left;
//    }
//
//    /**
//     * 功能：找到最右边的那个值
//     *
//     * @param nums
//     * @param left
//     * @param right
//     * @param target
//     * @return
//     */
//    public int searchRightIndex(int[] nums, int left, int right, int target) {
//        while (left <= right) {
//            int mid = (right - left) / 2 + left;
//            if (nums[mid] > target) right = mid - 1;
//            else left = mid + 1;
//        }
//        return right;
//    }
}
