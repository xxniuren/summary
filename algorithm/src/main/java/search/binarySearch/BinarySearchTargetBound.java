package search.binarySearch;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/5/29
 * @description:
 *
 * 查找目标区域的左边界
 **/
public class BinarySearchTargetBound {

    public static void main(String[] args) {

        BinarySearchTargetBound bound = new BinarySearchTargetBound();
        int a[] = {1, 3, 4, 7, 7, 7, 9, 10};
        int target = 7;
        int aTarget = 7;
        System.out.println(bound.binarySearchLeftBound(a, aTarget));
        System.out.println(bound.binarySearchRightBound(a, aTarget));

        int b[] = {1, 3, 4, 7, 7, 7, 9, 10};
        int bTargetLeft = 5;
        System.out.println(bound.binarySearchLeftBound(b, bTargetLeft));
        int bTargetRight = 8;
        System.out.println(bound.binarySearchRightBound(b, bTargetRight));

        System.out.println(bound.binarySearchLastLeftLessThanTarget(a, target));
        System.out.println(bound.binarySearchFirstRightLargeThanTarget(a, target));

    }

    /**
     * 二分查找左边界，查找第一个不小于目标数的位置
     *
     * @param a
     * @param target
     * @return
     */
    public int binarySearchLeftBound(int[] a, int target) {
        int start = 0;
        int end = a.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (a[mid] >= target) end = mid - 1;
            else start = mid + 1;
        }
        return start;
    }

    /**
     * 二分查找右边界，查找最后一个不大于目标数的位置
     *
     * @param a
     * @param target
     * @return
     */
    public int binarySearchRightBound(int[] a, int target) {
        int start = 0;
        int end = a.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (a[mid] > target) end = mid - 1;
            else start = mid + 1;
        }
        return end;
    }

    /**
     * 二分查找左边界，查找第一个不小于目标数的位置
     *
     * @param a
     * @param target
     * @return
     */
    public int binarySearchLastLeftLessThanTarget(int[] a, int target) {
        int start = 0;
        int end = a.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (a[mid] >= target) end = mid - 1;
            else start = mid + 1;
        }
        return end;
    }

    /**
     * 二分查找左边界，查找最后一个不大于目标数的位置
     *
     * @param a
     * @param target
     * @return
     */
    public int binarySearchFirstRightLargeThanTarget(int[] a, int target) {
        int start = 0;
        int end = a.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (a[mid] <= target) {
                start = start + 1;
            } else {
                end = end - 1;
            }
        }
        return start;
    }

}
