package test;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/12/3
 * @description:
 **/
public class Solution42 {

    /**
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution42 solution = new Solution42();
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int caps = solution.trap(height);
        System.out.println(caps);
    }

    /**
     * 算法思路：遍历每一个点，然后从该点前后找，找到左边做大的柱和右边最大的柱，取两个柱中较小的柱，如果该柱比当前的柱大，那么证明当前的柱可以存放水(maxMin - height[i])
     *
     * @param height
     * @return
     */
    public Integer trap(int[] height) {
        int caps = 0;
        for (int i = 1; i < height.length - 1; i++) {
            // currPos
            // 从currPos - 1往左边找，找到最大的值，currPos + 1 往右边找，找到最大的值，当前雨水大小为：min(leftMax, rightMax) - currHeight

            int leftMax = 0, rightMax = 0;
            int left = i - 1, right = i + 1;

            while (left >= 0) {
                leftMax = height[left] > leftMax ? height[left] : leftMax;
                left--;
            }

            while (right <= height.length - 1) {
                rightMax = height[right] > rightMax ? height[right] : rightMax;
                right++;
            }

            int minMax = Math.min(leftMax, rightMax);
            caps = (minMax < height[i]) ? caps : caps + minMax - height[i];
        }
        return caps;
    }

}
