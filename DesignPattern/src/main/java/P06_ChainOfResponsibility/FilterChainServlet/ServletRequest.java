package P06_ChainOfResponsibility.FilterChainServlet;

/**
 * @author : ZWH
 * @date : 2024/01/24
 * @Description : 责任链模式：模仿Servlet请求
 */
public class ServletRequest {
    private String requestStr;

    public String getRequestStr() {
        return requestStr;
    }

    public void setRequestStr(String requestStr) {
        this.requestStr = requestStr;
    }

    @Override
    public String toString() {
        return "ServletRequest{" +
                "requestStr='" + requestStr + '\'' +
                '}';
    }
}
