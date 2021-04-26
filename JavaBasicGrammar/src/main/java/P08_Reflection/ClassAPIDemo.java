package P08_Reflection;

import java.lang.reflect.*;

public class ClassAPIDemo {
	public String strDemo;
	private int integerDemo;

	public static void main(String[] args) throws Exception {
		//获取Class对象
		Class classObject = Class.forName("P08_Reflection.ClassAPIDemo");
		
		//获取public公共的成员变量，包括父类和子类
		Field[] fs = classObject.getFields();
		for(Field f:fs) {
			System.out.println( f );//属性对象
			System.out.println( f.getName() );//属性名称
			System.out.println( f.getType() );//属性类型
			System.out.println( f.getModifiers() );//访问修饰符int形式
		}
		
		//获取当前类的所有属性，必须使用
		Field[] dfs = classObject.getDeclaredFields();
		for(Field f:dfs) {
			System.out.println( f.getName() );
		}
		
		//反射一定程度上破坏了封装性
		Field strDemoIn = classObject.getDeclaredField("strDemo");
		strDemoIn.setAccessible(true);//private也能访问，设置是否能被访问
		Object o = classObject.getDeclaredConstructor().newInstance();
		strDemoIn.set(o,"put a str");
		System.out.println(((ClassAPIDemo) o).getStrDemo());
		
		//获取普通方法，1h31min
		Method[] ms = classObject.getMethods();
		for(Method m:ms) {
			System.out.println( m );
			System.out.println( m.getName() );
			System.out.println( m.getParameters() );
			System.out.println( m.getModifiers() );
		}
	}
	
	public String getStrDemo() {
		return strDemo;
	}

	public void setStrDemo(String strDemo) {
		this.strDemo = strDemo;
	}

	public int getIntegerDemo() {
		return integerDemo;
	}

	public void setIntegerDemo(int integerDemo) {
		this.integerDemo = integerDemo;
	}

}
