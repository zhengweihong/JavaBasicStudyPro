package P24_2021060860;

public class MyTreeBirdTest2 {
    /*
        有一只小鸟和两颗小树，
        同时开始其生命周期（温度序列长度相同），但各自生存环境不同（即温度序列不同），小鸟依靠吃两棵小树的叶子而存活；
        吃叶子的规则：
        叶子数多的小树多吃，能吃多少吃多少，死树的叶子也吃。
     */
    public static void main(String[] args) {
        NewMyTree treeA = new NewMyTree();
        NewMyTree treeB = new NewMyTree();
        Bird bird = new Bird();
        int[] tempTree = {12, 12, 5, 13, 24, 23, 12, 34, 23, 12, 34, 7, 5, 45, 65, 12, 12, 12, 12, 18};
        int[] tempBird = {12, 12, 5, 13, 24, 23, 22, 34, 23, 12, 34, 7, 5, 45, 65, 12, 12, 12, 12, 18};
        for (int i = 0; i < tempTree.length && (treeA.status >= 0 || treeB.status >= 0 || bird.status >= 0); i++) {
            System.out.print("今日树温：" + tempTree[i] + "度，\t");
            System.out.println("今日鸟温：" + tempBird[i] + "度。");

            int leavesNum = treeA.leaves + treeB.leaves;
            treeA.up(tempTree[i]);
            treeB.up(tempTree[i]);
            int eat = bird.up(tempBird[i], leavesNum);
            if (eat > 0) {
                if (treeA.leaves >= treeB.leaves) {//先吃A的叶子
                    if (treeA.leaves >= eat) {
                        treeA.eated(eat);
                    } else {
                        eat -= treeA.leaves;
                        treeA.eated(treeA.leaves);
                        treeB.eated(eat);
                    }
                } else {
                    if (treeB.leaves >= eat) {
                        treeB.eated(eat);
                    } else {
                        eat -= treeB.leaves;
                        treeB.eated(treeB.leaves);
                        treeA.eated(eat);
                    }
                }
            }

            System.out.println("A树："+treeA);
            System.out.println("B树："+treeB);
            System.out.println(bird);
            System.out.println();
        }
    }
}

