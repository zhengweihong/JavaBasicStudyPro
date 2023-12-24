package P01_Language.P05_InputAndOutput.BIO;

import java.io.*;

public class Code08_BufferedWriterDemo {
	final static String absolutePath = "/Users/zwh/WorkSpace/IDEAWorkspace/JavaBasicStudyPro/JavaBasicGrammar/src/main/resources/";

	public static void main(String[] args) {
		BufferedWriter bufferedWriter = null;
		try {
			bufferedWriter = new BufferedWriter(new FileWriter(absolutePath+"a.txt"));
			
			bufferedWriter.write("balabala");
			bufferedWriter.newLine();
			bufferedWriter.append("啦啦啦");
			
			bufferedWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();//FileWriter
		} finally {
			try {
				bufferedWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
