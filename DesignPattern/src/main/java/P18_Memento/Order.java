package P18_Memento;

import java.io.Serializable;

/**
 * @author : ZWH
 * @date : 2024/02/21
 * @Description : 复杂的订单类
 */
public class Order implements Serializable {
    private int id;
    private String content;

    public Order(int id, String content) {
        this.id = id;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }
}
