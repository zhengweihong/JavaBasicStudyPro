package InterviewQuestion;

import java.util.Stack;

/**
 * @author : ZWH
 * @Description : 二叉树，整型数据，跟到叶子一个路径元素和==n，true
 * @date : 2024/04/28
 */
public class Main5 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(4, null, null), new TreeNode(3, null, null));
        System.out.println(funciton(root, 6));
    }

    private static boolean funciton(TreeNode root, int n) {
        if (root == null) {
            return false;
        }

        Stack<NodeSum> nodeSumStack = new Stack<>();
        nodeSumStack.push(new NodeSum(root, root.data));

        while (!nodeSumStack.isEmpty()) {
            NodeSum tmp = nodeSumStack.pop();
            if (tmp.node.left != null) {
                nodeSumStack.push(new NodeSum(tmp.node.left, tmp.sum + tmp.node.left.data));
            } else if (n == tmp.sum) {
                return true;
            }
            if (tmp.node.right != null) {
                nodeSumStack.push(new NodeSum(tmp.node.right, tmp.sum + tmp.node.right.data));
            } else if (n == tmp.sum) {
                return true;
            }
        }

        return false;
    }
}

class NodeSum {
    TreeNode node;
    int sum;

    public NodeSum(TreeNode node, int sum) {
        this.node = node;
        this.sum = sum;
    }
}

class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}