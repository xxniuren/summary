package online;

import java.util.*;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/6/30
 * @description:
 **/
public class Solution103 {

    public static void main(String[] args) {
        Solution103 solution = new Solution103();
        TreeNode root = solution.initTree();
        solution.zigzagLevelOrder(root);
    }

    public TreeNode initTree() {
        TreeNode head = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        head.left = node9;
        head.right = node20;
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        node20.left = node15;
        node20.right = node7;
        return head;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> arrays = new ArrayList<>();
        if (null == root) return arrays;
        queue.offer(root);
        boolean isRightDir = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int count = queue.size();
            Integer[] ints = new Integer[size];
            while (count > 0) {
                TreeNode node = queue.poll();
                int index = isRightDir ? size - count : count - 1;
                ints[index] = node.val;
                if (null != node.left) queue.offer(node.left);
                if (null != node.right) queue.offer(node.right);
                count--;
            }
            arrays.add(Arrays.asList(ints));
            isRightDir = !isRightDir;
        }
        return arrays;
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
