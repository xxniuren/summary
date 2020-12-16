package test;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/12/16
 * @description:
 **/
public class Solution69 {

    // 二分查找还是需要在看一下，怎么设置边界条件

    public static void main(String[] args) {
        Solution69 solution = new Solution69();
        int x = 100;
        int sqrt = solution.mySqrt(x);
        System.out.println(sqrt);
    }

    public int mySqrt(int x) {
        int min = 0;
        int max = x;
        while (max >= min) {
            int mid = (max + min) / 2;
            if (x / mid >= mid) min = mid + 1;
            else max = mid - 1;
        }
        if (x / min < min) min = min - 1;
        return min;
    }

}
