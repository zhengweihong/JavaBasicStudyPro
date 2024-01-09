package P03_Factory.AbstractFactory;

/**
 * @author : ZWH
 * @date : 2024/01/09
 * @Description : 具体工厂
 */
public class HumanFactory extends AbstractFactory {
    @Override
    Vehicle createVehicle() {
        return new Car();
    }

    @Override
    Weapon createWeapon() {
        return new Gun();
    }
}
