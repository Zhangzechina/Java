package Zhang.ze;
import java.util.*;

public class TestStack {
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
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
				  System.out.println("ջ��");
				Display();
				break;
			case "3":
				stack.clearTheStack();
				Display();
				break;
			case "4":
				System.out.println("ջ��Ԫ��Ϊ "+stack.peek());
				Display();
				break;
			case "5":
				System.out.println("���� "+stack.getSize()+" ������");
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
		System.out.println("------------1:��ջ-------------");
		System.out.println("------------2:��ջ-------------");
		System.out.println("-----------3:���ջ------------");
		System.out.println("--------4:����ջ��Ԫ��----------");
		System.out.println("------5:���ջ��Ԫ�ظ���---------");
		System.out.println("------------0:�˳�-------------");
	}
	
	
}

class StackOfNumbers
{
	private int[] elements;
	private int size;
	public static final int DEFAULT_CAPACITY=160;
	
	//����һ����Ĭ�ϴ�Сջ
	public StackOfNumbers()
	{
		elements=new int[DEFAULT_CAPACITY];
	}
	
	//����һ����ȷ��ֵ��ջ
	public StackOfNumbers(int number)
	{
		elements=new int[number];
	}
	
	//��һ�������浽ջ��
	public void push(int value)
	{
		if(size>=elements.length)               //ջ�������������������ڴ洢�������¿ռ�
		{
			int temp[]=new int[elements.length];
			System.arraycopy(elements, 0, temp,0, elements.length);
			elements=temp;
		}
		elements[size++]=value;
	}
	
	//�ж�ջ�Ƿ�Ϊ��
	public boolean empty()                   
	{
		if(size==0)
			return true;
		else 
		    return false;
	}
	
	//����ջ������
	public int peek()
	{
		return elements[size-1];
	}
	
	//ɾ��ջ��Ԫ�ز����أ���ջ
	public int pop()
	{
		return elements[--size];
	}
	
	//����ջ����������
	public int getSize()
	{
		return size;
	}
	
	//��ջ��Ԫ������������ջ˳��
	public void clearTheStack()
	{
		while(!this.empty())
		{
			System.out.print(this.pop()+" ");
		}
		System.out.println("ջ����գ�");
	}
	
}
