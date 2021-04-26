package P03_InputAndOutput.BIO;

import java.io.*;

public class Code05_WriterDemo {
	final static String absolutePath = "/Users/zwh/WorkSpace/IDEAWorkspace/JavaBasicStudyPro/JavaBasicGrammar/src/main/resources/";

	public static void main(String[] args) {
		Writer writer = null;
		try {
			writer = new FileWriter(absolutePath+"a.txt");
			
			writer.write("QAQ");
			writer.write("巴拉巴拉");
			
			writer.flush();//清空缓冲区中数据
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();//相当一次flush
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
