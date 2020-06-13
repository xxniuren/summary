import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/6/11
 * @description: 链表操作：
 * 深度优先遍历：
 * 前序：中左右
 * 中序：左中右
 * 后序：左右中
 * <p>
 * 广度优先遍历：按层次遍历
 **/
public class Solution94 {

    public static void main(String[] args) {

    }

    //递归操作
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> vals = new ArrayList<>();
        helper(root, vals);
        return vals;
    }

    public void helper(TreeNode node, List<Integer> vals) {
        if (node != null) {
            helper(node.left, vals);
            vals.add(node.val);
            helper(node.right, vals);
        }
    }

    //迭代
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> vals = new ArrayList<>();
        TreeNode pNode = root;
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (pNode != null || !stack.isEmpty()) {
            //左中右
            if (pNode != null) {
                stack.push(pNode);
                pNode = pNode.left;
            } else {
                pNode = stack.pop();
                vals.add(pNode.val);
                pNode = pNode.right;
            }
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
