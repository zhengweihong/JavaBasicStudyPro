package P03_InputAndOutput.BIO;

import java.io.*;

public class Code10_RandomAccessFileDemo {
	/**
	 * @param beginPosition 偏移量
	 * @param actualSize	真实取数据大小
	 */
	public static void readFileSplit(File file,int beginPosition,int actualSize) {
		RandomAccessFile randomAccessFile = null;
		try {
			//mode参数-访问模式
			//"r"=read only；"rw"=read&write
			//"rws"=read&write&save；"rwd"=read&write&save
			randomAccessFile = new RandomAccessFile(file,"r");
			
			//表示从begin开始读取数据
			randomAccessFile.seek(beginPosition);
			int length = 0;
			byte[] bytes = new byte[1024];
			while( (length = randomAccessFile.read(bytes)) != -1 ) {
				if(actualSize>length) {
					System.out.print(new String(bytes,0,length));
					actualSize -= length;
				} else {
					System.out.print(new String(bytes,0,actualSize));
					break;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				randomAccessFile.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		File file = new File("JavaBasicGrammar/src/main/resources/b.txt");
		long length = file.length();//文件的大小
		int blockSize = 1024;//设置块的大小
		int blockNumbers = (int)Math.ceil( length*1.0/blockSize );//被分成几块
		
		int beginPosition = 0;
		int actualSize = blockSize;
		for(int i=0;i<blockNumbers;i++) {
			beginPosition = i*blockSize;
			if(i==blockNumbers-1) {//最后一块
				actualSize = (int) (length - beginPosition);
			}
			
			readFileSplit(file,beginPosition,actualSize);
		}
	}

}
