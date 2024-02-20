package P19_TemplateMethod;

/**
 * @author : ZWH
 * @date : 2024/02/20
 * @Description : 模板方法模式，测试
 */
public class Main {
    public static void main(String[] args) {
        Executor e = new Implementor();
        e.template();
    }
}
