package online;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/7/14
 * @description:
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 *
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 **/
public class Solution4 {
    public static void main(String[] args) {
        Solution4 solution = new Solution4();
        int num1[] = {1, 2};
        int num2[] = {3, 4};
        double val = solution.findMedianSortedArrays(num1, num2);
        System.out.println(val);
    }

    /**
     * 功能：归并排序，将数组合并成一个，然后取出中间的数值
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> sortedNums = new ArrayList<>();
        int index1 = 0, index2 = 0;
        int len1 = nums1 == null ? 0 : nums1.length;
        int len2 = nums2 == null ? 0 : nums2.length;
        while (index1 < len1 && index2 < len2) {
            if (nums1[index1] < nums2[index2]) {
                sortedNums.add(nums1[index1]);
                index1++;
            } else {
                sortedNums.add(nums2[index2]);
                index2++;
            }
        }
        while (index1 < nums1.length) {
            sortedNums.add(nums1[index1]);
            index1++;
        }
        while (index2 < nums2.length) {
            sortedNums.add(nums2[index2]);
            index2++;
        }
        if (sortedNums.size() == 0) return 0f;
        if (sortedNums.size() % 2 == 0) {
            return (sortedNums.get(sortedNums.size() / 2) + sortedNums.get(sortedNums.size() / 2 - 1)) / 2.0;
        } else {
            return sortedNums.get(sortedNums.size() / 2);
        }
    }
}
