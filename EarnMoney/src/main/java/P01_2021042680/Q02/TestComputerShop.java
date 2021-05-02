package P01_2021042680.Q02;

/**
 * @author : ZWH 2021/4/28
 * @version : 1.0
 */
public class TestComputerShop {
    public static void main(String[] args) {
        ComputerShop aShop = new ComputerShop();
        aShop.addRouter(new Router("Linksys","RVS4000",1080));
        aShop.addRouter(new Router("Planet","VRT-311S",510));

        aShop.showRouter();

        aShop.modelNumberSet().forEach(System.out::println);

        aShop.priceList().forEach(System.out::println);
    }
}
