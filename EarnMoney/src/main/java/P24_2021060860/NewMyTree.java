package P24_2021060860;

public class NewMyTree extends MyTree {
    //状态：-3=被鸟吃死
    public NewMyTree() {
    }

    public void eated(int leavesNum) {
        if (leaves > leavesNum) {
            leaves -= leavesNum;
        } else {
            leaves = 0;
            status = -3;
        }
    }

    public String toString() {
        switch (status) {
            case -3:
                return "小树被吃死啦！";
            case -2:
                return "小树被热死啦！还有" + leaves + "片叶子！";
            case -1:
                return "小树被冻死啦！还有" + leaves + "片叶子！";
        }
        return super.toString();
    }
}
