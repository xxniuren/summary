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
        if (null == root) return new ArrayList<>();
        //利用队列来进行层序遍历
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> lists = new ArrayList<>();
        queue.offer(root);
        int cnt = 1;
        while (!queue.isEmpty()) {
            int levelCnt = 0;
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < cnt;i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                    levelCnt++;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    levelCnt++;
                }
            }
            lists.add(list);
            cnt = levelCnt;
        }
        return lists;
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
