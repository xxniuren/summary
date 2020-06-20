package online;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/5/30
 * @description:
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集
 **/
public class Solution78 {
    public static void main(String[] args) {
        Solution78 solution = new Solution78();
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> lists = solution.subsets(nums);
        System.out.println(lists.toString());
    }

    /**
     * 思路：用回溯法处理
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        backtrace(lists, new ArrayList<>(), nums, 0);
        return lists;
    }

    /**
     * 功能：回溯
     * @param lists
     * @param list
     * @param nums
     * @param index
     */
    public void backtrace(List<List<Integer>> lists, List<Integer> list, int[] nums, int index) {
        lists.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            backtrace(lists, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
