import java.awt.*;

/**
 * @author : ZWH 8/13/21
 * @version : 1.0
 */
public class Test {
    public static void main(String[] args) {
        Car car = new Car();
        car.name();
        int[] a = new int[]{1,2,3,4};
    }
}

abstract class Vehicle {
    private Color color;
    private String model;

    private void name() {
        System.out.println("Vehicle");
    }
}

interface Vehicle1{

}

class Car extends Vehicle implements Vehicle1{
    public void name(){
        System.out.println("Car");
    }
    public int name(String a){
        return 0;
    }
}