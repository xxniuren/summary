import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/5/19
 * @description: 全排列问题
 **/
public class Solution47 {

    public static void main(String[] args) {
        Solution47 solution = new Solution47();
        int[] nums = {1, 2, 1, 3};
        System.out.println(solution.permuteUnique(nums));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visit = new boolean[nums.length];
        for (int i = 0; i < visit.length; i++) visit[i] = false;
        traceback(res, tmp, nums, visit);
        return res;
    }

    /**
     * 注意剪枝运算，和之前一题比较类似，这题可以这样理解：
     * 例如 1 2 3 1这个，首先排序 1 1 2 3
     *  - 先拿出第一个1 随意排序，就是 1 在最开始的位置，通过深度优先遍历，把 1 x x x全部排序完成
     *  - 拿出第二个1，这时候排序就会和第一个1重复了，所以这块要去重复，那么条件是
     *     1. 第一个1 没有visit，就是表明在广度遍历
     *     2. 当前值 == 前一个值 即有重复
     *     3. 当前值已经visited，还是表明是广度优先遍历
     *     4. i > 0 这样 nums[i] == nums[i-1]不会越界
     *
     *
     * @param res
     * @param tmp
     * @param nums
     * @param visited
     */
    public void traceback(List<List<Integer>> res, List<Integer> tmp, int[] nums, boolean[] visited) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i > 0 && !visited[i-1] && nums[i]==nums[i-1])) continue;
            tmp.add(nums[i]);
            visited[i] = true;
            traceback(res, tmp, nums, visited);
            visited[i] = false;
            tmp.remove(tmp.size() - 1);
        }
    }
}
