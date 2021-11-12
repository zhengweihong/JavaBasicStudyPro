package P24_2021060860;

/**
 * 假设有一枚树种，
 *
 * 温度达到10℃以上持续3天开始发芽，发芽2天后破土，
 * 破土后每天可长高1厘米并长出一对新叶，
 *
 * 发芽期和生长期4℃以下会冻死、10℃以下停止发芽回到原点/停止生长、60℃以上热死。
 */
public class MyTree {
    /*
        状态：-2=热死；-1=冻死；0=未发芽；
        1=发芽第一天；2=发芽第二天；3=发芽第三天；
        4=生长期
     */
    int status;
    int height;
    int leaves;

    public MyTree() {
        status = 0;
        height = 0;
        leaves = 0;
    }

    public void up(int temperature) {
        if (status < 0)
            return;
        if (status > 0 && temperature < 4) {
            status = -1;
            return;
        }
        if (status > 0 && temperature > 60) {
            status = -2;
            return;
        }

        if (status >= 0 && status <= 3) {
            if (temperature >= 10) {
                status++;
                if (status == 3) {
                    height++;
                    leaves += 2;
                }
            } else
                status = 0;
        } else if (status == 4) {
            height++;
            leaves += 2;
        }
    }

    public String toString() {
        switch (status) {
            case -2:
                return "小树被热死啦！";
            case -1:
                return "小树被冻死啦！";
            case 0:
                return "树种刚下地！";
            case 1:
                return "发芽第一天！";
            case 2:
                return "发芽第二天！";
            case 3:
                return "发芽第三天！";
            case 4:
                return "生长期第" + height + "天," + height + "cm高,有" + leaves + "片叶子！";
            default:
                return "未知状态";
        }
    }
}
