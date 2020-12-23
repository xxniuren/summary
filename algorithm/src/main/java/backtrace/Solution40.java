package backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/12/23
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
    /**
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
     *  * 跳过循环的条件为：i > start && candidates[start] == candidates[start-1] 这个地方要用continue，不能直接用return，return的话，外层循环都不进行了，语意是：上一轮的循环已经把当前循环可能遇到的目标值获取到了，所以当前循环可以不需要执行
     *
     *  如果target是小于canidates[i]时，可以不进入递归
     *
     *  [10,1,2,7,6,1,5]
     * 8
     **/
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(candidates);
        backtrace(lists, new ArrayList<>(), candidates, target, 0);
        return lists;
    }

    public void backtrace(List<List<Integer>> lists, List<Integer> list, int[] candidates, int remain, int start) {
        // 注意一个数字只能使用一次，所以需要去重复
        if (remain < 0) {
            return;
        } else if (remain == 0) {
            lists.add(new ArrayList<>(list));
        } else {
            for (int i = start; i < candidates.length; i++) {
                // 这里先做去重判断，这里判断的意思是 如果已经用了第一个相同的数，那么第二个相同的数就不能用了
                // 例如 {1 1 6} -> 7 那么只能有一种组合 {1, 6} 在第二个1到的时候直接跳过；
                if (i > start && candidates[i - 1] == candidates[i]) {
                    continue;
                }
                list.add(candidates[i]);
                backtrace(lists, list, candidates, remain - candidates[i], i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
