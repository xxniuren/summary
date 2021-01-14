package classify.pointer;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2021/1/14
 * @description:
 **/
public class Solution26 {

    public static void main(String[] args) {
        Solution26 solution = new Solution26();
        int nums[] = {1, 1, 2};
        int res = solution.removeDuplicates(nums);
        System.out.println(res);
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int pos = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[pos]) {
                pos++;
                nums[pos] = nums[i];
            }
        }
        return pos + 1;
    }
}
