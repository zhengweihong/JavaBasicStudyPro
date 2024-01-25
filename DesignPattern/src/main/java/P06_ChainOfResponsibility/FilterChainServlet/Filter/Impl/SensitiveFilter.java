package P06_ChainOfResponsibility.FilterChainServlet.Filter.Impl;


import P06_ChainOfResponsibility.FilterChainServlet.Filter.Filter;
import P06_ChainOfResponsibility.FilterChainServlet.Filter.FilterChain;
import P06_ChainOfResponsibility.FilterChainServlet.ServletRequest;
import P06_ChainOfResponsibility.FilterChainServlet.ServletResponse;

/**
 * @author : ZWH
 * @date : 2024/01/24
 * @Description : 过滤敏感词
 */
public class SensitiveFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) {
        request.setRequestStr(request.getRequestStr() + "SensitiveFilter ");

        filterChain.doFilter(request, response, filterChain);

        response.setResponseStr(response.getResponseStr() + "SensitiveFilter ");
    }
}
