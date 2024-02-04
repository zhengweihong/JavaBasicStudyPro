package P10_Proxy.C06_Dynamic_Cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author : ZWH
 * @date : 2024/02/03
 * @Description : 代理模式：测试，cglib=code generate library，实现动态代理不用被代理类实现接口
 */
public class Main {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Car.class);
        enhancer.setCallback(new TimeMethodInterceptor());
        Car car = (Car) enhancer.create();
        car.move();
    }
}
