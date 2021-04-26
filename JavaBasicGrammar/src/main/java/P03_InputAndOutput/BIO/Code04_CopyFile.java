package P03_InputAndOutput.BIO;

import java.io.*;

public class Code04_CopyFile {
	final static String absolutePath = "/Users/zwh/WorkSpace/IDEAWorkspace/JavaBasicStudyPro/JavaBasicGrammar/src/main/resources/";

	public static void main(String[] args) {
		//数据源
		File src = new File(absolutePath+"a.txt");
		//目标文件
		File dest = new File(absolutePath+"b.txt");
		
		//创建流对象
		InputStream inputStream = null;
		OutputStream outputStream = null;
		try {
			inputStream = new FileInputStream(src);
			outputStream = new FileOutputStream(dest);
			
			//缓冲区
			int length = 0;
			byte[] buffer = new byte[1024];
			
			while((length = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
