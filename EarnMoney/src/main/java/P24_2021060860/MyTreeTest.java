package P24_2021060860;

public class MyTreeTest {
    public static void main(String[] args) {
        MyTree tree = new MyTree();
        int[] temperatures = {12, 12, 5, 13, 24, 23, 12, 34, 23, 12, 34, 7, 5, 45, 65, 12, 12, 12, 12, 18};
        for (int i = 0; i < temperatures.length && tree.status >= 0; i++) {
            System.out.print("今日温度：" + temperatures[i] + "度，\t");
            tree.up(temperatures[i]);
            System.out.println(tree);
        }
    }
}
