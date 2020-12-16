package test;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/12/4
 * @description:
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 这道题可以帮助更好的理解贪心算法，题目要求最少的跳跃次数，那么怎么样能保证最少呢？
 * 仔细理解这句话：那就是要保证只有到你不得不跳的时候就去跳一次，只要当前位置还在你能触及的范围之内，
 * 你就选择不跳！因此我们只要记录2个变量，一个是当前次数下能触及的最大范围max1，一个是当前次数下再跳一次能触及的最大范围max2，
 * 当位置超过max1时则将当前步数加1，同时max1应该变成什么呢？显然，因为max2是max1再跳一步的最大范围，现在步数加1了，
 * 那么max1变成max2就行了。
 *
 **/
public class Solution45 {

    /**
     *  你的目标是使用最少的跳跃次数到达数组的最后一个位置。
     *  这道题可以帮助更好的理解贪心算法，题目要求最少的跳跃次数，那么怎么样能保证最少呢？
     *  仔细理解这句话：那就是要保证只有到你不得不跳的时候就去跳一次，只要当前位置还在你能触及的范围之内，
     *  你就选择不跳！因此我们只要记录2个变量，一个是当前次数下能触及的最大范围max1，一个是当前次数下再跳一次能触及的最大范围max2，
     *  当位置超过max1时则将当前步数加1，同时max1应该变成什么呢？显然，因为max2是max1再跳一步的最大范围，现在步数加1了，
     *  那么max1变成max2就行了。
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        // 边界条件
        if (nums.length <= 0) return 0;
        // 总步数
        int steps = 0;
        // 当前能到达的最大距离，例如开始的时候能到达的最大距离为3
        int currReach = 0;
        // 跳一步能到达的最大距离
        int nextReach = nums[0];
        // 遍历每一个节点
        for (int i = 1; i < nums.length; i++) {
            // 如果走到的那个节点到了不得不跳跃的时候，就开始跳跃
            if (i > currReach) {
                // step+1
                steps++;
                //将下一次能跳跃的最大距离作为当前能到达的距离
                currReach = nextReach;
            }
            // 判断下一次能跳跃的最大距离
            nextReach = Math.max(nextReach, nums[i] + i);
        }
        // 返回执行结果
        return steps;
    }

}