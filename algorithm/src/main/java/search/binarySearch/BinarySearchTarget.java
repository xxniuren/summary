package search.binarySearch;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/5/29
 * @description:
 **/
public class BinarySearchTarget {

    public static void main(String[] args) {
        BinarySearchTarget searchTarget = new BinarySearchTarget();
        int a[] = {1, 2, 5, 5, 6, 9};
        int target = 5;
        System.out.println(searchTarget.binarySearch(a, target));
    }


    public int binarySearch(int[] a, int target) {
        int start = 0;
        int end = a.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (a[mid] == target) return mid;
            else if (a[mid] > target) end = mid - 1;
            else start = mid + 1;
        }
        return -1;
    }

}
