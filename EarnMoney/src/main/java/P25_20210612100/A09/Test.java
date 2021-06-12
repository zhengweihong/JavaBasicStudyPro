package P25_20210612100.A09;

/**
 * @author : ZWH 6/12/21
 * @version : 1.0
 */
public class Test {
    public static void main(String[] args) {
        Cuboid c1 = new Cuboid();
        Cuboid c2 = new Cuboid(8,3.5,5.9,"green");

        System.out.println("Cuboid 1");
        c1.displayInfo();
        System.out.println();
        System.out.println("Cuboid 2");
        c2.displayInfo();
    }
}
