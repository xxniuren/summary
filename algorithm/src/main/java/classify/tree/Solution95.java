package classify.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2021/1/4
 * @description:
 * 这题今天中午看一下b站视频
 **/
public class Solution95 {

    public static void main(String[] args) {
        Solution95 solution = new Solution95();
        List<TreeNode> treeNodes = solution.generateTrees(3);
        System.out.println("xxx" + treeNodes.toString());
    }

    public List<TreeNode> generateTrees(int n) {
        if (n < 1) return new ArrayList<>();
        return backtrace(1, n);
    }

    /**
     * 硬记算了。
     * @param start
     * @param end
     * @return
     */
    public List<TreeNode> backtrace(int start, int end) {
        List<TreeNode> nodes = new ArrayList<>();
        if (start > end) {
            nodes.add(null);
            return nodes;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = backtrace(start, i - 1);
            List<TreeNode> right = backtrace(i + 1, end);
            // 这两层循环是构造本层子树
            for (TreeNode leftTree : left) {
                for (TreeNode rightTree : right) {
                    TreeNode iNode = new TreeNode(i);
                    iNode.left = leftTree;
                    iNode.right = rightTree;
                    nodes.add(iNode);
                }
            }
        }
        return nodes;
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
