package P01_Language.P06_NetTrans.Code04_SocketDemoSerialize;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginThreadServer {

	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(10086);
		
		while(true) {
			Socket socket = ss.accept();
			
			LoginServerThread loginServerThread = new LoginServerThread(socket);
			new Thread(loginServerThread).start();
		}
	}

}
