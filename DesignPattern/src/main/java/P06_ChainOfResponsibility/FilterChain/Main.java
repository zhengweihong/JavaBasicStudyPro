package P06_ChainOfResponsibility.FilterChain;

import P06_ChainOfResponsibility.FilterChain.Filter.FilterChain;
import P06_ChainOfResponsibility.FilterChain.Filter.Impl.HtmlFilter;
import P06_ChainOfResponsibility.FilterChain.Filter.Impl.SensitiveFilter;

/**
 * @author : ZWH
 * @date : 2024/01/23
 * @Description : 责任链模式：测试
 */
public class Main {
    public static void main(String[] args) {
        Msg msg = new Msg();
        msg.setMsg("hello <script> we all 996 </script>");

        // resolve msg
        // Step 1 replace逻辑全写在main里
        // Step 2 定义不同类型filter循环处理
        // Step 3 把filter循环抽象为链，链式编程，多链可组合（FilterChain也可以是一个filter），运行时判断是否终止链执行
        FilterChain filterChainBack = new FilterChain();
        filterChainBack.add(new HtmlFilter())
                .add(new SensitiveFilter());

        FilterChain filterChain = new FilterChain();
        filterChain.add(new HtmlFilter())
                .add(new SensitiveFilter())
                .add(filterChainBack);

        filterChain.doFilter(msg);

        System.out.println(msg.toString());
    }
}
