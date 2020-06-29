package online;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/6/24
 * @description:
 **/
public class Solution100 {

    public static void main(String[] args) {

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (null == p && null == q) return true;
        if (null == p || null == q) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
