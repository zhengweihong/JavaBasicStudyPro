package P03_Factory.AbstractFactory;

/**
 * @author : ZWH
 * @date : 2024/01/09
 * @Description : 枪
 */
public class Gun extends Weapon {
    @Override
    public void shoot() {
        System.out.println("gun shoot");
    }
}
