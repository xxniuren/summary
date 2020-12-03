package test;

import online.Solution31;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/10/19
 * @description:
 *
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 **/
public class Solution39 {
    public static void main(String[] args) {
        Solution39 solution = new Solution39();
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> res = solution.combinationSum(candidates, target);
        System.out.println(res.toString());
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrace(res, new ArrayList<>(), candidates, 0, target);
        return res;
    }

    public void backtrace(List<List<Integer>> res, List<Integer> list, int[] candidates, int start, int remain) {
        if (remain < 0) {
            return;
        } else if (remain == 0) {
            res.add(new ArrayList<>(list));
            return;
        } else {
            for (int i = start; i < candidates.length && candidates[i] <= remain; i++) {
                list.add(candidates[i]);
                backtrace(res, list, candidates, i, remain - candidates[i]);
                list.remove(list.size() - 1);
            }
        }
    }
}
