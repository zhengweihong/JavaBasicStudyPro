package P10_Proxy.C08_SpringAOP_Annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * @author : ZWH
 * @date : 2024/02/04
 * @Description : 执行时长代理
 */
@Aspect
public class TimeProxy {

    @Around("execution(void P10_Proxy.C08_SpringAOP_Annotation.Car.move())")
    public void around(ProceedingJoinPoint point) throws Throwable {
        long start = System.currentTimeMillis();
        point.proceed();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

}
