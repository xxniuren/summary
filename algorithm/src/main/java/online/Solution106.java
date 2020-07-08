package online;

import java.util.Arrays;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/7/1
 * @description:
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 **/
public class Solution106 {

    public static void main(String[] args) {
        Solution106 solution = new Solution106();
        int[] inorder = new int[]{9,3,15,20,7};
        int[] postorder = new int[]{9,15,7,20,3};
        TreeNode root = solution.buildTree(inorder, postorder);
        System.out.println(root);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (0 == inorder.length || 0 == postorder.length) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        for (int i = 0; i < postorder.length; i++) {
            if (inorder[i] == postorder[postorder.length - 1]) {
                root.left = buildTree(Arrays.copyOfRange(inorder, 0, i), Arrays.copyOfRange(postorder, 0, i));
                root.right = buildTree(Arrays.copyOfRange(inorder, i + 1, inorder.length), Arrays.copyOfRange(postorder, i, postorder.length - 1));
            }
        }
        return root;
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
