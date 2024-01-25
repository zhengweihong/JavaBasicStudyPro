package P06_ChainOfResponsibility.FilterChainServlet;

/**
 * @author : ZWH
 * @date : 2024/01/24
 * @Description : 责任链模式：模仿Servlet响应
 */
public class ServletResponse {
    private String responseStr;

    public String getResponseStr() {
        return responseStr;
    }

    public void setResponseStr(String responseStr) {
        this.responseStr = responseStr;
    }

    @Override
    public String toString() {
        return "ServletResponse{" +
                "responseStr='" + responseStr + '\'' +
                '}';
    }
}
