package online;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/9/10
 * @description:
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 **/
public class Solution27 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,2,3};
        Solution27 solution = new Solution27();
        int len = solution.removeElement(nums, 3);
        System.out.println(len);
    }

    /**
     * 功能：移除重复元素
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int effPoint = 0;
        int currPoint = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[effPoint] == val) {
                effPoint++;
            } else {
                nums[currPoint] = nums[effPoint];
                currPoint++;
                effPoint++;
            }
        }
        return currPoint;
    }

}
