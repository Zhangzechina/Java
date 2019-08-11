package Zhang.ze;
import java.util.*;

public class TestStack {
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner input=new Scanner(System.in);
		StackOfNumbers stack=new StackOfNumbers();
		int con=1;
		Display();
		while(con!=0)
		{
			String choice=input.nextLine();
			switch(choice)
			{
			case "1":
				int value=input.nextInt();
				stack.push(value);
				Display();
				break;
			case "2":
				if(!stack.empty())
				  stack.pop();
				else
				  System.out.println("栈空");
				Display();
				break;
			case "3":
				stack.clearTheStack();
				Display();
				break;
			case "4":
				System.out.println("栈顶元素为 "+stack.peek());
				Display();
				break;
			case "5":
				System.out.println("共有 "+stack.getSize()+" 个整数");
				Display();
				break;
			case "0":
				con=0;
			}
		}
		input.close();
	}
	
	public static void Display()
	{
		System.out.println("------------1:入栈-------------");
		System.out.println("------------2:出栈-------------");
		System.out.println("-----------3:清空栈------------");
		System.out.println("--------4:返回栈顶元素----------");
		System.out.println("------5:输出栈内元素个数---------");
		System.out.println("------------0:退出-------------");
	}
	
	
}

class StackOfNumbers
{
	private int[] elements;
	private int size;
	public static final int DEFAULT_CAPACITY=160;
	
	//构造一个有默认大小栈
	public StackOfNumbers()
	{
		elements=new int[DEFAULT_CAPACITY];
	}
	
	//构造一个有确定值的栈
	public StackOfNumbers(int number)
	{
		elements=new int[number];
	}
	
	//将一个整数存到栈顶
	public void push(int value)
	{
		if(size>=elements.length)               //栈中整数个数超过数组内存储，申请新空间
		{
			int temp[]=new int[elements.length];
			System.arraycopy(elements, 0, temp,0, elements.length);
			elements=temp;
		}
		elements[size++]=value;
	}
	
	//判断栈是否为空
	public boolean empty()                   
	{
		if(size==0)
			return true;
		else 
		    return false;
	}
	
	//返回栈顶整数
	public int peek()
	{
		return elements[size-1];
	}
	
	//删除栈顶元素并返回，出栈
	public int pop()
	{
		return elements[--size];
	}
	
	//返回栈中整数个数
	public int getSize()
	{
		return size;
	}
	
	//将栈内元素清空且输出出栈顺序
	public void clearTheStack()
	{
		while(!this.empty())
		{
			System.out.print(this.pop()+" ");
		}
		System.out.println("栈已清空！");
	}
	
}
