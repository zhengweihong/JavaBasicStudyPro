package P06_ChainOfResponsibility.FilterChainServlet.Filter;

import P06_ChainOfResponsibility.FilterChainServlet.ServletRequest;
import P06_ChainOfResponsibility.FilterChainServlet.ServletResponse;

/**
 * @author : ZWH
 * @date : 2024/01/24
 * @Description : 抽象接口
 */
public interface Filter {
    void doFilter(ServletRequest request, ServletResponse response,
                  FilterChain filterChain);
}
