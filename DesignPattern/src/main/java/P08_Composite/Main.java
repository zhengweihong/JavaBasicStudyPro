package P08_Composite;

/**
 * @author : ZWH
 * @date : 2024/01/27
 * @Description : 组合模式：测试
 */
public class Main {
    public static void main(String[] args) {
        BranchNode root = new BranchNode("root");
        BranchNode package1 = new BranchNode("package1");
        BranchNode package2 = new BranchNode("package2");
        BranchNode package21 = new BranchNode("package2-1");
        LeafNode word = new LeafNode("Word");
        LeafNode excel = new LeafNode("Excel");
        LeafNode ppt = new LeafNode("PPT");
        LeafNode html = new LeafNode("Html");

        root.add(package1);
        root.add(package2);
        package1.add(word);
        package1.add(excel);
        package2.add(package21);
        package21.add(ppt);
        package21.add(html);

        treePrint(root, 0);
    }

    private static void treePrint(Node node, int depth) {
        for (int i = 0; i < depth; i++) {
            if (i == depth - 1) {
                System.out.print("|-");
            } else {
                System.out.print("\t");
            }
        }

        node.print();

        if (node instanceof BranchNode) {
            for (Node n : ((BranchNode) node).getNodes()) {
                treePrint(n, depth + 1);
            }
        }
    }
}
