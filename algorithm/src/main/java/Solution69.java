/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/5/29
 * @description:
 *
 *  求x的平方根
 *
 **/
public class Solution69 {

    public static void main(String[] args) {
        Solution69 solution = new Solution69();
        System.out.println(solution.mySqrt(4));
    }

    public int mySqrt(int x) {
        int min = 0;
        int max = x;
        while (max >= min) {
            int mid = (max + min) / 2;
            if (x / mid >= mid ) min = mid + 1;
            else max = mid - 1;
        }
        if (x / min < min) min--;
        return min;
    }

}
