import java.util.ArrayList;
import java.util.List;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/6/13
 * @description: 求出所有二叉搜索树的组合
 **/
public class Solution95 {
    public static void main(String[] args) {

    }

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> treeNodes = helper(1, n);
        return treeNodes;
    }

    public List<TreeNode> helper(int start, int end) {
        List<TreeNode> nodes = new ArrayList<>();
        if (start > end) {
            nodes.add(null);
            return nodes;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftNodes = helper(start, i - 1);
            List<TreeNode> rightNodes = helper(i + 1, end);

            for (TreeNode leftNode : leftNodes) {
                for (TreeNode rightNode : rightNodes) {
                    TreeNode rootNode = new TreeNode(i);
                    rootNode.left = leftNode;
                    rootNode.right = rightNode;
                }
            }
        }
        return nodes;
    }

    /**
     * 功能：定义二叉树节点
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
