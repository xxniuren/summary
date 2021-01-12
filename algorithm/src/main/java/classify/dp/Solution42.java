package classify.dp;


/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/12/27
 * @description:
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水；
 **/
public class Solution42 {

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        Solution42 solution = new Solution42();
        int cap = solution.trap(height);
        System.out.println(cap);
    }

    public Integer trap(int[] height) {
        int cap = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int left = i - 1, right = i +1;
            int leftMax = 0, rightMax = 0;
            while (left >= 0) {
                leftMax = height[left] > leftMax ? height[left] : leftMax;
                left--;
            }
            while (right <= height.length - 1) {
                rightMax = height[right] > rightMax ? height[right] : rightMax;
                right++;
            }
            if (leftMax >= height[i] && rightMax >= height[i]) {
                cap += Math.min(rightMax, leftMax) - height[i];
            }
        }
        return cap;
    }

}
