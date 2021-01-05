package classify.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2021/1/5
 * @description:
 **/
public class Solution102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        //利用队列来进行层序遍历
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> vals = new ArrayList<>();
        if (null == root) return new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int cnt = queue.size();
            List<Integer> val = new ArrayList<>();
            while (cnt > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                cnt--;
                val.add(node.val);
            }
            vals.add(val);
        }
        return vals;
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
