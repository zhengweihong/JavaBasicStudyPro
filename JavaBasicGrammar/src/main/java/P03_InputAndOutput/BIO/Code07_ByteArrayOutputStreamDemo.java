package P03_InputAndOutput.BIO;

import java.io.*;

public class Code07_ByteArrayOutputStreamDemo {

	public static void main(String[] args) {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		try {
			byteArrayOutputStream.write(123);//打印出来是{，传的是ASCII码
			byteArrayOutputStream.write("123".getBytes());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.out.println(byteArrayOutputStream.toString());
		try {
			byteArrayOutputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
