package online;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/9/9
 * @description:
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 **/
public class Solution26 {

    public static void main(String[] args) {
        Solution26 solution = new Solution26();
        int[] nums = solution.init();
        int length = solution.removeDuplicates(nums);
        System.out.println(length);
    }

    public int[] init() {
        return new int[]{0,0,1,1,1,2,2,3,3,4};
    }

    /**
     * 双指针
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int effPoint = 0;
        int currPoint = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[effPoint] == nums[currPoint]) {
                currPoint++;
            } else {
                effPoint++;
                nums[effPoint] = nums[currPoint];
                currPoint++;
            }
        }
        return ++effPoint;
    }

}
