package P03_InputAndOutput.BIO;

import java.io.*;

public class Code06_InputStreamReaderDemo {
	final static String absolutePath = "/Users/zwh/WorkSpace/IDEAWorkspace/JavaBasicStudyPro/JavaBasicGrammar/src/main/resources/";

	public static void main(String[] args) {
		File file = new File(absolutePath+"a.txt");
		
		InputStreamReader inputStreamReader = null;//外层
		FileInputStream fileInputStream = null;
		
		try {
			fileInputStream = new FileInputStream(file);
			inputStreamReader = new InputStreamReader(fileInputStream,"UTF-8");
			
			StringBuffer sb = new StringBuffer();
			while(inputStreamReader.ready()){
				sb.append( (char)inputStreamReader.read() );
			}
			System.out.println( sb.toString() );
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				inputStreamReader.close();
				fileInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}