package fibonacci;

import java.util.Scanner;

public class fibnacciRecursion {
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner input = new Scanner(System.in);
		System.out.println("Please input a number:");
		int number = input.nextInt();
		input.close();
		int result = Fibonacci(number);
		System.out.println("The result is:" + result);
	}

	public static int Fibonacci(int n) 
	{
		int result = 0;
		if (n == 1 || n == 2)
			result = 1;
		if (n > 2)
			result = Fibonacci(n - 1) + Fibonacci(n - 2);
		return result;
	}

}
