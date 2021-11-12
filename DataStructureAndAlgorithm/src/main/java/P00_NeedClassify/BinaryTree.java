package P00_NeedClassify;

/**
 * @author : ZWH 2021/5/11
 * @version : 1.0
 *
 * 创建、打印、先序、中序、后序
 */
public class BinaryTree {
    public static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;
        TreeNode() {}
        TreeNode(int v) {
            value = v;
        }
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);

        printBinaryTree(head,1);

        preOrder(head);
        System.out.println();
        midOrder(head);
        System.out.println();
        lastOrder(head);
    }

    public static void printBinaryTree (TreeNode treeNode,int deep) {
        if (treeNode == null) return;
        printBinaryTree(treeNode.right,deep + 1);
        for (int i = 0; i < deep; i++) {
            System.out.print("\t");
        }
        if(deep > 0) {
            System.out.print("---");
            System.out.println(treeNode.value);
        }
        printBinaryTree(treeNode.left,deep + 1);
    }

    public static void visit(TreeNode treeNode) {
        System.out.print(treeNode.value+" ");
    }

    public static void preOrder(TreeNode treeNode) {
        if (treeNode == null) return;
        visit(treeNode);
        preOrder(treeNode.left);
        preOrder(treeNode.right);
    }

    public static void midOrder(TreeNode treeNode) {
        if (treeNode == null) return;
        midOrder(treeNode.left);
        visit(treeNode);
        midOrder(treeNode.right);
    }

    public static void lastOrder(TreeNode treeNode) {
        if (treeNode == null) return;
        lastOrder(treeNode.left);
        lastOrder(treeNode.right);
        visit(treeNode);
    }
}
