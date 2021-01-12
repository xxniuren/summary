package test;


import java.util.ArrayList;
import java.util.List;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/12/22
 * @description:
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合
 *
 * 之前的组合没有指定组合的大小，例如给定n，看 n有多种组合；
 * 现在组合是指定了组合的大小，例如一个组合只有两个元素，看有多少种组合；
 *
 * 整理一下排列的解法和组合的解法，39 40 46 47 77 78
 *
 **/
public class Solution77 {

    public static void main(String[] args) {
        Solution77 solution = new Solution77();
        List<List<Integer>> res = solution.combine(4, 2);
        System.out.println(res.toString());
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = i + 1;
        backtrace(res, new ArrayList<>(), nums, k, 0);
        return res;
    }

    public void backtrace(List<List<Integer>> res, List<Integer> list, int[] nums, int k, int index) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            backtrace(res, list, nums, k, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public void combine(int n) {

    }
    // 给visited来判断是否访问过，如果访问过则跳过
    // 其中存在相同的数，需要跳过
    public void backtrace(List<List<Integer>> lists, List<Integer> list, int[] nums, boolean[] visited) {
//        lists.add(new ArrayList<>(list));
//        for (int i = 0; i < nums.length; i++) {
//            if (visited[i] || )
//        }
    }

}
