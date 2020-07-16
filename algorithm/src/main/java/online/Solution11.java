package online;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/7/16
 * @description:
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 **/
public class Solution11 {
    //两个指针：左边大于右边时，右边减一，反之左边加一
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int len = right - left;
            maxArea = Math.max(maxArea, len * Math.min(height[left], height[right]));
            if (height[left] < height[right]) left++;
            else right--;
        }
        return maxArea;
    }
}
