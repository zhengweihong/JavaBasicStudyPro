package P03_InputAndOutput.BIO;

import java.io.*;
import java.net.*;

public class Code09_BaiDuTest {

	public static void main(String[] args) {
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		
		try {
			bufferedReader = new BufferedReader(
								new InputStreamReader(
									new URL("http://www.baidu.com").openStream(),"UTF-8"
								)//必须写http
							 );
			
			bufferedWriter = new BufferedWriter(
								new OutputStreamWriter(
									new FileOutputStream("JavaBasicGrammar/src/main/resources/baidu.html"),"UTF-8"
								)
							 );
			
			String msg = null;
			while( (msg = bufferedReader.readLine()) != null ) {
				bufferedWriter.write(msg);
				bufferedWriter.newLine();
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bufferedWriter.close();
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
