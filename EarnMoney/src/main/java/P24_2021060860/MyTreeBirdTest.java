package P24_2021060860;

public class MyTreeBirdTest {
    public static void main(String[] args) {
        NewMyTree tree = new NewMyTree();
        Bird bird = new Bird();
        int[] temperatures = {12, 12, 5, 13, 24, 23, 12, 34, 23, 12, 34, 7, 5, 45, 65, 12, 12, 12, 12, 18};
        for (int i = 0; i < temperatures.length && (tree.status >= 0 || bird.status >= 0); i++) {
            System.out.print("今日温度：" + temperatures[i] + "度，\t");

            int leavesNum = tree.leaves;
            tree.up(temperatures[i]);
            int eat = bird.up(temperatures[i], leavesNum);
            if (eat > 0)
                tree.eated(eat);

            System.out.print(tree);
            System.out.println(bird);
        }
    }
}

