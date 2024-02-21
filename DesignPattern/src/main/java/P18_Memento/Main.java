package P18_Memento;

import java.io.*;

/**
 * @author : ZWH
 * @date : 2024/02/21
 * @Description : 备忘录模式，测试
 */
public class Main {
    public static void main(String[] args) {
        Order order = new Order(20140221, "一个非常复杂的订单对象");
        Order other = new Order(20150221, "另一个非常复杂的订单对象");

        String path = (String) System.getProperties().get("user.dir");
        File file = new File(path + "/com/DesignPattern/P18_Memento/Order.data");

        // save
        OutputStream outputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            outputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(outputStream);

            objectOutputStream.writeObject(order);
            objectOutputStream.writeObject(other);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // load 文件中对象有顺序的，下边实现order、other互换
        FileInputStream inputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            inputStream = new FileInputStream(file);
            objectInputStream = new ObjectInputStream(inputStream);

            other = (Order) objectInputStream.readObject();
            order = (Order) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println(order);
        System.out.println(other);
    }
}
