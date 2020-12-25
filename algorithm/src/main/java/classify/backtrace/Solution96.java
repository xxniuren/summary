package classify.backtrace;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/12/25
 * @description:
 **/
public class Solution96 {

    // 这道题是一个递归题，不是回溯题。不太清楚二叉搜索树的构造，暂时跳过；
    public int numTrees(int n) {
        if (n == 0 || n == 1) return 1;
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res += numTrees(i - 1) * numTrees(n - 1);
        }
        return res;
    }
}
