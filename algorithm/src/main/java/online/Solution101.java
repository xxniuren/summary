package online;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/6/24
 * @description:
 *
 * 判断树是否为镜像二叉树
 **/
public class Solution101 {

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode left, TreeNode right) {
        if (null == left && null == right) return true;
        if (null == left || null == right) return false;
        if (left.val == right.val) {
            return isMirror(left.left, right.right) && isMirror(left.right, right.left);
        }
        return false;
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
