package online;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/7/8
 * @description:
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 **/
public class Solution107 {
    //该题可以用后序遍历来计算
    List<List<Integer>> lists = new ArrayList<>();

    public static void main(String[] args) {
        Solution107 solution = new Solution107();
        TreeNode root = solution.init();
        List<List<Integer>> vals = solution.levelOrderBottom(root);
        System.out.println(vals.toString());;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        postOrder(root, 0);
        Collections.reverse(lists);
        return lists;
    }

    public void postOrder(TreeNode root, int step) {
        if (null == root) return;
        if (lists.size() <= step) lists.add(new ArrayList<>());
        postOrder(root.left, step + 1);
        postOrder(root.right, step + 1);
        lists.get(step).add(root.val);
    }

    /**
     * 功能：初始化treeNode
     * @return
     */
    private TreeNode init() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
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
