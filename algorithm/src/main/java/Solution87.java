/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/6/5
 * @description:
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组
 **/
public class Solution87 {
    public static void main(String[] args) {
        int[] num1 = new int[]{1,2,3,0,0,0};
        int m = 3;
        int[] num2 = new int[]{2,5,6};
        int n = 3;
        Solution87 solution = new Solution87();
        solution.merge(num1, m, num2, n);
        System.out.println(num1.toString());
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int mPoint = m - 1;
        int nPoint = n - 1;
        for (int i = m + n - 1; i >= 0; i--) {
            if (mPoint < 0) {
                nums1[i] = nums2[nPoint];
                nPoint--;
                continue;
            }
            if (nPoint < 0) {
                nums1[i] = nums1[mPoint];
                mPoint--;
                continue;
            }
            if (nums1[mPoint] >= nums2[nPoint]) {
                nums1[i] = nums1[mPoint];
                mPoint--;
            } else {
                nums1[i] = nums2[nPoint];
                nPoint--;
            }
        }
    }
}
