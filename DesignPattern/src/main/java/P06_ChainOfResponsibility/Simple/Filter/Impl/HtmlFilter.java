package P06_ChainOfResponsibility.Simple.Filter.Impl;

import P06_ChainOfResponsibility.Simple.Filter.Filter;
import P06_ChainOfResponsibility.Simple.Msg;

/**
 * @author : ZWH
 * @date : 2024/01/24
 * @Description : 过滤HTML标签
 */
public class HtmlFilter implements Filter {
    @Override
    public void doFilter(Msg m) {
        String rm = m.getMsg();
        rm = rm.replace("<", "[");
        rm = rm.replace(">", "]");
        m.setMsg(rm);
    }
}
