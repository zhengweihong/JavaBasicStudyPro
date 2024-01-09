package P02_Strategy.Comparator;

/**
 * @author : ZWH
 * @date : 2024/01/09
 * @Description : 猫重量的比较策略
 */
public class CatWeightCompareStrategy implements Comparator<Cat> {
    @Override
    public int compare(Cat o1, Cat o2) {
        if (o1.getWeight() > o2.getWeight()) {
            // o1大
            return 1;
        } else if (o1.getWeight() < o2.getWeight()) {
            return -1;
        } else {
            return 0;
        }
    }
}
