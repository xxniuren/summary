package classify.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/12/25
 * @description:
 **/
public class Solution90 {
    public static void main(String[] args) {
        Solution90 solution = new Solution90();
        int[] nums = {1,2,2};
        List<List<Integer>> lists = solution.subsetsWithDup(nums);
        System.out.println(lists.toString());
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        backtrace(lists, new ArrayList<>(), nums, 0);
        return lists;
    }

    public void backtrace(List<List<Integer>> lists, List<Integer> list, int[] nums, int start) {
        lists.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            backtrace(lists, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }

}
