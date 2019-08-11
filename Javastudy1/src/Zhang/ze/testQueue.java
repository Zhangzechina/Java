package Zhang.ze;

import java.util.Scanner;

public class testQueue {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
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
				  System.out.println("����Ϊ��");
				Display();
				break;
			case "3":
				queue.clearTheStack();
				Display();
				break;
			case "4":
				System.out.println("����ͷԪ��Ϊ "+queue.peek());
				Display();
				break;
			case "5":
				System.out.println("���� "+queue.getSize()+" ������");
				Display();
				break;
			case "6":
				if(queue.empty())
				System.out.println("����Ϊ�գ�");
				else
				System.out.println("���зǿգ�");
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
		System.out.println("------------1:�����-------------");
		System.out.println("------------2:������-------------");
		System.out.println("-----------3:��ն���------------");
		System.out.println("--------4:���ض���ͷԪ��----------");
		System.out.println("------5:���������Ԫ�ظ���---------");
		System.out.println("------6:�ж϶������Ƿ�Ϊ��---------");
		System.out.println("------------0:�˳�-------------");
	}  


}

class QueueOfNum
{
	private int[] elements;
	private int size;
	public static final int DEFAULT_CAPACITY=160;
	
	//����һ����Ĭ�ϴ�С����
	public QueueOfNum()
	{
		elements=new int[DEFAULT_CAPACITY];
	}
	
	//����һ����ȷ��ֵ�Ķ���
	public QueueOfNum(int number)
	{
		elements=new int[number];
	}
	
	//��һ�������浽����
	public void push(int value)
	{
		if(size>=elements.length)               //�����������������������ڴ洢�������¿ռ�
		{
			int temp[]=new int[elements.length];
			System.arraycopy(elements, 0, temp,0, elements.length);
			elements=temp;
		}
		elements[size++]=value;
	}
	
	//�ж϶����Ƿ�Ϊ��
	public boolean empty()                   
	{
		if(size==0)
			return true;
		else 
		    return false;
	}
	
	//���ض���ͷԪ��
	public int peek()
	{
		return elements[0];
	}
	
	//ɾ������ͷ�����أ�����
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
	
	//���ض���������������
	public int getSize()
	{
		return size;
	}
	
	//����������Ԫ��������������˳��
	public void clearTheStack()
	{
		while(!this.empty())
		{
			System.out.print(this.pop()+" ");
		}
		System.out.println("��������գ�");
	}
}

