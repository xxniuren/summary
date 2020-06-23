package online;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/6/23
 * @description:
 **/
public class Solution99 {

    TreeNode t1, t2, pre;

    /**
     * 通过二叉树进行中序遍历
     * @param root
     */
    public void recoverTree(TreeNode root) {
        helper(root);
        int tmp = t1.val;
        t1.val = t2.val;
        t2.val = tmp;
    }

    //中序遍历
    public void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        if (null != pre && pre.val > root.val) {
            if (t1 == null) t1 = pre;
            t2 = root;
        }
        pre = root;
        helper(root.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
