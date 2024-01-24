package P06_ChainOfResponsibility.FilterChain;

/**
 * @author : ZWH
 * @date : 2024/01/24
 * @Description : 要处理的信息流
 */
public class Msg {
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
