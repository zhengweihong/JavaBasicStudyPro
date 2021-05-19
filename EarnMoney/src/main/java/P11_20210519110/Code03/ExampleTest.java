package P11_20210519110.Code03;

public class ExampleTest {
    public static void main(String[] args) {
        ExampleSingleton s = ExampleSingleton.getInstance();
        System.out.println("The ExampleSingleton has been "
                + "accessed via the getInstance() method "
                + s.accessCount()
                + " time(s)");
        s = ExampleSingleton.getInstance();
        System.out.println("The ExampleSingleton has been "
                + "accessed via the getInstance() method "
                + s.accessCount()
                + " time(s)");
    }
}

class ExampleSingleton {
    private static int accessCount;
    private static final ExampleSingleton singletonInstance = new ExampleSingleton();

    private ExampleSingleton() {
        System.out.println("I, the ExampleSingleton, am being created");
    }

    public static ExampleSingleton getInstance() {
        System.out.println("The sole instance of ExampleSingleton is being retrieved");
        accessCount++;
        return singletonInstance;
    }

    public int accessCount() {
        return accessCount;
    }
}