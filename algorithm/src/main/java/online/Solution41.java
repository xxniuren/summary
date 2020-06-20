package online;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/5/13
 * @description:
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 * 解法：
 * 1. 初始化和原数组定长的数组；
 * 2. 将原数组大于0的数 拷贝到新数组上，拷贝方式是：新数组[新数组下表 - 1] = 原数组的值
 * 3. 遍历新数组，找出数组第一个索引+1 != 下标的元素，并返回结果，如果没有的话，那么最终结果是 原数组的长度+1
 **/
public class Solution41 {

    public static void main(String[] args) {
        int[] nums = {1};
        Solution41 solution = new Solution41();
        int res = solution.firstMissingPositive(nums);
        System.out.println(res);
    }

    public int firstMissingPositive(int[] nums) {
        int[] numsCpy = new int[nums.length];
        for (int i = 0; i <= nums.length - 1; i++) {
            if (nums[i] > 0 && nums[i] <= nums.length) {
                numsCpy[nums[i] - 1] = nums[i];
            }
        }
        for (int i = 0; i <= numsCpy.length - 1; i++) {
            if (numsCpy[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}
