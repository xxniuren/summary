package classify.pointer;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2021/1/1
 * @description:
 * 指针解决这个问题，每次找最大的往后排列，这样可以在原地排序
 **/
public class Solution87 {
    public static void main(String[] args) {
        Solution87 solution = new Solution87();
        int num1[] = {1,2,3,0,0,0};
        int m = 3, n = 3;
        int num2[] = {2,5,6};
        solution.merge(num1, m, num2, n);
        System.out.println(num1.toString());
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int mPos = m - 1, nPos = n - 1;
        int pos = m + n - 1;
        for (; pos >= 0; pos--) { // nPos >= 0是为了防止指针越界
            if (mPos < 0 || (nPos >= 0 && nums2[nPos] > nums1[mPos])) {
                nums1[pos] = nums2[nPos--];
            } else {
                nums1[pos] = nums1[mPos--];
            }
        }
    }
}
