/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/6/1
 * @description:
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 **/
public class Solution80 {
    public static void main(String[] args) {
        Solution80 solution = new Solution80();
        int[] nums = {1,1,1,2,2,3};
        System.out.println(solution.removeDuplicates(nums));
    }

    /**
     * 一个指针iPoint表示当前移动到的位置，
     * 然后遍历数组，满足条件的数据放到指针所在位置，然后指针慢慢移动
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums) {
            if (i < 2 || n > nums[i - 2]) {
                nums[i++] = n;
            }
        }
        return i;
    }
}
