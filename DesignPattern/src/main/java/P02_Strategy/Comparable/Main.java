package P02_Strategy.Comparable;

import java.util.Arrays;

/**
 * @author : ZWH
 * @date : 2024/01/07
 * @Description : 策略模式：测试
 */
public class Main {

    public static void main(String[] args) {
        Cat cat1 = new Cat(8, 8);
        Cat cat2 = new Cat(5, 5);
        Cat cat3 = new Cat(7, 7);
        Cat[] cats = {cat1, cat2, cat3};

        Sorter sorter = new Sorter();
        sorter.sort(cats);
        System.out.println(Arrays.toString(cats));
    }

}
