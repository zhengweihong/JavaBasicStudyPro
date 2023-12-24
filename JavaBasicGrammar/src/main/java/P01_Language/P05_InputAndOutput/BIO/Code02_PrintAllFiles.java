package P01_Language.P05_InputAndOutput.BIO;

import java.io.File;

public class Code02_PrintAllFiles {

	/**
	 * 打印指定路径中所有 文件 的绝对路径——递归
	 * 遍历过程中，会报空指针异常，因为权限不够无法访问
	 */
	public static void main(String[] args) {
		printFile(new File("/Users/zwh/WorkSpace/IDEAWorkspace/JavaBasicStudyPro/JavaBasicGrammar"));
	}

	public static void printFile(File f) {
		if(f.isDirectory()) {
			File[] files = f.listFiles();
			for(File ff:files) {
				printFile(ff);
			}
		}else {
			System.out.println(f.getAbsolutePath());
		}
	}
}
