package binarySearching;

import java.util.Scanner;

public class binarysearch {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] list = new int[10];
		Scanner input = new Scanner(System.in);
		int key=0;
		if(args.length!=1)
		{
			System.out.println("wrong input!");
			System.exit(0);
		}
		switch(args[0].charAt(0))
		{
		case '1': 
					System.out.println("please input " + list.length + " values:");
					for (int i = 0; i < list.length; i++) 
					{
						list[i] = input.nextInt();
					}
					System.out.println("Please input what you want to search:");
					key = input.nextInt();
					input.close();
					recursionSearch_1(list, key, 0, list.length - 1);
					break;
		case '2':
			System.out.println("please input " + list.length + " values:");
			for (int i = 0; i < list.length; i++) {
				list[i] = input.nextInt();
			}
			System.out.println("Please input what you want to search:");
			key = input.nextInt();
			recursionSearch_2(list, key,0,list.length-1);
			input.close();
				   
	     }
	}
	
	public static void recursionSearch_1(int[] list, int key, int low, int high) 
	   {
		int mid = 0;
		mid = (low + high) / 2;
		if (low > high)
			System.out.println("Don't exixt! It should be inserted in " + low);
		else 
		{
			if (key == list[mid]) 
			{
				int i = mid - 1;
				while (list[i] == list[mid]) 
				{
					i--;
					if(i==-1)
						break;
				}
				System.out.println("The first index is " + (i + 1));
			} 
			else if (key < list[mid])
				recursionSearch_1(list, key, low, mid - 1);
			else
				recursionSearch_1(list, key, mid + 1, high);
		}
	   }
	
	public static void recursionSearch_2(int[] list, int key, int low, int high) {
		int mid = 0;
		mid = (low + high) / 2;
		if (low > high)
			System.out.println("Don't exixt! It should be inserted in " + low);
		else 
		{
			if (key == list[mid]) 
			{
				int i = mid;
				while (list[i] == list[mid]) 
				{
					i++;
					if(i==list.length)
						break;
				}
				System.out.println("The last index is " + (i-1));
			} 
			else if (key < list[mid])
				recursionSearch_2(list, key, low, mid - 1);
			else
				recursionSearch_2(list, key, mid + 1, high);
		}
	}
		
}
