package classify.pointer;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/12/30
 * @description: 柱状图中最大的矩形
 **/
public class Solution84 {

    public static void main(String[] args) {
        Solution84 solution = new Solution84();
        int[] heights = {2, 1, 5, 6, 2, 3};
        int maxArea = solution.largestRectangleArea(heights);
        System.out.println(maxArea);
    }

    // 从两边往中间走，寻找最大的
    public int largestRectangleArea(int[] heights) {
        //Special case
        if (heights.length <= 1) return 0;
        int left = 0;
        int right = heights.length - 1;
        int maxArea = -1;
        while (left < right) {

            int minHeight = Integer.MAX_VALUE;
            for (int i = left; i <= right; i++) {
                if (minHeight > heights[i]) {
                    minHeight = heights[i];
                }
            }
            int tmpArea = (right - left + 1) * minHeight;
            maxArea = maxArea < tmpArea ? tmpArea : maxArea;

            if (heights[right] > heights[left]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

}
