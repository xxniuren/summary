/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/5/6
 * @description:
 **/
public class SearchRotateArray {

    public static void main(String[] args) {
        int[] array = {1,3};
        int target = 3;
        SearchRotateArray rotateArray = new SearchRotateArray();
        int val = rotateArray.search(array, target);
        System.out.println(val);
    }
    public int search(int[] array, int targetVal) {
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (array[mid] == targetVal) {
                return mid;
            }
            if (array[mid] < array[end]) {
                if (array[mid] < targetVal && array[end] >= targetVal) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (array[mid] > targetVal && array[start] < targetVal) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}
