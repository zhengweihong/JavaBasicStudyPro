package P03_InputAndOutput.BIO;

import java.io.*;

public class Code06_OutputStreamWriterDemo {
	final static String absolutePath = "/Users/zwh/WorkSpace/IDEAWorkspace/JavaBasicStudyPro/JavaBasicGrammar/src/main/resources/";

	public static void main(String[] args) {
		File file = new File(absolutePath+"a.txt");
		
		OutputStreamWriter outputStreamWriter = null;//外层
		FileOutputStream fileOutputStream = null;
		
		try {
			fileOutputStream = new FileOutputStream(file);
			//编码参数可以不加，编码默认为操作系统默认编码，Win上是gbk
			outputStreamWriter = new OutputStreamWriter(fileOutputStream,"UTF-8");
			
			outputStreamWriter.write("balabalabala", 0, 5);
			//写入缓冲区
			//append后会刷新缓冲区放入新的内容，原有内容写入文件
			outputStreamWriter.append("输入文字测试");
			outputStreamWriter.append("\r\n");//换行
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				//嵌套，按照new的逆序来close
				outputStreamWriter.close();
				fileOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
