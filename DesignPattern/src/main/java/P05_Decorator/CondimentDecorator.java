package P05_Decorator;

/**
 * @author : ZWH
 * @date : 2024/01/10
 * @Description : 调料，子抽象类，所有装饰器父类
 */
public abstract class CondimentDecorator extends Beverage {
    @Override
    public abstract String getDescription();
}
