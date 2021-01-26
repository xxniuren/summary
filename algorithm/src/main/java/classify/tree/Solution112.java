package classify.tree;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2021/1/26
 * @description:
 **/
public class Solution112 {

    public static void main(String[] args) {
        Solution112 solution = new Solution112();
        TreeNode head = solution.init();
        boolean hasPathSum = solution.hasPathSum(head, 0);
        System.out.println(hasPathSum);
    }



    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum - root.val == 0;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode init() {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.right = treeNode2;
        treeNode1.left = treeNode3;
        return treeNode1;
    }
}
