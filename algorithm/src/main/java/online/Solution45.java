package online;

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

    /**
     * 上题可以改造为：不重复遍历，只遍历一次则可。
     * 例如：3 3 1 3 1 1 1
     *
     * 第一次：i = 0，此时 end = i, end改为 3，就是最远可以跳到index = 3 上
     * 第二次：i = 1, 此时 end = 3，max = 3+1，就是说走一步的话，下一步可以到 index = 4上
     * 第三次：i = 2, 此时 end = 3, max = 1+2 就是说走两步的话，下一步可以到index = 3上，没有到达最大化
     * 第四次：i = 3，此时 end = 3， max = 3+3 就是说走三步的话，下一步可以到index = 6上，这个是最大化，此时i=end=3了，需要做抉择，那么选择走三步，让下次可以多跳三步
     * 第五次：i = 4, 此时 end = 6，max = 7，就是说走一步的话，下一步可以到index = 7上。
     * 第六次：i = 5， 此时end = 6，max = 8，就是再走两步就退出了，所以step++；
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int end = 0;
        int max = 0;
        int step = 0;
        if (nums.length <= 1) return 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, i + nums[i]);
            if (max >= nums.length - 1) return ++step;
            if (end == i) {
                end = max;
                step++;
            }
        }
        return step;
    }


    /*当前的每一步走到最大化，就是贪心策略
    public int jumpForecast(int[] nums) {
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
    }*/



}
