package classify.datastructure;

import com.sun.jmx.snmp.SnmpNull;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2021/1/7
 * @description:
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 这道题可以帮助更好的理解贪心算法，题目要求最少的跳跃次数，那么怎么样能保证最少呢？
 * 仔细理解这句话：那就是要保证只有到你不得不跳的时候就去跳一次，只要当前位置还在你能触及的范围之内，
 * 你就选择不跳！因此我们只要记录2个变量，一个是当前次数下能触及的最大范围max1，一个是当前次数下再跳一次能触及的最大范围max2，
 * 当位置超过max1时则将当前步数加1，同时max1应该变成什么呢？显然，因为max2是max1再跳一步的最大范围，现在步数加1了，
 * 那么max1变成max2就行了。
 *
 * 题目解释：
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 使用贪心算法
 **/
public class Solution45 {

    public static void main(String[] args) {
        Solution45 solution = new Solution45();
        int[] nums = {1,1,2,1,1};
        int step = solution.jump(nums);
        System.out.println(step);
    }

    /**
     * 如果为 3，2，4，1，4
     * 此时跳跃步骤是：先在3 然后在 4 然后跳完
     * 所以是先把遍历 3，2，4，1 到1后开始考虑跳跃到4这个地方；
     * 从4 遍历 1，4后到队尾然后考虑跳跃到最后一个位置。
     * 所以理解：
     * - currReach是当前的index + nums[index]
     * - nextReach是[index, index+nums[index]]的最大 index + nums[index]
     *
     *
     *
     * 分析：开始 在 nums[0]处。
     * currReach表示当前可以跳的最远地方
     *
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int currReach = 0, nextReach = nums[0];
        int step = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > currReach) {
                step++;
                currReach = nextReach;
            }
            nextReach = i + nums[i] > nextReach ? i + nums[i] : nextReach;
        }
        return step;
    }

     public int jump1(int[] nums) {
         if (nums.length == 0) return 0;
         int step = 0;
         int currReach = 0, nextReach = nums[0];
         for (int i = 0; i < nums.length; i++) {
             if (currReach < i) {
                 // 必须要跳跃了
                 step++;
                 currReach = nextReach;
             }
             nextReach = Math.max(nextReach, (i + nums[i]));
         }
         return step;
     }



















//    public int jump(int[] nums) {
//        if (nums.length == 0) return 0;
//        int step = 0;
//        int currReach = 0, nextReach = nums[0];
//        for (int i = 0; i < nums.length; i++) {
//            if (currReach < i) {
//                // 必须要跳跃了
//                step++;
//                currReach = nextReach;
//            }
//            nextReach = Math.max(nextReach, (i + nums[i]));
//        }
//        return step;
//    }
}
