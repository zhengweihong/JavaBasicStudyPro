package P24_2021060860;

/**
 * 假设还有一枚麻雀蛋，
 *
 * 20℃以上持续3天可以孵化出小麻雀（否则回到原点），
 * 麻雀
 * 前3天每天下午需要吃1片叶子，
 * 然后每天下午需要吃2片叶子，
 * 1周后每天下午需要吃3片叶子，          小树没有叶子会死掉，
 *
 * 麻雀没有叶子吃会饿死。
 */
public class Bird {
    /*
        状态：
        -1=饿死；0=未孵化；
        1=孵化第一天；2=孵化第二天；3=孵化第三天；
        4.5.6=生长前期；吃1片
        7.8.9.10=生长中期；吃2片
        11=生长后期；吃3片
     */
    int status;

    public Bird() {
        status = 0;
    }

    //返回吃掉了几片叶子
    public int up(int temperature, int leavesNum) {
        if (status < 0)
            return 0;

        if (status >= 0 && status <= 3) {
            if (temperature >= 20) {
                status++;
            } else
                status = 0;
        } else if (status > 3 && status <= 6) {
            if (leavesNum >= 1) {
                status++;
            } else {
                status = -1;
            }
        } else if (status > 6 && status <= 10) {
            if (leavesNum >= 2) {
                status++;
            } else {
                status = -1;
            }
        } else if (status > 10) {
            if (leavesNum < 3) {
                status = -1;
            }
        }

        if (status >=4 && status <=6)
            return 1;
        else if (status >=7 && status <=10)
            return 2;
        else if (status >10)
            return 3;
        return 0;
    }

    public String toString() {
        switch (status) {
            case -1:
                return "麻雀被饿死！";
            case 0:
                return "麻雀还没开始孵化！";
            case 1:
            case 2:
            case 3:
                return "孵化期第" + status + "天！";
            case 4:
            case 5:
            case 6:
                return "麻雀今天吃了1片叶子！";
            case 7:
            case 8:
            case 9:
            case 10:
                return "麻雀今天吃了2片叶子！";
            case 11:
                return "麻雀今天吃了3片叶子！";
            default:
                return "未知状态";
        }
    }
}
