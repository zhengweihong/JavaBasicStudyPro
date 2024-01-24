package P06_ChainOfResponsibility.FilterChain.Filter;

import P06_ChainOfResponsibility.FilterChain.Msg;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : ZWH
 * @date : 2024/01/24
 * @Description : 责任链
 */
public class FilterChain implements Filter {
    private List<Filter> filters = new ArrayList<>();

    public FilterChain add(Filter filter) {
        filters.add(filter);
        return this;
    }

    @Override
    public boolean doFilter(Msg m) {
        for (Filter filter : filters) {
            // 若某个返回false终止执行，返回true进行下一次循环
            if (!filter.doFilter(m)) {
                return false;
            }
        }
        return true;
    }
}
