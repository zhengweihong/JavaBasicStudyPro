package P09_Flyweight.C02_Pool;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : ZWH
 * @date : 2024/01/27
 * @Description : socket连接池
 */
public class SocketLinkPool {
    List<SocketLink> links = new ArrayList<>();

    {
        for (int i = 0; i < 10; i++) {
            links.add(new SocketLink(true));
        }
    }

    public SocketLink getSocketLink() {
        for (SocketLink link : links) {
            if (!link.isUsing()) {
                link.setUsing(true);
                return link;
            }
        }

        SocketLink socketLink = new SocketLink(false);
        socketLink.setUsing(true);
        return socketLink;
    }
}
