package P05_Decorator;

/**
 * @author : ZWH
 * @date : 2024/01/10
 * @Description : 拿铁，饮料实际子类
 */
public class Latte extends Beverage {
    public Latte() {
        description = "Latte";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
