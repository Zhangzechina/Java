//�ó����ǹ�����ȱ�����������ȱ����������棬�����й�����ȱ����Ķ���ɾ�����ĳɿɱ䳤���б�ArrayList

package zhang.ze;

import java.util.*;

//���ࣨ���ڽӾ���
class EdgeElement
{
	int fromvex=0;
	int endvex=0;
	int weight=0;
	
	//Ĭ�Ϲ��캯��
	EdgeElement()
	{
		
	}
	
	//��������
	public void createEdgeElement(int v1,int v2)
	{
		fromvex=v1;
		endvex=v2;
		weight=1;
	}
	
}

//�ڵ���
class Node {
	String data; // �ڵ���Ϣ�����֣�
	Node next; // ��һ�ڵ������
  
	Node() // ���캯��
	{

	}

	public void CreateNode(int dt, Node nt) // ��ʼ���ڵ㺯��
	{
		this.data = "V" + dt;
		this.next = nt;
	}
}

//�ڽӾ����ʾ��ͼ��
class AMGGraph
{
	EdgeElement[] vertex;     //�߾���
	int[][] edge;          //�ڽӾ���
	int verNum=0;            //������
	int edgeNum=0;           //����
	
	//���캯��
	AMGGraph()
	{
	
	}
	
	Scanner input=new Scanner(System.in);	
	//��ʼ���ڽӾ���
	public void CreateAMGGraph()
	{
		System.out.println("�����붥����a�ͱ߸���b��");
		int a=input.nextInt();
		int b=input.nextInt();
		edge=new int[a+2][a+2];              //Ϊ���±�ͳһ�������е�Ԫ��Ӧ�ȶ��������������ٴ�2
		for(int i=0;i<b;i++)
		{
			verNum=a;            //������
			edgeNum=b;           //����
		}
		
		vertex=new EdgeElement[b+1];         //�߾�������ıȱ�����һ
		for(int i=1;i<=edgeNum;)
		{
			System.out.println("������ߵ�������v1��v2��");
			int v1=input.nextInt();
			int v2=input.nextInt();
			vertex[i]=new EdgeElement();            //Ӧ�ù��캯���Ա߾����ÿһ��Ԫ�ؽ��г�ʼ��
			vertex[i].createEdgeElement(v1, v2);    //������ÿһ�������ı�
			if(v1<0||v1>a||v1<0||v2>a)
				System.out.println("����������������룡");
			else 
				i++;
		}
		for(int i=1;i<=edgeNum;)
		{
			int p=vertex[i].fromvex;                //�ҵ��ߵ�ǰһ������
			int q=vertex[i].endvex;                 //�ҵ��ߵĺ�һ������
			
			    edge[p][q]=edge[q][p]=1;      
			    i++;//��������ĳ�ʼ��
			
		}
	}

	//��ʾ�ڽӾ���
	public void disPlayAMGGraph()
	{
		System.out.print("   ");
		for(int i=1;i<=verNum;i++)                 //��1��ʼ��Ϊ���±�������ͳһ
		{
			System.out.print("V"+i+" ");           //������Ҫ��Ϊ����ʾ���򶥵���
		}
		System.out.println();
		for(int i=1;i<=verNum;i++)                 //��1��ʼ��Ϊ���±�������ͳһ
		{
			System.out.print("V"+i+" ");           //������Ҫ��Ϊ����ʾ���򶥵���
			for(int j=1;j<=verNum;j++)             //��1��ʼ��Ϊ���±�������ͳһ
			{
				System.out.print(edge[i][j]+"  ");
			}
			System.out.println();
		}
	}
	
	//�õ���һ�ڽӽڵ������
	public int getFirstNeighbour(int index)
	{
		for(int j=1;j<=verNum;j++)
		{
			if(edge[index][j]==1)                 //�������еĵ�һ��Ԫ�ؿ�ʼ����Ƿ�����֮�����Ķ���
			{
				return j;
			}
		}
		return -1;
	}
	
	//����ǰһ�ڽӽ����������һ���ڽӽڵ�ĵ�����
		public int getNextNeighbour(int v1,int v2)
		{
			for(int j=v2+1;j<=verNum;j++)
			{
				if(edge[v1][j]==1)                //�������еĵ�v2��Ԫ��֮��ʼ����Ƿ�����֮�����Ķ���
				{
					return j;
				}
			}
			return -1;
		}
		
		//�õ���һ���ڽӽڵ������
		public int getLastNeighbour(int index)
		{
			for(int i=1;i<index;i++)
			{
				if(edge[i][index]==1)                 //�������еĵ�һ��Ԫ�ؿ�ʼ����Ƿ�����֮�����Ķ���
				{
					return i;
				}
			}
			return -1;
		}
	
