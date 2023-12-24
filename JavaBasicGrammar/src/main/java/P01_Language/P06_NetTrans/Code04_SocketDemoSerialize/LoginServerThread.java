package P01_Language.P06_NetTrans.Code04_SocketDemoSerialize;

import java.io.*;
import java.net.Socket;

public class LoginServerThread implements Runnable {
	
	//一个client要有一个socket，构造方法传入
	private Socket socket;
	
	public LoginServerThread() {}

	public LoginServerThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		//接收传入的User + 给客户端响应
		ObjectInputStream ois = null;
		OutputStream os = null;
		try {
			ois = new ObjectInputStream(socket.getInputStream());
			User user = (User)ois.readObject();
			String reply = "";
			if("clientuser".equals(user.getUsername()) && "clientpw".equals(user.getPassword())) {
				reply = "登录成功！欢迎你："+user.getUsername();
				System.out.println("username:"+user.getUsername());
			} else {
				reply = "登录失败";
				System.out.println("!username:"+user.getUsername());
			}
			socket.shutdownInput();
			
			os = socket.getOutputStream();
			os.write(reply.getBytes());
			socket.shutdownOutput();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
				os.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
