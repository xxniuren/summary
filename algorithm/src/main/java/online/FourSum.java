package online;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/1/19
 * @description:
 **/
public class FourSum {

    public static void main(String[] args) throws Exception {
        int[] nums = {0,0,0,0};
        Arrays.sort(nums);
        int target = 0;
        List<List<Integer>> res = new ArrayList<>();
        for (int i=0; i<=nums.length-4;i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
//                continue;
            }
            for(int j=i+3; j<nums.length; j++) {
                if (j>1&& nums[j]==nums[j-1]) {
//                    continue;
                }
                int p=i+1,q=j-1;
                while (p < q) {
                    int tmp = nums[i] + nums[j] + nums[p] + nums[q];
                    if (tmp==target) {
                        List<Integer> part = new ArrayList<>();
                        part.add(nums[i]);
                        part.add(nums[j]);
                        part.add(nums[p]);
                        part.add(nums[q]);
                        res.add(part);
                        p++;
                        q--;
                        continue;
                    }
                    if (tmp < target) p++;
                    else q--;
                }
            }
        }
        System.out.println(res);
    }

}
