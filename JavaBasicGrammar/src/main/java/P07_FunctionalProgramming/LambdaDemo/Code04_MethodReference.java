package P07_FunctionalProgramming.LambdaDemo;

import java.util.*;
import java.util.function.*;

public class Code04_MethodReference {

	public static void main(String[] args) {
		//静态方法引用
		UnaryOperator<String> uo1 = (str)->Code04_MethodReference.put(str);
		UnaryOperator<String> uo2 = Code04_MethodReference::put;
		System.out.println(uo1.apply("s1"));
		System.out.println(uo2.apply("s2"));
		
		//实例方法引用
		Function<String,Integer> f1 = (str)->new Code04_MethodReference().get(str);
		Function<String,Integer> f2 = (str)->{return new Code04_MethodReference().get(str);};
		Function<String,Integer> f3 = new Code04_MethodReference()::get;
		System.out.println(new Code04_MethodReference().get("getTest"));//原始的实例化
		System.out.println(f1.apply("f1"));
		System.out.println(f2.apply("f2"));
		System.out.println(f3.apply("f3"));
		
		//对象方法引用-第一个参数=调用方法的类
		BiConsumer<Tool,String> bc1 = (Tool,str)->new Tool().show(str);
		//左边类型，必须和右边()内类型相同
		BiConsumer<Tool2,String> bc2 = (Tool2 Tool,String str)->new Tool().show(str);
		//左边类的类型，必须和右边类的类型相同
		BiConsumer<Tool,String> bc3 = Tool::show;
		bc1.accept(new Tool(),"bc1");
		bc2.accept(new Tool2(),"bc2");//此处也是Tool2
		bc3.accept(new Tool(),"bc3");
		
		//构造方法引用
		Tool3 t31 = new Tool3();//调用无参构造方法
		
		Supplier<Tool3> t32 = ()->new Tool3();//没有调用任何构造
		t32.get();//调用无参构造方法
		Supplier<Tool3> t33 = Tool3::new;
		t33.get();
		
		Supplier<List> s1 = 	ArrayList::new;
		System.out.println(s1.get());//[]
		Supplier<Set> s2 = 		HashSet::new;
		System.out.println(s2.get());//[]
		Supplier<Thread> s3 = 	Thread::new;
		System.out.println(s3.get());//Thread[Thread-0,5,main]
		Supplier<String> s4 = 	String::new;
		System.out.println(s4.get());//\n
		UnaryOperator<Integer> uo5 = Integer::new;//Integer必须有入参
		System.out.println(uo5.apply(5));//5
	}
	
	static String put(String str) {
		System.out.println("put...");
		return str;
	}
	
	public int get(String str) {
		System.out.println("get...");
		return str.length();
	}

}

class Tool {
	public void show(String str) {
		System.out.println("show Tool "+str);
	}
}

class Tool2 {
	public void show(String str) {
		System.out.println("show Tool2 "+str);
	}
}

class Tool3 {
	public Tool3() {
		System.out.println("No args Construction Method");
	}
}