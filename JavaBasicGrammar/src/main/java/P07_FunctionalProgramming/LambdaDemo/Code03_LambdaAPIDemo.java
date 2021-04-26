package P07_FunctionalProgramming.LambdaDemo;

import java.util.function.*;

public class Code03_LambdaAPIDemo {

	public static void main(String[] args) {
		//只一个输出
		Supplier<String> s1 = ()->{return "s1";};
		Supplier<String> s2 = ()->"s2";
		s1.get();
		s2.get();
		
		
		//只一个输入
		Consumer<String> c1 = (str)->System.out.println(str);
		c1.accept("c1");
		
		//两个输入
		BiConsumer<String,String> bc1 = (str1,str2)->System.out.println(str1+str2);
		bc1.accept("b","c");
		
		
		//一个输入，一个输出，且一般类型不同
		Function<String,Integer> f1 = (str)->{return str.length();};
		System.out.println( f1.apply("aaaaaaa") );
		
		//一个输入，一个输出，类型相同
		UnaryOperator<String> uo1 = (str)->"str";
		System.out.println( uo1.apply("uo") );
		
		
		//两个输入，一个输出，且一般类型不同
		BiFunction<String,String,Integer> bf1 = (str1,str2)->str1.length()+str2.length();
		System.out.println( bf1.apply("b","f") );
		
		//两个输入，一个输出，类型相同
		BinaryOperator<String> bo1 = (str1,str2)->str1+""+str2;
		System.out.println( bo1.apply("b","f") );
	}

}
