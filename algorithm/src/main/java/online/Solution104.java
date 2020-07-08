package online;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/7/1
 * @description:
 *
 * 功能：求取二叉树最大深度
 **/
public class Solution104 {

    public int maxDepth(TreeNode root) {
        return null == root ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /**
     * TreeNode
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
