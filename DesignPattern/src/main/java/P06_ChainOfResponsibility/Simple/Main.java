package P06_ChainOfResponsibility.Simple;

import P06_ChainOfResponsibility.Simple.Filter.Filter;
import P06_ChainOfResponsibility.Simple.Filter.Impl.HtmlFilter;
import P06_ChainOfResponsibility.Simple.Filter.Impl.SensitiveFilter;

import java.util.ArrayList;
import java.util.List;

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
        List<Filter> filters = new ArrayList<>();
        filters.add(new HtmlFilter());
        filters.add(new SensitiveFilter());
        for (Filter filter : filters) {
            filter.doFilter(msg);
        }

        System.out.println(msg.toString());
    }
}
