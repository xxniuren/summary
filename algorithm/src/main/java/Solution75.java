import java.util.HashMap;
import java.util.Map;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/5/30
 * @description:
 *
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 **/
public class Solution75 {

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        Solution75 solution = new Solution75();
        solution.sortColors(nums);
        System.out.println(nums);
    }

    public void sortColors(int[] nums) {
        if (nums.length == 0) return;
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }
        int cnt = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            for (int i = 0; i < val; i++) {
                nums[cnt] = key;
                cnt++;
            }
        }
    }
}
