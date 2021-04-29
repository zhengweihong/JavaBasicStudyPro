package P01_20210426XYWX80.Q02;

/**
 * @author : ZWH 2021/4/28
 * @version : 1.0
 */
public class Router {
    private String brand;
    private String modelNumber;
    private double price;

    public Router(String brand, String modelNumber, double price) {
        this.brand = brand;
        this.modelNumber = modelNumber;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "brand: " + brand +
                ", model number: " + modelNumber +
                ", price: " + price;
    }
}
