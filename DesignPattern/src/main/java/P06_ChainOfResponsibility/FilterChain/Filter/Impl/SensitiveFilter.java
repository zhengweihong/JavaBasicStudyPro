package P06_ChainOfResponsibility.FilterChain.Filter.Impl;

import P06_ChainOfResponsibility.FilterChain.Filter.Filter;
import P06_ChainOfResponsibility.FilterChain.Msg;

/**
 * @author : ZWH
 * @date : 2024/01/24
 * @Description : 过滤敏感词
 */
public class SensitiveFilter implements Filter {
    @Override
    public boolean doFilter(Msg m) {
        String rm = m.getMsg();
        rm = rm.replace("996", "007");
        m.setMsg(rm);
        return false;
    }
}
