package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/4/27
 * @description:
 **/
public class Permutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;

        // 从后向前找到第一个不满足逆序的元素
        int i = nums.length - 2;
        // 注意，这里有=，可以排除含有重复元素的情况
        while (i >= 0 && nums[i] >= nums[i + 1]) i--;
        if (i >= 0) {
            // 从右往左找到第一个大于nums[i]的元素
            // 注意等号
            // 也就是从i+1开始找到最小的一个比nums[i]大的元素
            int j = nums.length - 1;
            while (nums[j] <= nums[i])
                j--;
            swap(nums, i, j);
        }
        // 如果nums是逆序，则i是-1，和下面逆置一样
        // System.out.println(i);
        // 将i之后的元素逆置
        int k = nums.length - 1;
        i++;
        for (; i < k; i++, k--)
            swap(nums, i, k);
    }

    // 交换
    public void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        int[] arrs = {1, 3, 2, 4 ,5};
        Permutation permutation = new Permutation();
        permutation.nextPermutation(arrs);
        System.out.println(Arrays.stream(arrs).boxed().collect(Collectors.toList()));
    }
}
