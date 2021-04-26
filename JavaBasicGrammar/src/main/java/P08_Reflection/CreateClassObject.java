package P08_Reflection;

public class CreateClassObject {

	public static void main(String[] args) throws ClassNotFoundException {
		//获取Class对象：第三种不建议使用
		//Class.forName(类完整路径)
		Class class1 = Class.forName("P08_Reflection.CreateClassObject");
		//类名.class
		Class class2 = CreateClassObject.class;
		//实例化对象.getClass()
		Class class3 = new CreateClassObject().getClass();
		//基本数据类型：.Type/.class
		Class class4 = Integer.TYPE;
		
		System.out.println(class1);
		System.out.println(class1.getPackage());
        System.out.println(class1.getName());
        System.out.println(class1.getSimpleName());
        System.out.println(class1.getCanonicalName());
	}

}
