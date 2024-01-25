package P06_ChainOfResponsibility.FilterChainServlet;

import P06_ChainOfResponsibility.FilterChainServlet.Filter.FilterChain;
import P06_ChainOfResponsibility.FilterChainServlet.Filter.Impl.HtmlFilter;
import P06_ChainOfResponsibility.FilterChainServlet.Filter.Impl.SensitiveFilter;

/**
 * @author : ZWH
 * @date : 2024/01/24
 * @Description : 责任链模式：模仿Servlet过滤器
 */
public class Main {
    public static void main(String[] args) {
        ServletRequest request = new ServletRequest();
        request.setRequestStr("Request ");
        ServletResponse response = new ServletResponse();
        response.setResponseStr("Response ");

        FilterChain filterChainBack = new FilterChain();
        filterChainBack.add(new HtmlFilter());

        FilterChain filterChain = new FilterChain();
        filterChain.add(new SensitiveFilter())
                .add(filterChainBack);

        filterChain.doFilter(request, response, filterChain);

        System.out.println(request.getRequestStr());
        System.out.println(response.getResponseStr());
    }
}
