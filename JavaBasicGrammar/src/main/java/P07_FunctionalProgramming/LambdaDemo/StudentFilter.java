package P07_FunctionalProgramming.LambdaDemo;

@FunctionalInterface
public interface StudentFilter {
	boolean compare(Student student);
}