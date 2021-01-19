package classify.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/12/23
 * @description:
 **/
public class Solution47 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] isVisit = new boolean[nums.length];
        backtrace(lists, new ArrayList(), nums, isVisit);
        return lists;
    }

    public void backtrace(List<List<Integer>> lists, List<Integer> list, int[] nums, boolean[] isVisit) {
        if (list.size() == nums.length) {
            lists.add(new ArrayList(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (isVisit[i] || (i > 0 && !isVisit[i - 1] && nums[i] == nums[i - 1])) {
                continue;
            }
            list.add(nums[i]);
            isVisit[i] = true;
            backtrace(lists, list, nums, isVisit);
            isVisit[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
