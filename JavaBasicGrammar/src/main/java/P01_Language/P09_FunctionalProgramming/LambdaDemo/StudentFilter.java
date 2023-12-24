package P01_Language.P09_FunctionalProgramming.LambdaDemo;

@FunctionalInterface
public interface StudentFilter {
	boolean compare(Student student);
}