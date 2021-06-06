package P23_2021060650;
import java.io.*;
import java.util.ArrayList;

public class TestLetterGrader {
	public static void main(String[] args) {
		if (args==null || args.length==0){
			System.out.println("no arguments");
			System.exit(0);
		}
		LetterGrader letterGrader = new LetterGrader(args[0],args[1]);

		letterGrader.readScore();//reads score and stores the data in member variables
		letterGrader.calcLetterGrade();//determines letter grade and stores information
		letterGrader.printGrade();//writes the grade in output file
		letterGrader.displayAverages();//displays the averages in console
		letterGrader.doCleanup();//use it to close files and other resources
		//remember you need to take care of any errors or exceptions
		// in any of these activities must be taken care of
	}
}

class LetterGrader {
	String inputFile;
	String outputFile;
	ArrayList<Student> studentsScore;
	BufferedReader br;
	BufferedWriter bw;

	public LetterGrader(String inputFile, String outputFile) {
		this.inputFile = inputFile;
		this.outputFile = outputFile;
		this.studentsScore = new ArrayList<>();
	}

	public void readScore() {
		try {
			br = new BufferedReader(new FileReader("EarnMoney/src/main/java/P23_2021060650/" + inputFile));
			String aLine = null;
			while ((aLine = br.readLine()) != null) {
				String[] temp = aLine.split(", ");
				Student aStudent = new Student();
				aStudent.name = temp[0];
				for (int i = 1; i <= 7 ; i++) {
					aStudent.scores[i-1] = Double.parseDouble(temp[i]);
				}
				studentsScore.add(aStudent);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void calcLetterGrade() {
		for (int i = 0; i < studentsScore.size() ; i++) {
			double[] scores = studentsScore.get(i).scores;
			//quiz1*.1+quiz2*.1+quiz3*.1+quiz4*.1+midi*.2+midii*.15+final*.25
			double result = (scores[0]+scores[1]+scores[2]+scores[3])*0.1 + scores[4]*0.2 + scores[5]*0.15 +scores[6]*0.25;
			if (result>=90) {
				studentsScore.get(i).grade = 'A';
			} else if (result>=80) {
				studentsScore.get(i).grade = 'B';
			} else if (result>=70) {
				studentsScore.get(i).grade = 'C';
			} else if (result>=60) {
				studentsScore.get(i).grade = 'D';
			} else {
				studentsScore.get(i).grade = 'F';
			}
		}
	}

	public void printGrade() {
		try {
			bw = new BufferedWriter(new FileWriter("EarnMoney/src/main/java/P23_2021060650/" + outputFile));
			for (int i = 0; i < studentsScore.size() ; i++) {
				Student aStudent = studentsScore.get(i);
				String name = aStudent.name;
				bw.append(name +":");
				for (int j = 0; j < 20-name.length() ; j++) {
					bw.append(" ");
				}
				bw.append(aStudent.grade);
				bw.newLine();
			}
			bw.flush();
			System.out.println("Letter grade has been calculated for students listed in input file "+inputFile+" and written to output file "+outputFile);
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void displayAverages() {
		System.out.println("Here is the class averages:");
		System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s","","Q1","Q2","Q3","Q4","Midl","MidlI","Final");
		System.out.println();
		double[][] courseInfo = new double[7][3];
		for (int course = 0; course < 7 ; course++) {
			courseInfo[course] = calculation(course);
		}
		System.out.printf("%-10s","Average:");
		for (int course = 0; course < 7 ; course++) {
			System.out.printf("%-10s",courseInfo[course][0]);
		}
		System.out.println();
		System.out.printf("%-10s","Minimum:");
		for (int course = 0; course < 7 ; course++) {
			System.out.printf("%-10s",courseInfo[course][1]);
		}
		System.out.println();
		System.out.printf("%-10s","Maximum:");
		for (int course = 0; course < 7 ; course++) {
			System.out.printf("%-10s",courseInfo[course][2]);
		}
	}
	
	public double[] calculation(int course){
		double total = 0.0;
		double min = 100.0;
		double max = 0.0;
		for (int i = 0; i < studentsScore.size(); i++) {
			double score = studentsScore.get(i).scores[course];
			total += score;
			min = score<min ? score : min;
			max = score>max ? score : max;
		}
		return new double[]{total/studentsScore.size(),min,max};
	}

	public void doCleanup() {
		studentsScore.clear();
		try {
			br.close();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class Student {
	String name;
	double[] scores = new double[7];//0-6
	char grade;
}

/*需求：从input file中读取学生多项成绩计算，给学生算总分并在output file中给出评级结果，
 * 在console中给出各项考试的ave/min/max
 * 
 * 取名要求： 见截图
 * 要求使用：class，object，exception handling collection
 * 
 * 程序需要用两个command line arguments，第一个包含学生信息及成绩
 * 顺序是 name quiz1,2,3,4 mid1,2 final(共8个item）
 * 
 * 第二个是output file，这个程序要用这个名字创建一个新的outputfile
 * 并包含处理后的结果：从input读取信息后sort再放进output中
 * （format  the texts in the output file,input里面的format是固定的）
 * 
 * input file中的学生数量在compile过程中是未知的
 * 注意：会有two sets of outputs,letter grader is written in the output disk file,这个在屏幕中是不显示的
 * average计算结果是只在console中显示，不必写在file中的
 * 
 * 除了在写output file之外，还要展示每个考试的min&max&average 分数
 * 
 * final score算法：quiz1*.1+quiz2*.1+quiz3*.1+quiz4*.1+midi*.2+midii*.15+final*.25
 * A for final score>=90%
 * B :80%-89%
 * C:70%-79%
 * D:60%-69%
 * F: <= 59%
 * 
 * sample input file 和output file和console界面如截图所示
 */