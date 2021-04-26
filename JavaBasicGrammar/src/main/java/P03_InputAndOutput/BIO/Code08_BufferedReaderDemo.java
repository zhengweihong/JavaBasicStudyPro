package P03_InputAndOutput.BIO;

import java.io.*;

public class Code08_BufferedReaderDemo {
	final static String absolutePath = "/Users/zwh/WorkSpace/IDEAWorkspace/JavaBasicStudyPro/JavaBasicGrammar/src/main/resources/";

	public static void main(String[] args) {
		BufferedReader reader = null ;
		try {
			reader = new BufferedReader(new FileReader(absolutePath+"a.txt"));
			
			int read = reader.read();
			System.out.println( (char)read );
			
			String readLine = null;//API查看reader.readLine()返回空没有数据了
			while( (readLine = reader.readLine()) != null ) {
				System.out.print( readLine );
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();//FileReader
		} catch (IOException e) {
			e.printStackTrace();//.read()
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	} 

}
