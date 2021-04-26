package P03_InputAndOutput.BIO;

import java.io.*;

public class Code01_FileDemo {
	final static String absolutePath = "/Users/zwh/WorkSpace/IDEAWorkspace/JavaBasicStudyPro/JavaBasicGrammar/src/main/resources/";

	public static void main(String[] args) {
		//不加路径创建在Project项目根目录下(JavaBasicStudyPro)
		File file = new File("a.txt");
		File f = new File(absolutePath+ "a.txt");
		
		//创建文件，捕获异常
		try {
			f.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		f.exists();
		
		//判断文件属性
		f.canExecute();
		f.canRead();
		f.canWrite();
		f.isDirectory();
		f.isFile();//若文件不存在也返回false
		
		//获取文件属性
		f.getName();
		f.getAbsolutePath();//文件存不存在没有关系
		f.getParent();//获取父路径名称
		file.getParent();//代码中没有设置路径，返回null
		
		try {
			System.out.println(f.getCanonicalPath());//返回抽象路径的规范形式
			System.out.println(File.separator);//当前系统路径规范形式用反斜杠
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//打印当前文件系统所有盘符：[win]C:\ D:\
		File[] Files = File.listRoots();
		for(File ff:Files) {
			System.out.println("listRoot:"+ff);//listRoot:/
		}
		
		
		File filePath = new File(absolutePath);
		//filePath.list();
		String[] filelist = filePath.list();
		System.out.println(filelist);			//String数组地址
		System.out.println(filelist.toString());//String数组地址
		for(String str:filelist) {
			System.out.println(str);			//文件名没路径
		}
		
		//filePath.listFiles();常用！！！
		File[] files = filePath.listFiles();
		for(File ff:files) {
			System.out.println(ff);				//路径+文件名
		}
		
		
		//创建单级目录
		filePath.mkdir();
		//创建多级目录
		filePath.mkdirs();
	}
}
