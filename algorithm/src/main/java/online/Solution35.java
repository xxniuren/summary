package online;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/5/8
 * @description:
 **/
public class Solution35 {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 7;
        Solution35 search = new Solution35();
        int pos = search.traverse(nums, target);
        System.out.println(pos);
    }

    public int traverse(int[] nums, int target) {
        int pos = nums.length;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] >= target) {
                pos = i;
                break;
            }
        }
        return pos;
    }

    public int binarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        if (nums[start] < target) start = start + 1;
        return start;
    }
}
