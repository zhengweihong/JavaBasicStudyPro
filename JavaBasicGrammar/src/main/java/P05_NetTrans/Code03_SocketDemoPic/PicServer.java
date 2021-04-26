package P05_NetTrans.Code03_SocketDemoPic;

import java.net.*;
import java.io.*;

public class PicServer {

	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(10086);
		Socket socket = ss.accept();
		
		//把程序接收到的文件存在本地，先创建个对象
		InputStream is = socket.getInputStream();
		FileOutputStream fos = new FileOutputStream("JavaBasicGrammar/src/main/resources/SocketPicture.jpg");
		int temp = 0;
		while( (temp = is.read()) != -1 ) {
			fos.write(temp);
		}
		
		//流输入完成
		socket.shutdownInput();
		
		//接收图片结束后，给予客户端响应
		OutputStream os = socket.getOutputStream();
		os.write("上传成功".getBytes());
		
		//流输出完成
		socket.shutdownOutput();
		
		os.close();
		is.close();
		socket.close();
		ss.close();
		fos.close();
	}

}
