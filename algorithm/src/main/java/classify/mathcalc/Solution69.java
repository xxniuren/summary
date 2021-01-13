package classify.mathcalc;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2021/1/13
 * @description:
 **/
public class Solution69 {
    /**
     * 求平方根
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if (x == 0) return 0;
        if (x == 1) return 1;
        int left = 0, right = x;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (x / mid >= mid) left = mid + 1;
            else right = mid - 1;
        }
        if (x / left < left) left--;
        return left;
    }
}
