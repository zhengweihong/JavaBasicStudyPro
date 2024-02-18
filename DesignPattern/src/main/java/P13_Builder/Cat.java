package P13_Builder;

/**
 * @author : ZWH
 * @date : 2024/02/18
 * @Description : 复杂的类
 */
public class Cat {
    int id;
    String name;
    int age;
    int weight;
    Location location;

    private Cat() {
    }

    public static class CatBuilder {
        Cat cat = new Cat();

        public CatBuilder basicInfo(int id, String name, int age) {
            cat.id = id;
            cat.name = name;
            cat.age = age;
            return this;
        }

        public CatBuilder weight(int weight) {
            cat.weight = weight;
            return this;
        }

        public CatBuilder location(int x, int y) {
            cat.location = new Location(x, y);
            return this;
        }

        public Cat build() {
            return cat;
        }
    }
}

class Location {
    private int x;
    private int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
