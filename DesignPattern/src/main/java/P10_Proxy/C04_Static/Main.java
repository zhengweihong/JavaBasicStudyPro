package P10_Proxy.C04_Static;

/**
 * @author : ZWH
 * @date : 2024/02/02
 * @Description : 代理模式：测试，不同功能的代理用接口来组合实现相互嵌套，类似装饰器模式
 */
public class Main {
    public static void main(String[] args) {
        new CarTimeProxy(
                new CarLogProxy(
                        new Car()
                )
        ).move();
    }
}
