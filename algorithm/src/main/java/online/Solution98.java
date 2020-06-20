package online;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/6/20
 * @description:
 *
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 **/
public class Solution98 {

    public static void main(String[] args) {

    }

    /**
     * 通过递归来实现
     * 判断每一颗树是否为二叉树，
     * 1. 判断 root的left是否为空，为空返回true;
     * 2. 判断 root的left的值是否小于 root的值，不小于 直接返回false，否则进一步递归到root.left上；
     * 3. 判断 root的right的值是否大雨 root的值，不大于 直接返回false，否则进一步递归到root.right上；
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    public boolean helper(TreeNode root, TreeNode min, TreeNode max) {
        if (null == root) return true;
        if (null != min && root.val <= min.val) return false;
        if (null != max && root.val >= max.val) return false;
        return helper(root.left, min, root) && helper(root.right, root, max);
    }


    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

}
