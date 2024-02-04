package P10_Proxy.C07_SpringAOP_XmlConfig;

/**
 * @author : ZWH
 * @date : 2024/02/04
 * @Description : 日志代理
 */
public class LogProxy {
    private void before() {
        System.out.println("method start");
    }

    private void after() {
        System.out.println("method end");
    }
}
