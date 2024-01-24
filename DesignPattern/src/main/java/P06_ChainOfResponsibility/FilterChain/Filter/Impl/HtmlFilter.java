package P06_ChainOfResponsibility.FilterChain.Filter.Impl;


import P06_ChainOfResponsibility.FilterChain.Filter.Filter;
import P06_ChainOfResponsibility.FilterChain.Msg;

/**
 * @author : ZWH
 * @date : 2024/01/24
 * @Description : 过滤HTML标签
 */
public class HtmlFilter implements Filter {
    @Override
    public boolean doFilter(Msg m) {
        String rm = m.getMsg();
        rm = rm.replace("<", "[");
        rm = rm.replace(">", "]");
        m.setMsg(rm);
        return true;
    }
}
