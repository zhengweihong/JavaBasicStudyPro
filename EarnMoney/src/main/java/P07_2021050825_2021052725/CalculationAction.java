package P07_2021050825_2021052725;

import java.util.InputMismatchException;
import java.util.Scanner;
import static java.lang.System.exit;

public class CalculationAction {
	/*
	* This is solution for Midterm Project *
	* all the functions tested from one main method. *
	* @author yuchenwu * @version 1.0
	* @since 07-05-2021 *
	*/
	
	static void showUserChoice(){
		//arrange the user interface
		System.out.println("Welcome to Yurchen WU's Handy Calculator");
		System.out.println("\n");
		System.out.println("\t1.Addition");
		System.out.println("\t2.Substraction");
		System.out.println("\t3.Multiplication");
		System.out.println("\t4.Division");
		System.out.println("\t5.Exit");
		System.out.println();
	}
	
	static int getUserChoice() {
		//ask for valid input，once users entered numbers out of given range or in character forms
		//the exception will be caught and report to users and ask for input again
		
		Scanner readInput = new Scanner(System.in);
		int inputInt = 0;

		do {//loop until we have correct input
			System.out.printf("Enter your choice between 1 and 5 only: ");	
			try {
				inputInt = readInput.nextInt();
				//wait for input,if input is right, then break
				if(inputInt >= 1 && inputInt <= 5) {
					break;
				}//close the "if"
				 else {
					System.out.println("you have not entered a number between 1 and 5, try again.");
					readInput.nextLine();
					continue;//go on the loop once the input is wrong
				     }//close the "else"
			    }//close the"try"
			catch(final InputMismatchException e ) {
				System.out.println("You have entered an invalid choice. Try again.");
				readInput.nextLine(); // continue asking for valid input
				continue;
			}//close the 'catch'
				
		} while(true);

		return inputInt;
	}
	
	static void doTheCalculation(int inputInt) {//形式参数
		float[] nums = new float[2];

		switch(inputInt) {//how to get this input value from upper method????
			case 1:
				System.out.print("Please enter two floats to add, separated by a space: ");
				nums = getTwoNums();
				System.out.printf("Result of %f add %f is %f." ,nums[0],nums[1],nums[0] + nums[1]);
				break;
			case 2:
				System.out.print("Please enter two floats to subtract, separated by a space: ");
				nums = getTwoNums();
				System.out.printf("Result of %f subtract %f is %f." ,nums[0],nums[1],nums[0] - nums[1]);
				break;
			case 3:
				System.out.print("Please enter two floats to multiply, separated by a space: ");
				nums = getTwoNums();
				System.out.printf("Result of %f multiply %f is %f." ,nums[0],nums[1],nums[0] * nums[1]);
				break;
			case 4:
				System.out.print("Please enter two floats to divide, separated by a space: ");
				while (true) {
					nums = getTwoNums();
					try {
						float cal = nums[0] / nums[1];
						System.out.printf("Result of %f divide %f is %f." ,nums[0],nums[1],cal);
						break;
					}catch (ArithmeticException e) {
						System.out.println("the second number cannot be zero. Try again.");
						continue;
					}
				}
				break;
			case 5:
				System.out.printf("Thank you for using Yuchen Wu's Handy Calculator!");
				exit(0);
			default:
				System.out.println("Unknown Choice");
    	}
		System.out.printf("\n\n");
	}

	static float[] getTwoNums() {
		Scanner getInput = new Scanner(System.in);
		float[] nums = new float[2];
		try {
			nums[0]=getInput.nextFloat();
			nums[1]=getInput.nextFloat();
		} catch(final InputMismatchException e ) {
			System.out.println("you have entered invalid floats. Try again.");
			getInput.nextLine(); // continue asking for valid input
		}//close the 'catch'
		return nums;
	}

	public static void main(String[] args) {
		//loop output menu
		while(true){
			// call all the methods
			showUserChoice();
			int inputInt = getUserChoice();
			doTheCalculation(inputInt);
		}

		//循环全部方法
		//输出目录
		//get用户输入，同时如果输入不是1-5，让用户重新输入
		//输入1-4：判定输入合法-除法第二个!=0，计算
		//输入5：感谢使用
	}
}
