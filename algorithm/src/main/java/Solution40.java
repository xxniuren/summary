import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/5/13
 * @description:
 *
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *  * 用回溯法加递归法，这题需要注意去重
 *  * 例如这个例子： candidates = [1,1,2,5,6,7,10], target = 8
 *  * 1. 把 1拿出来 list = [1]，此时target=7，然后递归[1,2,5,6,7,10]
 *  * 2. 把 1拿出来， list=[1,1]，此时target=6，然后继续递归[2,5,6,7,10]
 *  * 3. 把 2拿出来，list=[1,1,2]，此时target=4， 然后继续递归[5,6,7,10]
 *  * 4. 查看到target < 5时，此时把2吐出来。
 *  * 5. 把 5拿出来，list=[1,1,5]，此时递归[6,7,10]。
 *  * 6. 查看到target < 6时，把5吐出来，重新到[1,1]。
 *  * 7. 把 6拿出来，此时target == 目标值，*********第一个结果 [1,1,6]
 *  * 8. 把 1拿出来，此时重新递归[2,5,6,7,10]
 *  * 9. 把 2拿出来，此时递归[5,6,7,10]。
 *  * 10. 把 5拿出来，******************************第二个结果[1,2,5]
 *  * 11. 把 2吐出来，递归[5,6,7,10]，***************第三个结果[1,7]
 *  * 12. 把 1吐出来，此时队列中没有数据，i = 1的循环，此时start=0，循环数组为，由于上一个数组的值也是1，所以跳过这轮循环：[1,2,5,6,7,10]
 *  * 跳过循环的条件为：i > start && candidates[start] == candidates[start-1]，语意是：上一轮的循环已经把当前循环可能遇到的目标值获取到了，所以当前循环可以不需要执行
 *
 *  如果target是小于canidates[i]时，可以不进入递归
 *
 *  [10,1,2,7,6,1,5]
 * 8
 **/
public class Solution40 {

    public static void main(String[] args) {
        Solution40 solution40 = new Solution40();
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> res = solution40.combinationSum2(candidates, target);
        System.out.println(res);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrace(candidates, res, new ArrayList<>(), 0, target);
        return res;
    }


    public void backtrace(int[] candidates, List<List<Integer>> res, List<Integer> list, int start, int remain) {
        if (remain < 0) return;
        if (remain == 0) res.add(new ArrayList<>(list));
        for (int i = start; i < candidates.length && remain >= candidates[i]; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            list.add(candidates[i]);
            backtrace(candidates, res, list, i + 1, remain - candidates[i]);
            list.remove(list.size() - 1);
        }
    }
}
