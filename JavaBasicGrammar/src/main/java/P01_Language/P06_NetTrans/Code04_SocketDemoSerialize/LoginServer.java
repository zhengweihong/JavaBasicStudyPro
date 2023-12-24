package P01_Language.P06_NetTrans.Code04_SocketDemoSerialize;

import java.io.*;
import java.net.*;

public class LoginServer {

	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(10086);
		Socket socket = ss.accept();
		
		InputStream is = socket.getInputStream();
		ObjectInputStream bis = new ObjectInputStream(is);
		User user = (User)bis.readObject();
		String reply = "";
		if("clientuser".equals(user.getUsername()) && "clientpw".equals(user.getPassword())) {
			reply = "登录成功！欢迎你："+user.getUsername();
			System.out.println("username:"+user.getUsername());
		} else {
			reply = "登录失败";
		}
		//接收结束标志
		socket.shutdownInput();
		
		//给客户端响应
		OutputStream os = socket.getOutputStream();
		os.write(reply.getBytes());
		//传输结束标志
		socket.shutdownOutput();
		
		os.close();
		bis.close();
		is.close();
		socket.close();
		ss.close();
	}

}
