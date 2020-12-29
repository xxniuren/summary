package classify.pointer;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/12/28
 * @description:
 **/
public class Solution80 {

    public static void main(String[] args) {
        Solution80 solution = new Solution80();
        int[] nums = {1,1,1,2,2,3};
        System.out.println(solution.removeDuplicates(nums));
    }

    /**
     * 这是怎么样的解体思路呢？？？
     * 很简单，一个指针搞定，遍历顺序数组，如果当前数值比pos = 指针-2 的值大，则把指针的未知设置为当前数值；
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int p = 0;
        for (int num : nums) {
            if (p < 2 || num > nums[p - 2]) {
                nums[p++] = num;
            }
        }
        return p;
    }
}
