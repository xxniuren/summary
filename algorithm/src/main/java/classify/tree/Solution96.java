package classify.tree;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2021/1/4
 * @description:
 *
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种
 * 这题没搞太懂，二叉搜索树的构造和形成原理不清楚；
 **/
public class Solution96 {
    public int numTrees(int n) {
        if (n == 0 || n == 1) return 1;
        int res = 0;
        for (int i = 1; i<= n; i++) {
            res += numTrees(i - 1) * numTrees(n - i);
        }
        return res;
    }
}
