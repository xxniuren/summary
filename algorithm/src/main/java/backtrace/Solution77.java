package backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/12/23
 * @description:
 **/
public class Solution77 {
    public static void main(String[] args) {
        Solution77 solution = new Solution77();
        List<List<Integer>> lists = solution.combine(4, 2);
        System.out.println(lists.toString());
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lists = new ArrayList<>();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = i + 1;
        backtrace(lists, new ArrayList<>(), nums, 0, k);
        return lists;
    }

    // 全排列用visited，取部分用start
    public void backtrace(List<List<Integer>> lists, List<Integer> list, int[] nums, int start, int k) {
        if (list.size() == k) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backtrace(lists, list, nums, i + 1, k);
            list.remove(list.size() - 1);
        }
    }

}
