package P03_InputAndOutput.BIO;

import java.io.*;

public class Code08_BufferedReaderDemo {
	final static String filePath = "JavaBasicGrammar/src/main/resources/a.txt";

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			int read = br.read();
			System.out.println( (char)read );
			
			String readLine = null;//API查看reader.readLine()返回空没有数据了
			while( (readLine = br.readLine()) != null ) {
				System.out.print( readLine );
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();//FileReader
		} catch (IOException e) {
			e.printStackTrace();//.read()
		}
	} 

}
