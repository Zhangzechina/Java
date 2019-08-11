package binarySearching;

import java.util.*;

public class Binary_end {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] list = new int[10];
		Scanner input = new Scanner(System.in);
		System.out.println("please input " + list.length + " values:");
		for (int i = 0; i < list.length; i++) 
		{
			list[i] = input.nextInt();
		}
		System.out.println("Please input what you want to search:");
		int key = input.nextInt();
		recursionSearch(list, key,0,list.length-1);
		input.close();
	}

	public static void recursionSearch(int[] list, int key, int low, int high) {
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
				recursionSearch(list, key, low, mid - 1);
			else
				recursionSearch(list, key, mid + 1, high);
		}
	}

}