	//�ڽӾ����Ӧ�Ĺ�����ȱ���
    boolean[] visited=new boolean[10000];   //��־����

	public void BFS_a(AMGGraph mygraph, int v) 
	{
		visited[v] = true;                                              // ��ʼ����v�ѱ�����
		System.out.print("V" + v);
		ArrayList<Integer> judgment = new ArrayList<>();
			judgment.add(v);                                             // ��v����ArrayList
			while (!judgment.isEmpty())                                  // ArrayList�ǿ�
			{
				int u = judgment.get(0);                                 // uΪ��ǰ�б�ͷԪ��
				judgment.remove(0);                                      // ͷԪ��ɾ��
				int w = getFirstNeighbour(u);                            // w��Ϊ�¸���֮���ڵĽ��
				while (w != -1) {
					if (!visited[w]) {
						System.out.print("---->V" + w);
						visited[w] = true;
						judgment.add(w);                                 // δ�����������ڵĽ����б�
					}
					w = getNextNeighbour(u, w);                          // ��u�����w��һ�����ڵ�
				}
			}
			System.out.println();
		for(int i=1;i<=mygraph.verNum;i++)             //��Ϊ����ͨͼ����������ͨ�Ĳ��֣��ٱ�������δ�������ĵ�
	    {
	    	if(!visited[i])
	    	{
	    		visited[i]=true;
	    		System.out.print("V" + i);
	    		ArrayList<Integer> judgment2 = new ArrayList<>();
	    		judgment2.add(i);                                             // ��v����ArrayList
				while (!judgment2.isEmpty())                                  // ArrayList�ǿ�
				{
					int u = judgment2.get(0);                                 // uΪ��ǰ�б�ͷԪ��
					judgment2.remove(0);                                      // ͷԪ��ɾ��
					int w = getFirstNeighbour(u);                            // w��Ϊ�¸���֮���ڵĽ��
					while (w != -1) {
						if (!visited[w]) {
							System.out.print("---->V" + w);
							visited[w] = true;
							judgment2.add(w);                                 // δ�����������ڵĽ����б�
						}
						w = getNextNeighbour(u, w);                          // ��u�����w��һ�����ڵ�
					}
					//System.out.println();
				}
	    	}
	    }
		System.out.println();
	}
	
	boolean[] visit=new boolean[10000];   //��־����
	//�ڽӾ���ʵ�ֵ�������ȱ���
	
	public void DFS_a(AMGGraph mygraph,int v)
	{
		int w;
		if(!visit[v])                         //�������ĳ�ʼֵ�Ƿ��ѱ����ʣ���û�����ʣ�
		{                                     //������������ƣ�Ϊ�˷�ֹ�Ѿ������ʵĽ����Ϊ�ݹ��ظ������
		    System.out.print("V"+v);	
		}
		    visit[v]=true;                    //��ʼ����ѱ�����
		    w=getFirstNeighbour(v);           //w��Ϊ�¸���֮���ڵĽ��
	        while(w!=-1)
		    {
			  if(!visit[w])                    //��û������
			  {
				visit[w]=true;                        //����ѱ�����
				System.out.print("---->V"+w);         //���
				DFS_a(mygraph,w);                     //�Ӹö��㿪ʼ������ȱ���
			  }
			  w=getNextNeighbour(v,w);          //��w��һ����֮���ڵĶ����ѱ����ʣ���u�����w��һ�����ڵ�
		    }
	        //System.out.println();
	        for(int i=1;i<=mygraph.verNum;i++)
	        {
	        	if(!visit[i])
	        	{
	        		if(getLastNeighbour(i)!=-1)
	        		{
	        			System.out.print("---->");
		        		DFS_a(mygraph,i);
	        		}
	        		System.out.println();
	        		if(getLastNeighbour(i)==-1)
	        			DFS_a(mygraph,i);
	        	}
	        }
   }
}

//�ڽӱ���
class Graph {
	Node[] GraphArray;
	// ͼ��ǰ�Ķ������ͱ���
	int vertexNum = 0;
	int edgeNum = 0;

	// ���캯��
	Graph() {

	}

	// ǰ�巨
	public void createGraph_a(int a, int[][] adj) {
		// �ڵ�����
		GraphArray = new Node[adj.length+1];
		vertexNum = a;
		edgeNum = a - 1;
		for (int i = 1; i <a+1; i++) {
			// ��ͷ�����в�����new&��ʼ����
			GraphArray[i] = new Node();
			GraphArray[i].CreateNode(i, null);

			for (int j = 1; j <=edgeNum+1; j++) {
				// ����Ϊǰ�巨
				if (adj[i][j] == 1 && GraphArray[i].next == null) {
					Node aaa = new Node();
					aaa.data = "V"+j;
					aaa.next = null;
					GraphArray[i].next = aaa;
				} else if (adj[i][j] == 1 && GraphArray[i].next != null) {
					Node aaa = new Node();
					aaa.data = 'V' + "" +j;
					aaa.next = GraphArray[i].next;
					GraphArray[i].next = aaa;
				}
			}
		}
	}

