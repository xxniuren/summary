package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/12/4
 * @description:
 *
 * todo：今天晚上整理一下排列的解法和组合的解法，39 40 46 47
 **/
public class Solution46 {

    public static void main(String[] args) {
        Solution46 solution = new Solution46();
        int[] nums = new int[]{1,2,3};
        System.out.println(solution.permute(nums));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        Boolean[] visit = new Boolean[nums.length];
        for (int i = 0; i < visit.length; i++) {
            visit[i] = false;
        }
        backtrack(res, tmp, nums, visit);
        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> tmp, int[] nums, Boolean[] visit) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visit[i]) continue;
            tmp.add(nums[i]);
            visit[i] = true;
            backtrack(res, tmp, nums, visit);
            tmp.remove(tmp.size() - 1);
            visit[i] = false;
        }
    }

}
