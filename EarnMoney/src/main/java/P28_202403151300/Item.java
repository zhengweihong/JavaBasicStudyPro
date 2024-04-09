package P28_202403151300;

public class Item {
    private String id;
    private String name;
    private String location;
    private Boolean canRent;
    private Integer numbers;

    public Item(String id, String name, String location, Boolean canRent, Integer numbers) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.canRent = canRent;
        this.numbers = numbers;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Boolean getCanRent() {
        return canRent;
    }

    public void setCanRent(Boolean canRent) {
        this.canRent = canRent;
    }

    public Integer getNumbers() {
        return numbers;
    }

    public void setNumbers(Integer numbers) {
        this.numbers = numbers;
    }
}
