package P05_Decorator;

/**
 * @author : ZWH
 * @date : 2024/01/10
 * @Description : 装饰器模式：测试
 */
public class Main {
    public static void main(String[] args) {
        // 核心拿铁
        Beverage beverage = new Latte();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        beverage = new Mocha(beverage);
        beverage = new Mocha(beverage);
        System.out.println(beverage.getDescription() + " $" + beverage.cost());
    }
}
