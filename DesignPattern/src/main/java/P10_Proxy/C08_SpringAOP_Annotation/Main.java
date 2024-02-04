package P10_Proxy.C08_SpringAOP_Annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : ZWH
 * @date : 2024/02/04
 * @Description : 代理模式：测试，SpringAOP，切面注解方式
 */
public class Main {
    public static void main(String[] args) {
        /**
         * pom.xml：
         * org.springframework：spring-context
         * org.springframework：spring-aop
         * org.aspectj：aspectjweaver
         */
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("app_proxy_annotation.xml");
        Car car = (Car) context.getBean("car");
        car.move();
    }
}
