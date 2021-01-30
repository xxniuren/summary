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
public class Solution39 {

    public static void main(String[] args) {
        Solution39 solution = new Solution39();
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> lists = solution.combinationSum(candidates, target);
        System.out.println(lists.toString());
    }
    /**
     * @author: yushuang
     * @email: yushuang@qiyi.com
     * @date: 2020/5/12
     * @description: 这题很牛逼，用回溯法加递归法，
     * 例如这个例子： candidates = [2,3,6,7], target = 7
     * 1. 把 2拿出来 list = [2]，此时target=5，然后递归[2,3,6,7]
     * 2. 把 2继续拿出来， list=[2,2]，此时target=3，然后继续递归[2,3,6,7]
     * 3. 把 2继续拿出来，list=[2,2,2]，此时target=1， 然后继续递归[2,3,6,7]
     * 4. 把 2继续拿出来，list=[2,2,2,2]，此时target=-1，已经少于目标了，此时把最后一个2吐出来，然后回到第三步 继续查找3。
     * 5. 把 3拿出来，list=[2,2,2,3]，此时target<0，此时把最后的3吐出来，还是回到第三步，继续查找6。
     * 6. 把 6拿出来，list=[2,2,2,6]，此时target<0，此时把最后的3吐出来，还是回到第三步，继续查找7。
     * 7. 把 7拿出来，list=[2,2,2,6]，此时target<0，此时把最后的3吐出来，此时2，3，6，7都找完了，然后再吐出来一个2，并回到第2步去继续查找
     * 8. 把 3拿出来，list=[2,2,3]，此时target=0，把list加到结果中。
     * 9. 把 6拿出来，list=[2,2,6]，此时target<0，把6吐出来，继续遍历第2步骤去查询；
     * 10. 把 7 拿出来，不满足，此时回到1步骤。
     **/
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(candidates);
        backtrace(lists, new ArrayList<>(), candidates, target, 0);
        return lists;
    }

    public void backtrace(List<List<Integer>> lists, List<Integer> list, int[] candidates, int target, int index) {
        if (target == 0) {
            lists.add(new ArrayList<>(list));
            return;
        }
        if (target < 0) return;
        for (int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            backtrace(lists, list, candidates, target - candidates[i], i);
            list.remove(list.size() - 1);
        }
    }

}
