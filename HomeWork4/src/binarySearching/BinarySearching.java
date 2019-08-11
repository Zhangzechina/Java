package binarySearching;
import java.util.*;

public class BinarySearching {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int [] list=new int[10];
		Scanner input=new Scanner(System.in);
		System.out.println("please input "+list.length+" values:");
		for(int i=0;i<list.length;i++)
		{
			list[i]=input.nextInt();
		}
		System.out.println("Please input what you want to search:");
		int key=input.nextInt();
		input.close();
		int result=recursionSearch(list,key,0,list.length-1);
		System.out.println("The index is "+result);
	}
	public static int recursionSearch(int[] list,int key,int low,int high)
	{
		int mid=(low+high)/2;
		if(low>high)
			return -1;
		else if(key==list[mid]) 
			return mid;
		else if(key<list[mid])
			return recursionSearch(list,key,low,mid-1);
		else 
		   	return recursionSearch(list,key,mid+1,high);
	}

}