	// ��巨
	public void createGraph_b(int a, int[][] adj) {
		GraphArray = new Node[adj.length+1];
		vertexNum =a;
		edgeNum=a-1;
		// ��ͷ�����в�����new&��ʼ����
     for(int i = 1; i <a+1; i++) {
			GraphArray[i] = new Node();
			GraphArray[i].CreateNode(i, null);
			// ȷ��λ�õĽ��middle
			Node middle = GraphArray[i];
			for (int j = 1; j <=edgeNum+1; j++) {
				if (adj[i][j] == 1 && middle != null) {
					Node bbb = new Node();
					bbb.data = 'V' + "" + j;
					bbb.next =null;
					middle.next = bbb;
					middle = bbb;
				}
			}

		}

	}

	// չʾ����
	public void showGraph() 
	{
	   System.out.println("���ڽӱ�Ϊ��");
		for(int i=1; i<vertexNum+1;i++)
		{
			System.out.print(GraphArray[i].data);
			Node curNode = GraphArray[i];
			for (int j = 1; j <= edgeNum+1; j++) 
			{
				if (curNode != null) 
				{
					curNode = curNode.next;
					if (curNode != null) 
					{
						System.out.print(" ----> ");
						System.out.print(curNode.data);
					}
				}
			}
			System.out.println();
		}
	}
	
	//�ڽӱ��Ӧ�Ĺ�����ȱ���
	    boolean[] visited=new boolean[100000];   //��־����  
		public void BFS_b(Graph mygraph,int v)
		{
			
			visited[v]=true;                      //��ʼ����v�ѱ�����
			System.out.print("V"+v);
			ArrayList<Integer> judgment=new ArrayList<>();
			judgment.add(v);                         //v�����б�
			String na;
			Node w;
			int u;
			while(!judgment.isEmpty())              //�б�ǿ�
			{    
				u=judgment.get(0);            //uΪ��ǰ��ͷԪ��
				judgment.remove(0);                   //�б�ͷԪ�س���
				w=GraphArray[u];                  //�б�ͷԪ����Ϊw
				while(w.next!=null)                      //��w����֮�����Ķ���
				{
					w=w.next;                              //������w�����ĵ�һ������
					na=w.data.substring(1);                //naΪ������         String s.substring(int n):��String���͵ı���s�н�ȡ�Ӵ����ӵ�n���ַ���ȡ
					if(!visited[Integer.parseInt(na)])     //��naδ�����ʹ�
					{
					  judgment.add(Integer.parseInt(na)); //na�����б�  Integer.parseInt(String s):��String��ת��Ϊint��
					  System.out.print("---->"+w.data);    //���na
					  visited[Integer.parseInt(na)]=true;  //���na������
					}
					else continue;                         //�������ʹ���continue����ѭ��,������һ�������Ķ���
				}
			}
			System.out.println();
			for(int i=1;i<=mygraph.vertexNum;i++)             //��Ϊ����ͨͼ����������ͨ�Ĳ��֣��ٱ�������δ�������ĵ�
		    {
		    	while(!visited[i])
		    	{
		    		visited[i]=true;
		    		System.out.print("V"+i);
		    		judgment.add(i);                         //v�����б�
		    		while(!judgment.isEmpty())              //�б�ǿ�
					{    
						u=judgment.get(0);            //uΪ��ǰ��ͷԪ��
						judgment.remove(0);                   //�б�ͷԪ�س���
						w=GraphArray[u];                  //�б�ͷԪ����Ϊw
						while(w.next!=null)                      //��w����֮�����Ķ���
						{
							w=w.next;                              //������w�����ĵ�һ������
							na=w.data.substring(1);                //naΪ������         String s.substring(int n):��String���͵ı���s�н�ȡ�Ӵ����ӵ�n���ַ���ȡ
							if(!visited[Integer.parseInt(na)])     //��naδ�����ʹ�
							{
							  judgment.add(Integer.parseInt(na)); //na�����б�  Integer.parseInt(String s):��String��ת��Ϊint��
							  System.out.print("---->"+w.data);    //���na
							  visited[Integer.parseInt(na)]=true;  //���na������
							}
							else continue;                         //�������ʹ���continue����ѭ��,������һ�������Ķ���
						}
					}
		    		
		    	}
		    }
			System.out.println();
		}
		
