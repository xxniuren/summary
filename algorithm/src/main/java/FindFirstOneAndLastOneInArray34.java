/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/5/7
 * @description:
 *
 * 在这里把二分查找 及二分查找 寻找边界问题看看。 todo：中午
 **/
public class FindFirstOneAndLastOneInArray34 {
    public static void main(String[] args) {
        int[] arrs = {1,2,3,5,8,8,9};
        int target = 8;
        FindFirstOneAndLastOneInArray34 search = new FindFirstOneAndLastOneInArray34();
        int[] res = search.findFirstOneAndLastOneInArray(arrs, target);
        int pos = search.binarySearch(arrs, 11);
        System.out.println(pos);
    }

    /**
     * 二分查找
     * @param nums
     * @param target
     * @return
     */
    public int binarySearch(final int[] nums, final int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right);
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }


    public int[] findFirstOneAndLastOneInArray(int[] nums, int target) {
        //要点：
        //查找目标值起始位置：从左往右靠，nums[mid] < target {left = mid + 1}
        //要查目标值终止位置：从右往左靠，nums[mid] > target {right = mid - 1}
        //把中间值当作浮动的，查找最左边时，浮动中间值往右逼近；查找最右边时，浮动中间值往左边逼近
        if (nums.length == 0) return new int[]{-1, -1};
        int downBound = -1;
        int upBound = -1;
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (nums[left] != target) return new int[]{-1, -1};
        downBound = left;
        left = 0;
        right = nums.length - 1;
        while (left < right) {
            mid = (left + right + 1) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        upBound = left;
        return new int[]{downBound, upBound};
    }
}
