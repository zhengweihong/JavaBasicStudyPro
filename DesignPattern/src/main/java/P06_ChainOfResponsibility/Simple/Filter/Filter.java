package P06_ChainOfResponsibility.Simple.Filter;

import P06_ChainOfResponsibility.Simple.Msg;

/**
 * @author : ZWH
 * @date : 2024/01/24
 * @Description : 抽象接口
 */
public interface Filter {
    void doFilter(Msg m);
}
