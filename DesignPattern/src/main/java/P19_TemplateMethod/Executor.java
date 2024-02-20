package P19_TemplateMethod;

/**
 * @author : ZWH
 * @date : 2024/02/21
 * @Description : 父类模版
 */
abstract class Executor {
    public void template() {
        step1();
        step2();
    }

    abstract void step1();
    abstract void step2();
}
