package P09_Flyweight.C02_Pool;

import java.util.UUID;

/**
 * @author : ZWH
 * @date : 2024/01/27
 * @Description : socket连接
 */
public class SocketLink {
    private UUID uuid = UUID.randomUUID();
    private boolean using;
    private boolean createOnPoolStart;

    public SocketLink(boolean createOnPoolStart) {
        this.createOnPoolStart = createOnPoolStart;
    }

    public boolean isUsing() {
        return using;
    }

    public void setUsing(boolean using) {
        this.using = using;
    }

    @Override
    public String toString() {
        return "SocketLink{" +
                "uuid=" + uuid +
                ", using=" + using +
                ", createAtPoolStart=" + createOnPoolStart +
                '}';
    }
}
