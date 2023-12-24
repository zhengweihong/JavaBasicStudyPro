package P01_Language.P06_NetTrans.Code02_SocketDemo;

import java.net.*;
import java.io.*;

public class Client {

	public static void main(String[] args) throws IOException {
		//创建socket对象，本质是开启实现io的虚拟接口
		//此接口是类似于网线的插槽，并不是Java的接口概念
		//需要指定数据接收方/服务端的IP和端口号
		Socket client = new Socket("localhost",10086);
		
		//从当前程序传出数据，向服务端发
		OutputStream os = client.getOutputStream();
		//包装上
		DataOutputStream dos = new 	DataOutputStream(os);
		dos.writeUTF("Hello World");
		
		//接收服务端发来的消息
		InputStream is = client.getInputStream();
		byte[] bBuffer = new byte[1024];
		is.read(bBuffer);
		System.out.println("接收服务端发来的消息:"+new String(bBuffer));
		
		//都关闭
		is.close();
		dos.close();
		os.close();
		client.close();
	}

}
