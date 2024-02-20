package P19_TemplateMethod;

/**
 * @author : ZWH
 * @date : 2024/02/21
 * @Description : 实现类
 */
public class Implementor extends Executor {
    @Override
    void step1() {
        System.out.println("step1");
    }

    @Override
    void step2() {
        System.out.println("step2");
    }
}
