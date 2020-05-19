import java.util.ArrayList;
import java.util.List;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/5/19
 * @description: 全排列问题
 **/
public class Solution46 {

    public static void main(String[] args) {
        Solution46 solution = new Solution46();
        int[] nums = {1, 2, 3};
        System.out.println(solution.permute(nums));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        boolean[] visit = new boolean[nums.length];
        for (int i = 0; i < visit.length; i++) visit[i] = false;
        permute(res, tmp, nums, visit);
        return res;
    }

    /**
     * 注意剪枝运算，和之前一题比较类似，都是先深度遍历到最后，dfs，深度遍历，然后剪枝返回
     *
     * @param res
     * @param tmp
     * @param nums
     * @param visited
     */
    public void permute(List<List<Integer>> res, List<Integer> tmp, int[] nums, boolean[] visited) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            tmp.add(nums[i]);
            visited[i] = true;
            permute(res, tmp, nums, visited);
            visited[i] = false; //剪枝操作
            tmp.remove(tmp.size() - 1);
        }
    }
}
