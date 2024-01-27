package P08_Composite;

/**
 * @author : ZWH
 * @date : 2024/01/27
 * @Description : 叶子结点
 */
public class LeafNode extends Node {
    private String name;

    public LeafNode(String name) {
        this.name = name;
    }

    @Override
    public void print() {
        System.out.println(name);
    }
}
