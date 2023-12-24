package P01_Language.P06_NetTrans.Code03_SocketDemoPic;

import java.net.*;
import java.io.*;

public class PicClient {

	public static void main(String[] args) throws Exception {
		//创建socket对象
		Socket socket = new Socket("localhost",10086);
		
		//把本地图片读入当前程序
		OutputStream os = socket.getOutputStream();
		FileInputStream fis = new FileInputStream("JavaBasicGrammar/src/main/resources/原图片.jpeg");
		int temp = 0;
		while( (temp = fis.read()) != -1 ) {
			os.write(temp);
		}
		
		//流输出完成
		socket.shutdownOutput();
		
		//接收服务端发来的消息
		InputStream is = socket.getInputStream();
		byte[] bBuffer = new byte[1024];
		is.read(bBuffer);
		System.out.println("接收服务端发来的消息:"+new String(bBuffer));
		
		//流输入完成
		socket.shutdownInput();
		
		is.close();
		os.close();
		socket.close();
		fis.close();
	}

}
