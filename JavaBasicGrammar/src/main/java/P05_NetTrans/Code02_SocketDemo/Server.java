package P05_NetTrans.Code02_SocketDemo;

import java.net.*;
import java.io.*;

public class Server {

	public static void main(String[] args) throws IOException {
		//创建serverSocket来开放本地端口
		ServerSocket ss = new ServerSocket(10086);
		
		//接收数据，获取socket对象
		Socket server = ss.accept();
		//获取输入流对象+包装+读数据
		InputStream is = server.getInputStream();
		DataInputStream dis = new DataInputStream(is);
		String str = dis.readUTF();
		System.out.println(str);
		
		//返回给客户端响应
		OutputStream os = server.getOutputStream();
		os.write("Welcome to New World".getBytes());
		
		//都关闭
		os.close();
		dis.close();
		is.close();
		server.close();
		ss.close();
	}

}
