package classify.pointer;

import java.util.ArrayList;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2021/1/14
 * @description:
 * 盛最多水的容器，这个是木板盛水，用夹逼准则会更好处理
 **/
public class Solution11 {

    public static void main(String[] args) {
        Solution11 solution = new Solution11();
        int height[] = {1, 1};
        System.out.println(solution.maxArea1(height));
    }

    public int maxArea(int[] height) {
        if (height == null || height.length == 0) return 0;
        int left = 0, right = height.length - 1;
        int maxArea = Integer.MIN_VALUE;
        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            maxArea = maxArea > area ? maxArea : area;
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }



    public int maxArea1(int[] height) {
        if (height == null || height.length == 0) return 0;
        if (height.length == 2) return Math.min(height[0], height[1]);
        int maxArea = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int left = i - 1, leftMax = height[i - 1];
            int leftMaxPos = i - 1, rightMaxPos = i + 1;
            for (int j = left; j >= 0; j--) {
                if (leftMax < height[j]) {
                    leftMax = height[j];
                    leftMaxPos = j;
                }
            }
            int right = i + 1, rightMax = height[i + 1];
            for (int j = right; j < height.length; j++) {
                if (rightMax < height[j]) {
                    rightMax = height[j];
                    rightMaxPos = j;
                }
            }
            int area = (rightMaxPos - leftMaxPos) * Math.min(leftMax, rightMax);
            maxArea = maxArea > area ? maxArea : area;
        }
        return maxArea;
    }
}
