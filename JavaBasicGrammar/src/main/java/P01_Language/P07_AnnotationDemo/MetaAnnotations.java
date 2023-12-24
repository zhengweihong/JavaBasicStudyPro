package P01_Language.P07_AnnotationDemo;

import java.lang.annotation.*;

public class MetaAnnotations {

	public static void main(String[] args) {
		
	}
	
	@Target({ElementType.METHOD,ElementType.TYPE})
	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	@Inherited
	public @interface MyAnnotation {
		String name() default "zhangsan";
		int age() default 20;
		int id() default 1;
		String[] params() default {"a","b","c"};
	}
}