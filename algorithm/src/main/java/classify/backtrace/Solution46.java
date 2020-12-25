package classify.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/12/23
 * @description:
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 **/
public class Solution46 {

    public static void main(String[] args) {
        int[] nums = {2,1,3};
        Solution46 solution = new Solution46();
        List<List<Integer>> lists = solution.permute(nums);
        System.out.println(lists.toString());
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        boolean visited[] = new boolean[nums.length];
        backtrace(lists, new ArrayList<>(), nums, visited);
        return lists;
    }

    public void backtrace(List<List<Integer>> lists, List<Integer> list, int[] nums, boolean[] visited) {
        if (list.size() == nums.length) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            list.add(nums[i]);
            visited[i] = true;
            backtrace(lists, list, nums, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}
