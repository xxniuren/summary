import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/6/7
 * @description:
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 **/
public class Solution90 {

    public static void main(String[] args) {
        //回溯法处理
        int[] nums = {1,2,2};
        Solution90 solution = new Solution90();
        List<List<Integer>> lists = solution.subsetsWithDup(nums);
        System.out.println(lists);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        helper(lists, list, nums, 0);
        return lists;
    }



    /**
     * 排序加剪枝，组合 i = tmp, 排列 i = 0，这点需要注意
     *
     * @param lists
     * @param list
     * @param nums
     * @param index
     */
    private void helper(List<List<Integer>> lists, List<Integer> list, int[] nums, int index) {
        lists.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            helper(lists, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }



}
