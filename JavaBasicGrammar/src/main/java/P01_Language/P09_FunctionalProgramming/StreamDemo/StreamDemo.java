package P01_Language.P09_FunctionalProgramming.StreamDemo;

import java.util.*;
import java.util.stream.*;

public class StreamDemo {

	public static void main(String[] args) {
		//数组
		String[] strs = {"a","b","c","d","e"};
		Stream<String> sArray = Stream.of(strs);
		sArray.forEach(System.out::println);//forEach(Consumer)
		
		//集合
		List<String> list = Arrays.asList("a","b","c","d","e");
		Stream<List<String>> sList1 = Stream.of(list);//此方式不行，会把List整个作为一个元素
		Stream<String> sList2 = list.stream();
		sList1.forEach(System.out::println);
		sList2.forEach(System.out::println);
		
		//Stream.generate方法+limit
		Stream<Integer> sGenerate = Stream.generate( ()->1 );
		sGenerate.limit(5).forEach(System.out::println);
		
		//Stream.iterate方法
		Stream<Integer> sIterate = Stream.iterate(1,x->x+1);
		sIterate.limit(5).forEach(System.out::println);
		
		//其他
		String str = "abcdef";
		IntStream sIntStream = str.chars();
//		sIntStream.forEach(System.out::println);//输出int值
		sIntStream.forEach((e)->System.out.println((char)e));
		
		
		
		//中间操作：返回结果是Stream对象；终止操作
		List<Integer> list_middle = Arrays.asList(1,2,3,4,5);
		
		
		//输出偶数
		list_middle.stream().filter( (x)->x%2==0 ).forEach(System.out::println);
		//求集合中所有偶数的和
		int sum = list_middle.stream().filter( (x)->x%2==0 ).mapToInt(x->x).sum();
		System.out.println(sum);
		//求集合中最大值、最小值
			//Comparator比较器，前-后>0，正常逻辑
		Optional<Integer> max = list_middle.stream().max((a,b)->a-b);
			//逻辑与max相反
		Optional<Integer> min1 = list_middle.stream().max((a,b)->b-a);
		Optional<Integer> min2 = list_middle.stream().min((a,b)->a-b);
		System.out.println(max.get());
		System.out.println(min1.get());
		System.out.println(min2.get());
		System.out.println( list_middle.stream().min( (a,b)->a-b ).get() );
		
		
		//求集合中最大值、最小值，sorted，不用max、min方法
		Optional<Integer> manualMin = list_middle.stream().sorted().findFirst();
		System.out.println(manualMin.get());
		Optional<Integer> manualMax = list_middle.stream().sorted((a,b)->b-a).findFirst();
		System.out.println(manualMax.get());
		
		//字典序、自定义长度排序
		Arrays.asList("java","c#","python","scala").stream().sorted().forEach(System.out::println);
		Arrays.asList("java","c#","python","scala").stream().sorted( (a,b)->a.length()-b.length() ).forEach(System.out::println);
		
		
		Optional<Integer> any = list_middle.stream().filter( x->x%2==0 ).findAny();
		Optional<Integer> fir = list_middle.stream().filter( x->x%2==0 ).findFirst();
		System.out.println(any.get());
		System.out.println(fir.get());
		
		//执行逻辑问题
		Stream<Integer> sFindAny = list_middle.stream().filter( i-> {
			System.out.println("run once");
			return i%2==0;
		});
		System.out.println( sFindAny.findAny().get() );
		//会打印2次run once，因为取一个i走filter之后直接就findAny，不是全filter后再...
		
		
		//匹配
		System.out.println( list_middle.stream().allMatch( x->x>=0 ) );//true
		
		
		//将集合中元素，过滤同时返回一个集合对象
		List<Integer> returnList = list_middle.stream().filter( x->x%2==0 ).collect(Collectors.toList());
		returnList.forEach(System.out::println);
		
		
		//去重distinct
		Arrays.asList(1,2,3,3,3,4,5,2).stream().distinct().forEach(System.out::println);
		//去重非distinct，用Set集合特性
		Arrays.asList(1,2,3,3,3,4,5,2).stream().collect(Collectors.toSet()).forEach(System.out::println);
		
		
		//截取 limit限制、skip跳过
		//打印21-30这样的集合数据
        Stream.iterate(1,x->x+1).limit(50).skip(20).limit(10).forEach(System.out::println);
        
        
        String str2 ="11,22,33,44,55";
        //分割字符串，求和
        System.out.println( Stream.of(str2.split(",")).mapToInt(x->Integer.parseInt(x)).sum() );
        System.out.println( Stream.of(str2.split(",")).mapToInt(Integer::parseInt).sum() );
        //peek提供了一种对流中所有元素操作的方法，而不会把这个流消费掉
        System.out.println( Stream.of(str2.split(",")).peek(System.out::println).mapToInt(Integer::valueOf).sum() );
        
        
        //对自定义对象的操作
        String str3 = "java,scala,python";
        //构造
        Stream.of(str3.split(",")).map( x-> new Language(x) ).forEach(System.out::println);
        Stream.of(str3.split(",")).map( Language::new ).forEach(System.out::println);
        //静态
        Stream.of(str3.split(",")).map( x-> Language.build(x) ).forEach(System.out::println);
        Stream.of(str3.split(",")).map( Language::build ).forEach(System.out::println);
	}

}

class Language {
	private String name;
	
	public Language() {
		
	}

	public Language(String name) {
		this.name = name;
	}
	
	public static Language build(String name) {
		Language l = new Language();
		l.setName(name);
		return l;
	}

	@Override
	public String toString() {
		return "Language [name=" + name + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}