package classify.pointer;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2021/1/14
 * @description:
 **/
public class Solution27 {

    public static void main(String[] args) {
        Solution27 solution = new Solution27();
        int nums[] = {3,2,2,3};
        int val = 3;
        System.out.println(solution.removeElement(nums, val));
    }

    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (val != nums[i]) {
                nums[pos] = nums[i];
                pos++;
            }
        }
        return pos;
    }
}
