package P01_Language.P06_NetTrans.Code04_SocketDemoSerialize;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class LoginClient {
	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("localhost",10086);
		
		//登录功能-传输一个User对象
		OutputStream os = socket.getOutputStream();
		//User user = new User("clientuser","clientpw");
		User user = getUser();
		//传输对象需要ObjectOutputStream
		ObjectOutputStream oos = new ObjectOutputStream(os);
		oos.writeObject(user);
		//传输结束标志
		socket.shutdownOutput();
		
		//接收响应
		InputStream is = socket.getInputStream();
		byte[] bBuffer = new byte[1024];
		is.read(bBuffer);
		System.out.println(new String(bBuffer));
		//接收结束标志
		socket.shutdownInput();
		
		is.close();
		oos.close();
		os.close();
		socket.close();
	}

	private static User getUser() {
		Scanner scan = new Scanner(System.in);
		System.out.println("username:");
		String username = scan.nextLine();
		System.out.println("password:");
		String password = scan.nextLine();
		return new User(username,password);
	}
}
