package P06_ChainOfResponsibility.FilterChain.Filter;


import P06_ChainOfResponsibility.FilterChain.Msg;

/**
 * @author : ZWH
 * @date : 2024/01/24
 * @Description : 抽象接口
 */
public interface Filter {
    /**
     * @return true-继续执行 false-终止执行
     */
    boolean doFilter(Msg m);
}
