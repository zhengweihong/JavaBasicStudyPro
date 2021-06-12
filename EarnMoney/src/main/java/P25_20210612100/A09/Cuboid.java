package P25_20210612100.A09;

/**
 * @author : ZWH 6/12/21
 * @version : 1.0
 */
public class Cuboid {
    double l,w,h;
    String color;

    public Cuboid() {
        this.l = 1;
        this.w = 1;
        this.h = 1;
        this.color = "white";
    }

    public Cuboid(double l, double w, double h, String color) {
        this.l = l;
        this.w = w;
        this.h = h;
        this.color = color;
    }

    public double getL() {
        return l;
    }

    public double getW() {
        return w;
    }

    public double getH() {
        return h;
    }

    public String getColor() {
        return color;
    }

    public double getVolume() {
        return l * w * h;
    }

    public double getSurfaceArea() {
        return 2 * (l*w + l*h + w*h);
    }

    public void displayInfo() {
        System.out.println("    Color: " + getColor());
        System.out.println("    Dimensions: " + getL() + " X " + getW() + " X " + getH());
        System.out.printf("    Surface Area: %.2f",getSurfaceArea());
        System.out.println();
        System.out.printf("    Volume: %.2f",getVolume());
        System.out.println();
    }
}
