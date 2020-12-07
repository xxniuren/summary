package test;

import online.Solution4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/12/7
 * @description:
 *
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 *
 *
 **/
public class Solution47 {

    public static void main(String[] args) {
        Solution47 solution = new Solution47();
        int[] nums = new int[]{1, 2, 3, 1};
        Arrays.sort(nums);
        List<List<Integer>> res = solution.permuteUnique(nums);
        System.out.println(res);
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        boolean[] visit = new boolean[nums.length];
        for (int i = 0; i < tmp.size(); i++) visit[i] = false;
        backtrace(res, tmp, nums, visit);
        return res;
    }

    public void backtrace(List<List<Integer>> res, List<Integer> tmp, int[] nums, boolean[] visit) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //剪枝条件
            // 1. 该节点被访问过，需要跳过；
            // 2. i > 0 且 当前值等于上一个值，且上一个值没有被访问过
            if (visit[i] || ((i > 0) && (nums[i] == nums[i - 1]) && !visit[i - 1])) {
                continue;
            }
            tmp.add(nums[i]);
            visit[i] = true;
            backtrace(res, tmp, nums, visit);
            tmp.remove(tmp.size() - 1);
            visit[i] = false;
        }
    }

}
