package P03_Factory.AbstractFactory;

/**
 * @author : ZWH
 * @date : 2024/01/09
 * @Description : 抽象工厂
 */
public abstract class AbstractFactory {
    abstract Vehicle createVehicle();

    abstract Weapon createWeapon();
}
