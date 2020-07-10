package online;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/7/9
 * @description:
 **/
public class Solution108 {

    public static void main(String[] args) {
        Solution108 solution = new Solution108();
        int[] nums = new int[]{-10,-3,0,5,9};
        TreeNode root = solution.sortedArrayToBST(nums);
        System.out.println(root.val);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return nums == null ? null : buildTree(nums, 0, nums.length - 1);
    }

    /**
     * 功能：平衡二叉搜索树
     * 1. 左子树节点 < 根节点 < 右子树节点
     * 2. 左子树和右子树的最大深度差不超过1
     *
     * @param nums
     * @param start
     * @param end
     * @return
     */
    private TreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums, start, mid - 1);
        root.right = buildTree(nums, mid + 1, end);
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
