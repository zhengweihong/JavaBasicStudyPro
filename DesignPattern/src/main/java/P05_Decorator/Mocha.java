package P05_Decorator;

/**
 * @author : ZWH
 * @date : 2024/01/10
 * @Description : 摩卡，调料实际子类，装饰器
 */
public class Mocha extends CondimentDecorator {
    private Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ",Mocha";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.2;
    }
}