		boolean[] visited1=new boolean[10000];   //��־����
	//�ڽӱ��Ӧ��������ȱ���
		public void DFS_b(Graph mygraph,int v)
		{
			if(!visited1[v])                         //�������ĳ�ʼֵ�Ƿ��ѱ����ʣ���û�����ʣ�
			{                                     //������������ƣ�Ϊ�˷�ֹ�Ѿ������ʵĽ����Ϊ�ݹ��ظ������
				System.out.print("V"+v);
			}
			visited1[v]=true;                      //��ʼ����v�ѱ�����
			String na,ch;
			Node p,q;
			int m=0;
			p=GraphArray[v];                       //����ʼ���ʶ�����Ϊp��pΪ�±�Ϊv��ͷ���
			while(p.next!=null)                    //������p�����Ľ��ʱ
			{
				p=p.next;                          
				na=p.data.substring(1);                              //��ȡ�Ӵ�,String s.substring(int n):��String���͵ı���s�н�ȡ�Ӵ����ӵ�n���ַ���ȡ
				if(!visited1[Integer.parseInt(na)])                  //��naδ�����ʹ�
				{
					visited1[Integer.parseInt(na)]=true;             //���na������
					System.out.print("---->V"+Integer.parseInt(na)); //���na
					DFS_b(mygraph,Integer.parseInt(na));             //������ȱ�����Ϊna�Ľ��
				}
				else continue;                     //�������ʹ���continue����ѭ��,������һ�������Ķ���
			}
			for(int i=1;i<=mygraph.vertexNum;i++)
		    {
				if(!visited1[i])
				{
					for(int j=1;j<i;j++)
					{
						q=GraphArray[j];
						while(q.next!=null)
						{
							q=q.next;
							ch=q.data.substring(1);
							if(Integer.parseInt(ch)==i)
								m++;
						}	
					}
					//System.out.print("---->");
		    		if(m!=0)
		    		{
		    			System.out.print("---->");
		    			DFS_b(mygraph,i);
		    		}
		    		System.out.println();
		    		if(m==0)
		    			DFS_b(mygraph,i);	
				}
		    }
		}
}
public class Breadth_First {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Scanner input=new Scanner(System.in);
		AMGGraph myGraph=new AMGGraph();
        myGraph.CreateAMGGraph();
        System.out.println("���ڽӾ���Ϊ��");
        myGraph.disPlayAMGGraph();
        Graph adjlist=new Graph();
        int j=1;
        while(j!=0)
        {
        System.out.println("��ѡ����Ҫ�õ����ڽӱ���������A:ǰ�巨 B:��巨");
        String choice=input.nextLine();
        char c = choice.charAt(0);
        if (c=='A')
        	{
			System.out.println("ǰ�巨��");
			adjlist.createGraph_a(myGraph.edge.length-2, myGraph.edge);
			adjlist.showGraph();break;
			} 
	    else if (c=='B')
	       {
			System.out.println("��巨��");
			adjlist.createGraph_b(myGraph.edge.length-2, myGraph.edge);
			adjlist.showGraph();break;
	       }
	    else
	    	continue;
         }
	    System.out.println("�ڽӾ���ʵ�ֵĹ�����ȱ�����");
	    while(j!=0)
	    {
	      System.out.println("�����뿪ʼ�����Ķ��㣺");
	      int v=input.nextInt();
	      if(v<=0||v>myGraph.verNum)
	      {
	    	  System.out.println("����������������룡");
	    	  continue;
	      }
	      else
	      {
	          myGraph.BFS_a(myGraph,v);
	          break;
	      }
	     }
	    System.out.println("�ڽӱ�ʵ�ֵĹ�����ȱ�����");
	    while(j!=0)
	    {
	        System.out.println("�����뿪ʼ�����Ķ��㣺");
	        int start=input.nextInt();
	        if(start<=0||start>adjlist.vertexNum)
	        {
	        	System.out.println("����������������룡");
		    	continue;
	        }
	        else
	        {
	        	adjlist.BFS_b(adjlist,start);
	        	break;
	        }
	    }
	    System.out.println("�ڽӾ���ʵ�ֵ�������ȱ�����");
	    while(j!=0)
	    {
	      System.out.println("�����뿪ʼ�����Ķ��㣺");
	      int v=input.nextInt();
	      if(v<=0||v>myGraph.verNum)
	      {
	    	  System.out.println("����������������룡");
	    	  continue;
	      }
	      else
	      {
	          myGraph.DFS_a(myGraph,v);
	          break;
	      }
	     }
	    System.out.println();
	    System.out.println("�ڽӱ�ʵ�ֵ�������ȱ�����");
	    while(j!=0)
	    {
	        System.out.println("�����뿪ʼ�����Ķ��㣺");
	        int start=input.nextInt();
	        if(start<=0||start>adjlist.vertexNum)
	        {
	        	System.out.println("����������������룡");
		    	continue;
	        }
	        else
	        {
	        	adjlist.DFS_b(adjlist,start);
	        	break;
	        }
	    }
		input.close();	
	}	
}
