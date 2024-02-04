package P10_Proxy.C05_Dynamic;

import java.lang.reflect.*;

/**
 * @author : ZWH
 * @date : 2024/02/03
 * @Description : 代理模式：测试，代理任意类型的类，分离被代理对象和代理行为，JDK动态代理，运行时在内存生成
 */
public class Main {
    public static void main(String[] args) {
        Car car = new Car();

        // 把动态生成的代理类持久化
        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");

        // 动态生成代理类
        Movable m = (Movable) Proxy.newProxyInstance(
                // 想用哪个class loader在内存里加载想生成的代理类，一般用被代理类的class loader
                Car.class.getClassLoader(),
                // 想生成的类要实现哪些接口
                // new Class[]{Movable.class},
                Car.class.getInterfaces(),
                // 传入函数：被代理对象的方法被调用时，代理都做什么处理
                // 调用处理器类：InvocationHandler.invoke()
                // 入参：生成的代理类对象、被代理的方法、被代理的方法入参
                (proxy, method, methodArgs) -> {
                    long start = System.currentTimeMillis();
                    Object o = method.invoke(car, methodArgs);
                    long end = System.currentTimeMillis();
                    System.out.println(end - start);
                    return o;
                });

        m.move();

        // 内部类写法
        Movable m2 = (Movable) Proxy.newProxyInstance(
                Car.class.getClassLoader(),
                Car.class.getInterfaces(),
                new LogHandle(car)
        );
    }
}

class LogHandle implements InvocationHandler {
    private Movable m;

    public LogHandle(Movable m) {
        this.m = m;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before(method);
        // 相当于：m.move(args);
        Object o = method.invoke(m, args);
        after(method);
        return o;
    }

    private void before(Method method) {
        System.out.println(method.getName() + "start");
    }

    private void after(Method method) {
        System.out.println(method.getName() + "end");
    }
}
