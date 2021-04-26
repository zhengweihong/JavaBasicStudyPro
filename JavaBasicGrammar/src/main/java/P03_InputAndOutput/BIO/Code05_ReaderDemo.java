package P03_InputAndOutput.BIO;

import java.io.*;

public class Code05_ReaderDemo {
	final static String absolutePath = "/Users/zwh/WorkSpace/IDEAWorkspace/JavaBasicStudyPro/JavaBasicGrammar/src/main/resources/";

	public static void main(String[] args) {
		//字符流可以直接读取中文汉字
		Reader reader = null;
		try {
			reader = new FileReader(absolutePath+"a.txt");
			
			//方法一：每次只能读取一个字符
			int read = reader.read();
			System.out.println((char)read);
			
			//方法一：循环单个读取一个字符
			while((read = reader.read()) != -1) {
				System.out.println((char)read);
			}
			
			//方法二：开辟缓冲区，数据添加到缓冲区中，当满了之后一次读取
			int length = 0;
			char[] chars = new char[1024];
			while((length = reader.read(chars)) != -1) {
				System.out.println(new String(chars,0,length));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
