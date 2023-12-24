package P01_Language.P09_FunctionalProgramming.LambdaDemo;

import java.util.ArrayList;

public class Code01_LambdaDemo {

	public static void main(String[] args) {
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName()+"running...1");
			}
		});
		thread1.start();
		
		new Thread(()->{
			System.out.println(Thread.currentThread().getName()+"running...2");
		}).start();
		
		
		Runnable runnable1 = new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName()+"running...1");
			}
		};
		runnable1.run();
		
		Runnable runnable2 = ()->{
			System.out.println(Thread.currentThread().getName()+"running...2");
		};
		runnable2.run();
		
		Runnable runnable3 = ()->System.out.println("running...3");
		runnable3.run();
		
		
		Code02_CustomLambdaInterface cli1 = new Code02_CustomLambdaInterface() {
			@Override
			public void insert(int insertInt) {
				System.out.println("insert a number"+insertInt);
			}
		};
		cli1.insert(404);
		
		Code02_CustomLambdaInterface cli2 = (insertInt)->{
			System.out.println("insert a number"+insertInt);
		};
		cli2.insert(500);
		
		Code02_CustomLambdaInterface cli3 = (int insertInt)->
			System.out.println("insert a number"+insertInt);
		cli3.insert(200);
		
		
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(new Student("zhangsan",14,6));
		list.add(new Student("lisi",13,89));
		list.add(new Student("wangwu",15,97));
		list.add(new Student("maliu",12,63));
		list.add(new Student("zhaoqi",17,75));
		
		getByFilter(list,(s)->s.getAge()>14);
		getByFilter(list,(s)->s.getScore()<60);
	}
	
	public static void getByFilter(ArrayList<Student> list, StudentFilter filter) {
		ArrayList<Student> listByFilter = new ArrayList<Student>();
		for(Student student:list) {
			if(filter.compare(student)) {
				listByFilter.add(student);
			}
		}
		printStudent(listByFilter);
	}
	
	public static void printStudent(ArrayList<Student> list) {
		for(Student student:list) {
			System.out.println(student.toString());
		}
	}

}
