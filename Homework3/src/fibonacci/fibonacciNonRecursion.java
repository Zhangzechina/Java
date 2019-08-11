package fibonacci;

import java.util.Scanner;

public class fibonacciNonRecursion {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner input = new Scanner(System.in);
		System.out.println("Please input a number:");
		long number = input.nextLong();
		input.close();              //close input
		long result = fibNonrecursion(number);
		System.out.println("The result is:" + result);
	}

	public static long fibNonrecursion(long n) {
		long result = 0;        
		long small = 1;
		long big = 1;
		long m = 0;
		if (n == 1 || n == 2)
			result = 1;
		if (n > 2) 
		{
			for (int i = 3; i <= n; i++) 
			{
				m = small + big;                // 算出前两个数之和
				small = big;                    //将第二个值者赋给小值
				big = m;                      //将第三个值赋给大值
			}
			result = m;
		}
		return result;
	}

}
