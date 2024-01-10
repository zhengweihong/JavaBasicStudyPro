package P05_Decorator;

/**
 * @author : ZWH
 * @date : 2024/01/10
 * @Description : 饮料，最顶层抽象父类
 */
public abstract class Beverage {
    String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
