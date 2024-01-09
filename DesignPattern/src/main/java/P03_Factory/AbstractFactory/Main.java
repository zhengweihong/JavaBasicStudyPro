package P03_Factory.AbstractFactory;

/**
 * @author : ZWH
 * @date : 2024/01/09
 * @Description : 工厂模式：测试
 */
public class Main {
    public static void main(String[] args) {
        // 未来只用替换具体工厂就可以了，甚至直接配置文件
        AbstractFactory factory = new HumanFactory();

        Vehicle vehicle = factory.createVehicle();
        Weapon weapon = factory.createWeapon();

        vehicle.go();
        weapon.shoot();
    }
}
