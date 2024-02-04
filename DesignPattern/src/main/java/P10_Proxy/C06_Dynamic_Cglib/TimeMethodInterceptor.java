package P10_Proxy.C06_Dynamic_Cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author : ZWH
 * @date : 2024/02/03
 * @Description : 传给Enhancer的方法拦截器
 */
public class TimeMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        // 被增强的类(this)的父类：原来被代理的类Car
        System.out.println(o.getClass().getSuperclass().getName());

        long start = System.currentTimeMillis();
        Object result = methodProxy.invokeSuper(o, objects);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        return result;
    }
}
