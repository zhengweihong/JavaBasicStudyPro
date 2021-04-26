package P03_InputAndOutput.BIO;

import java.io.*;

public class Code03_InputStreamDemo {
	final static String absolutePath = "/Users/zwh/WorkSpace/IDEAWorkspace/JavaBasicStudyPro/JavaBasicGrammar/src/main/resources/";

	public static void main(String[] args) {
		//字节流
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(absolutePath+"a.txt");
			
			//方法一：每次只能读取一个字节 或 循环单个读取
			int read = inputStream.read();
			System.out.println((char)read);
			
			//方法二：开辟缓冲区，数据添加到缓冲区中，当满了之后一次读取
			int length = 0;//每次缓冲区读数据的长度
			byte[] buffer = new byte[1024];
			while( (length = inputStream.read(buffer)) != -1) {
				System.out.println( new String(buffer,0,length) );
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
