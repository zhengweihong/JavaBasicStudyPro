package P08_Composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : ZWH
 * @date : 2024/01/27
 * @Description : 非叶子结点
 */
public class BranchNode extends Node {
    private List<Node> nodes = new ArrayList<>();
    private String name;

    public BranchNode(String name) {
        this.name = name;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    @Override
    public void print() {
        System.out.println(name);
    }

    public void add(Node node) {
        nodes.add(node);
    }
}
