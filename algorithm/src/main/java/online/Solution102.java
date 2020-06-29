package online;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/6/29
 * @description:
 **/
public class Solution102 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> arrays = new ArrayList<>();
        if (null == root) return arrays;
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> array = new ArrayList<>();
            int count = queue.size();
            while (count > 0) {
                TreeNode node = queue.poll();
                array.add(node.val);
                if (null != node.left) queue.offer(node.left);
                if (null != node.right) queue.offer(node.right);
                count--;
            }
            arrays.add(array);
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
