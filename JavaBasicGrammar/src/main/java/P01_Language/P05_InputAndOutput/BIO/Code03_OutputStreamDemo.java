package P01_Language.P05_InputAndOutput.BIO;

import java.io.*;

public class Code03_OutputStreamDemo {
	final static String absolutePath = "/Users/zwh/WorkSpace/IDEAWorkspace/JavaBasicStudyPro/JavaBasicGrammar/src/main/resources/";

	public static void main(String[] args) {
		File file = new File(absolutePath+"a.txt");
		
		OutputStream outputStream = null;
		try {
			//创建文件并写入数据，若流发现目标文件不存在会自动创建
			outputStream = new FileOutputStream(file);
			
			outputStream.write(010);
			outputStream.write("\r\nzwh".getBytes());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
