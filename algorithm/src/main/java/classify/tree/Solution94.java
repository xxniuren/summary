package classify.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2021/1/3
 * @description: 给出根节点，求中序遍历
 * 中序遍历：左中右
 * 前序遍历：中左右
 * 后序遍历：左右中
 **/
public class Solution94 {

    public static void main(String[] args) {
        Solution94 solution = new Solution94();
        TreeNode head = solution.init();
        List<Integer> vals  = solution.inorderReaversalBacktrace(head);
        System.out.println(vals.toString());
    }

    public TreeNode init() {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.right = treeNode2;
        treeNode2.left = treeNode3;
        return treeNode1;
    }

    /**
     * 非递归处理
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> vals = new ArrayList<>();
        List<TreeNode> treeNodes = new ArrayList<>();
        TreeNode pNode = root;
        // 用 或 不是用与
        while (pNode != null || !treeNodes.isEmpty()) {
            if (null != pNode) {
                treeNodes.add(pNode);
                pNode = pNode.left;
            } else {
                pNode = treeNodes.get(treeNodes.size() - 1);
                treeNodes.remove(treeNodes.size() - 1);
                vals.add(pNode.val);
                pNode = pNode.right;
            }
        }
        return vals;
    }

    /**
     * 递归方式处理
     *
     * @param root
     * @return
     */
    public List<Integer> inorderReaversalBacktrace(TreeNode root) {
        List<Integer> vals = new ArrayList<>();
        backtrace(vals, root);
        return vals;
    }

    public void backtrace(List<Integer> vals, TreeNode root) {
        if (null != root) {
            backtrace(vals, root.left);
            vals.add(root.val);
            backtrace(vals, root.right);
        }
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
