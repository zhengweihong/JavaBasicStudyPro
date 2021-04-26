package P05_NetTrans;

import java.net.*;

public class Code01_InetAddressDemo {

	public static void main(String[] args) throws UnknownHostException {
		//主机名+IP
		InetAddress localHost = InetAddress.getLocalHost();
		localHost.getHostName();//主机名
		localHost.getHostAddress();//IP
		InetAddress myAddress = InetAddress.getByName("ZWH.local");
		InetAddress bdAddress = InetAddress.getByName("www.baidu.com");
		
		System.out.println(localHost);//ZWH.local/192.168.31.203
		System.out.println(myAddress);
		System.out.println(bdAddress);
	}

}
