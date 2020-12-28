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
