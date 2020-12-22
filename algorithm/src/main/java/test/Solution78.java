package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/12/22
 * @description:
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 **/
public class Solution78 {

    public static void main(String[] args) {
        Solution78 solution = new Solution78();
        int[] nums = {1,2,3};
        Arrays.sort(nums);
        List<List<Integer>> lists = solution.subsets(nums);
        System.out.println(lists.toString());
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        backtrace(lists, new ArrayList<>(), nums, 0);
        return lists;
    }

    public void backtrace(List<List<Integer>> lists, List<Integer> list, int[] nums, int index) {
        lists.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            backtrace(lists, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
