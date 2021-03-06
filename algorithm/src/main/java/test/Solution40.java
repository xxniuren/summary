package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/7/6
 * @description:
 **/
public class Solution40 {
    public static void main(String[] args) {
        Solution40 solution = new Solution40();
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> res = solution.combinationSum2(candidates, target);
        System.out.println(res.toString());
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
                if (i > start && candidates[i] == candidates[i - 1]) continue;
                list.add(candidates[i]);
                backtrace(res, list, candidates, i + 1, remain - candidates[i]);
                list.remove(list.size() - 1);
            }
        }
    }
}

