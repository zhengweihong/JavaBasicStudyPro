package P06_ChainOfResponsibility.FilterChainServlet.Filter;

import P06_ChainOfResponsibility.FilterChainServlet.ServletRequest;
import P06_ChainOfResponsibility.FilterChainServlet.ServletResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : ZWH
 * @date : 2024/01/24
 * @Description : 抽象接口
 * @see : javax.servlet.FilterChain
 */
public class FilterChain implements Filter {
    private List<Filter> filters = new ArrayList<>();
    private int index = 0;

    public FilterChain add(Filter filter) {
        filters.add(filter);
        return this;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) {
        if (index == filters.size()) {
            return;
        }

        Filter f = filters.get(index);
        index++;
        f.doFilter(request, response, this);
    }
}
