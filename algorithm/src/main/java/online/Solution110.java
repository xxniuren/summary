package online;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/7/10
 * @description:
 * 判断二叉树是否为平衡二叉树，中午抽时间处理一下。
 **/
public class Solution110 {

    public static void main(String[] args) {
        Solution110 solution = new Solution110();
        TreeNode root = solution.init();
        System.out.println(solution.isBalanced(root));
    }

    /**
     * 初始化
     * @return
     */
    public TreeNode init() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        return root;
    }

    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    public int height(TreeNode root) {
        if (null == root) return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight >= 0 && rightHeight >= 0 && Math.abs(leftHeight - rightHeight) <= 1) {
            return Math.max(leftHeight, rightHeight) + 1;
        } else {
            return  -1;
        }
    }

    /**
     * 树节点
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
