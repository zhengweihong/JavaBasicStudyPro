package P02_Strategy.Comparator;

import java.util.Arrays;

/**
 * @author : ZWH
 * @date : 2024/01/09
 * @Description : 策略模式：测试
 */
public class Main {

    public static void main(String[] args) {
        Cat cat1 = new Cat(8, 8);
        Cat cat2 = new Cat(5, 5);
        Cat cat3 = new Cat(7, 7);
        Cat[] cats = {cat1, cat2, cat3};

        Sorter<Cat> sorter = new Sorter<>();
        sorter.sort(cats, new CatWeightCompareStrategy());
        System.out.println(Arrays.toString(cats));

        // 入参是个接口，且只有一个方法
        sorter.sort(cats, (o1, o2) ->
                Integer.compare(o1.getWeight(), o2.getWeight())
        );
        System.out.println(Arrays.toString(cats));
    }

}
