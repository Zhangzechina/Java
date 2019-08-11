package Zhang.ze;

import java.util.Scanner;

public class testQueue {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner input=new Scanner(System.in);
		QueueOfNum queue=new QueueOfNum();
		int con=1;
		Display();
		while(con!=0)
		{
			String choice=input.nextLine();
			switch(choice)
			{
			case "1":
				int value=input.nextInt();
				queue.push(value);
				Display();
				break;
			case "2":
				if(!queue.empty())
					queue.pop();
				else
				  System.out.println("队列为空");
				Display();
				break;
			case "3":
				queue.clearTheStack();
				Display();
				break;
			case "4":
				System.out.println("队列头元素为 "+queue.peek());
				Display();
				break;
			case "5":
				System.out.println("共有 "+queue.getSize()+" 个整数");
				Display();
				break;
			case "6":
				if(queue.empty())
				System.out.println("队列为空！");
				else
				System.out.println("队列非空！");
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
		System.out.println("------------1:入队列-------------");
		System.out.println("------------2:出队列-------------");
		System.out.println("-----------3:清空队列------------");
		System.out.println("--------4:返回队列头元素----------");
		System.out.println("------5:输出队列内元素个数---------");
		System.out.println("------6:判断队列中是否为空---------");
		System.out.println("------------0:退出-------------");
	}  


}

class QueueOfNum
{
	private int[] elements;
	private int size;
	public static final int DEFAULT_CAPACITY=160;
	
	//构造一个有默认大小队列
	public QueueOfNum()
	{
		elements=new int[DEFAULT_CAPACITY];
	}
	
	//构造一个有确定值的队列
	public QueueOfNum(int number)
	{
		elements=new int[number];
	}
	
	//将一个整数存到队列
	public void push(int value)
	{
		if(size>=elements.length)               //队列中整数个数超过数组内存储，申请新空间
		{
			int temp[]=new int[elements.length];
			System.arraycopy(elements, 0, temp,0, elements.length);
			elements=temp;
		}
		elements[size++]=value;
	}
	
	//判断队列是否为空
	public boolean empty()                   
	{
		if(size==0)
			return true;
		else 
		    return false;
	}
	
	//返回队列头元素
	public int peek()
	{
		return elements[0];
	}
	
	//删除队列头并返回，出队
	public int pop()
	{
		//int index=1;
		int temp = elements[0];  
	    for(int j=1;j<elements.length;j++)
	    {  
	    	elements[j-1] =elements[j];  
	    	//index++;
	    }
	    //i=index;
	    size--;
	    return temp;
	}
	
	//返回队列中中整数个数
	public int getSize()
	{
		return size;
	}
	
	//将队列内内元素清空且输出出队顺序
	public void clearTheStack()
	{
		while(!this.empty())
		{
			System.out.print(this.pop()+" ");
		}
		System.out.println("队列已清空！");
	}
}

