/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/5/18
 * @description: 跳跃游戏
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置
 **/
public class Solution45 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1};
        Solution45 solution = new Solution45();
        System.out.println(solution.jump(nums));
    }

    //当前的每一步走到最大化，就是贪心策略
    public int jump(int[] nums) {
        int i = 0;
        int step = 0;
        while (i < nums.length - 1) {
            if (nums[i] >= (nums.length -i - 1)) return ++step;
            int curr = i;
            int max = 0;
            int index = curr;
            for (int j = curr + 1; j < nums.length && j <= curr + nums[i]; j++) {
                int max_ = j - curr + nums[j];
                if (max_ > max) {
                    index = j;
                    max = max_;
                }
            }
            i = index;
            step++;
        }
        return step;
    }

}
