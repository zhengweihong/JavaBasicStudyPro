package P01_Language.P05_InputAndOutput.BIO;

import java.io.*;

public class Code07_ByteArrayInputStreamDemo {

	public static void main(String[] args) {
		String str = "www.balabala.com";
		byte[] buffer = str.getBytes();
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(buffer);
		
		int read = 0;
		while( (read = byteArrayInputStream.read()) != -1 ) {
			byteArrayInputStream.skip(4);//跳过4字节
			System.out.println( (char)read );
		}
		
		try {
			byteArrayInputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
