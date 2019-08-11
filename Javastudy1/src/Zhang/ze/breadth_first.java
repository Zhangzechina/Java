package Zhang.ze;

import java.util.*;

//边类（供邻接矩阵）
class EdgeElement
{
	int fromvex;
	int endvex;
	int weight;
	
	//默认构造函数
	EdgeElement()
	{
		
	}
	
	//构建函数
	public void createEdgeElement(int v1,int v2)
	{
		fromvex=v1;
		endvex=v2;
		weight=1;
	}
	
}

//节点类
class Node {
	String data; // 节点信息（名字）
	Node next; // 下一节点的引用
  
	Node() // 构造函数
	{

	}

	public void CreateNode(int dt, Node nt) // 初始化节点函数
	{
		this.data = "V" + dt;
		this.next = nt;
	}
}

//辅助队列类
class QueueForHelp
{
	private int[] elements;
	public static final int DEFAULT_CAPACITY=160;
	private int base=1;
	private int top=1;
	
	  
	//构造一个有默认大小队列
	public QueueForHelp()
	{
		elements=new int[DEFAULT_CAPACITY];
		top=1;
	}
	
	//构造一个有确定值的队列
	public QueueForHelp(int number)
	{
		elements=new int[number+1];
		top=1;
	}
	
	//将一个整数存到队列，入队
	public void push(int value)
	{
		if(this.getSize()>=elements.length)               //队列中整数个数超过数组内存储，申请新空间
		{
			int temp[]=new int[elements.length*2];
			System.arraycopy(elements, 0, temp,0, elements.length);
			elements=temp;
		}
		elements[top]=value;
		top++;
	}
	
	//判断队列是否为空
	public boolean empty()                   
	{
		if(top==1)
			return true;
		else 
		    return false;
	}
	
	//返回队列头元素
	public int peek()
	{
		return elements[base];
	}
	
	//删除队列头并返回，出队
	public int pop()
	{
		int temp = elements[base];  
	    for(int j=1;j<top;j++)
	    {  
	    	elements[j] =elements[j+1];
	    }
	    elements[top]=0;
	    top=top-1;
	    return temp;
	}
	
	//返回队列中中整数个数
	public int getSize()
	{
		return top-base;
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

//邻接矩阵表示的图类
class AMGGraph
{
	EdgeElement[] vertex;     //边矩阵
	int[][] edge;          //邻接矩阵
	int verNum=0;            //顶点数
	int edgeNum=0;           //边数
	
	//构造函数
	AMGGraph()
	{
	
	}
	
	Scanner input=new Scanner(System.in);	
	//初始化邻接矩阵
	public void CreateAMGGraph()
	{
		System.out.println("请输入顶点数a和边个数b：");
		int a=input.nextInt();
		int b=input.nextInt();
		edge=new int[a+2][b+2];              //为将下标统一，数组中的元素应比顶点数、边数至少大2
		for(int i=0;i<b;i++)
		{
			verNum=a;            //顶点数
			edgeNum=b;           //边数
		}
		
		vertex=new EdgeElement[b+1];         //边矩阵申请的比边数大一
		for(int i=1;i<=edgeNum;i++)
		{
			System.out.println("请输入边的两顶点v1、v2：");
			int v1=input.nextInt();
			int v2=input.nextInt();
			vertex[i]=new EdgeElement();            //应用构造函数对边矩阵的每一个元素进行初始化
			vertex[i].createEdgeElement(v1, v2);    //构建起每一个相连的边
		}
		for(int i=1;i<=edgeNum;i++)
		{
			int p=vertex[i].fromvex;                //找到边的前一个顶点
			int q=vertex[i].endvex;                 //找到边的后一个顶点
			edge[p][q]=edge[q][p]=1;                //矩阵数组的初始化
		}
	}

	//显示邻接矩阵
	public void disPlayAMGGraph()
	{
		System.out.print("   ");
		for(int i=1;i<=verNum;i++)                 //从1开始，为将下标与输入统一
		{
			System.out.print("V"+i+" ");           //该行主要是为了显示横向顶点名
		}
		System.out.println();
		for(int i=1;i<=verNum;i++)                 //从1开始，为将下标与输入统一
		{
			System.out.print("V"+i+" ");           //该行主要是为了显示纵向顶点名
			for(int j=1;j<=verNum;j++)             //从1开始，为将下标与输入统一
			{
				System.out.print(edge[i][j]+"  ");
			}
			System.out.println();
		}
	}
	
	//得到下一邻接节点的坐标
	public int getFirstNeighbour(int index)
	{
		for(int j=1;j<=verNum;j++)
		{
			if(edge[index][j]==1)                 //从输入行的第一个元素开始检查是否有与之相连的顶点
			{
				return j;
			}
		}
		return -1;
	}
	
	//根据前一邻接结点坐标获得下一个邻接节点的的坐标
		public int getNextNeighbour(int v1,int v2)
		{
			for(int j=v2+1;j<=verNum;j++)
			{
				if(edge[v1][j]==1)                //从输入行的第v2个元素之后开始检查是否有与之相连的顶点
				{
					return j;
				}
			}
			return -1;
		}
	
	//邻接矩阵对应的广度优先遍历
	public void BFS_a(AMGGraph mygraph,int v)
	{
		int len=mygraph.edge.length;
		int w;  
		boolean[] visited=new boolean[len+1];   //标志数组
		visited[v]=true;                      //初始顶点v已被访问
		System.out.print("V"+v);
		QueueForHelp judgment=new QueueForHelp(); // 初始化队列
		judgment.push(v);                         //v入队
		while(!judgment.empty())              //队列非空
		{    
			int u=judgment.peek();            //u为当前队头元素
			judgment.pop();                   //队头元素出队
			w=getFirstNeighbour(u);           //w置为下个与之相邻的结点
		    while(w!=-1)
			{
				if(!visited[w])
				{
					System.out.print("---->V"+w);    
					visited[w]=true;
					judgment.push(w);             //未被访问且相邻的进队
				}
				w=getNextNeighbour(u,w);          //找u相对于w下一个相邻的
			}
		}
		System.out.println();
	}
	
	boolean[] visit=new boolean[10000];   //标志数组
	//邻接矩阵实现的深度优先遍历
	public void DFS_a(AMGGraph mygraph,int v)
	{
		int w; 
		if(!visit[v])                         //检查输入的初始值是否已被访问，若没被访问，
		{                                     //则输出顶点名称（为了防止已经被访问的结点因为递归重复输出）
		    System.out.print("V"+v);	
		}
		visit[v]=true;                    //初始结点已被访问
		w=getFirstNeighbour(v);           //w置为下个与之相邻的结点
	    while(w!=-1)
		{
			if(!visit[w])                    //若没被访问
			{
				visit[w]=true;                        //标记已被访问
				System.out.print("---->V"+w);         //输出
				DFS_a(mygraph,w);                     //从该顶点开始继续深度遍历
			}
			w=getNextNeighbour(v,w);          //若w下一个与之相邻的顶点已被访问，找u相对于w下一个相邻的
		}
	}
}

//邻接表类
class Graph {
	Node[] GraphArray;
	// 图当前的顶点数和边数
	int vertexNum = 0;
	int edgeNum = 0;

	// 构造函数
	Graph() {

	}

	// 前插法
	public void createGraph_a(int a, int[][] adj) {
		// 节点数组
		GraphArray = new Node[adj.length+1];
		vertexNum = a;
		edgeNum = a - 1;
		for (int i = 1; i <a+1; i++) {
			// 对头结点进行操作（new&初始化）
			GraphArray[i] = new Node();
			GraphArray[i].CreateNode(i, null);

			for (int j = 1; j <=edgeNum+1; j++) {
				// 以下为前插法
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

	// 后插法
	public void createGraph_b(int a, int[][] adj) {
		GraphArray = new Node[adj.length+1];
		vertexNum =a;
		edgeNum=a-1;
		// 对头结点进行操作（new&初始化）
     for(int i = 1; i <a+1; i++) {
			GraphArray[i] = new Node();
			GraphArray[i].CreateNode(i, null);
			// 确定位置的结点middle
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

	// 展示函数
	public void showGraph() 
	{
	   System.out.println("该邻接表为：");
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
	
	//邻接表对应的广度优先遍历
		public void BFS_b(Graph mygraph,int v)
		{
			boolean[] visited=new boolean[vertexNum+1];   //标志数组
			visited[v]=true;                      //初始顶点v已被访问
			System.out.print("V"+v);
			QueueForHelp judgment=new QueueForHelp(); // 初始化队列
			judgment.push(v);                         //v入队
			String na;
			Node w;
			while(!judgment.empty())              //队列非空
			{    
				int u=judgment.peek();            //u为当前队头元素
				judgment.pop();                   //队头元素出队
				w=GraphArray[u];                  //队头元素置为w
				while(w.next!=null)                      //若w有与之相连的顶点
				{
					w=w.next;                              //访问与w相连的第一个顶点
					na=w.data.substring(1);                //na为顶点名         String s.substring(int n):从String类型的变量s中截取子串，从第n个字符截取
					if(!visited[Integer.parseInt(na)])     //若na未被访问过
					{
					  judgment.push(Integer.parseInt(na)); //na入队  Integer.parseInt(String s):将String型转化为int型
					  System.out.print("---->"+w.data);    //输出na
					  visited[Integer.parseInt(na)]=true;  //标记na被访问
					}
					else continue;                         //若被访问过，continue持续循环,访问下一个相连的顶点
				}
			}
			System.out.println();
		}
		
		boolean[] visited1=new boolean[10000];   //标志数组
	//邻接表对应的深度优先遍历
		public void DFS_b(Graph mygraph,int v)
		{
			if(!visited1[v])                         //检查输入的初始值是否已被访问，若没被访问，
			{                                     //则输出顶点名称（为了防止已经被访问的结点因为递归重复输出）
				System.out.print("V"+v);
			}
			visited1[v]=true;                      //初始顶点v已被访问
			String na;
			Node p;
			p=GraphArray[v];                       //将初始访问顶点置为p，p为下标为v的头结点
			while(p.next!=null)                    //当有与p相连的结点时
			{
				p=p.next;                          
				na=p.data.substring(1);                              //截取子串,String s.substring(int n):从String类型的变量s中截取子串，从第n个字符截取
				if(!visited1[Integer.parseInt(na)])                  //若na未被访问过
				{
					visited1[Integer.parseInt(na)]=true;             //标记na被访问
					System.out.print("---->V"+Integer.parseInt(na)); //输出na
					DFS_b(mygraph,Integer.parseInt(na));             //持续深度遍历名为na的结点
				}
				else continue;                     //若被访问过，continue持续循环,访问下一个相连的顶点
			}
		}
}
public class breadth_first {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner input=new Scanner(System.in);
		AMGGraph myGraph=new AMGGraph();
        myGraph.CreateAMGGraph();
        System.out.println("该邻接矩阵为：");
        myGraph.disPlayAMGGraph();
        Graph adjlist=new Graph();
        int j=1;
        while(j!=0)
        {
        System.out.println("请选择所要用到的邻接表构建方法：A:前插法 B:后插法");
        String choice=input.nextLine();
        char c = choice.charAt(0);
        if (c=='A')
        	{
			System.out.println("前插法：");
			adjlist.createGraph_a(myGraph.edge.length-2, myGraph.edge);
			adjlist.showGraph();break;
			} 
	    else if (c=='B')
	       {
			System.out.println("后插法：");
			adjlist.createGraph_b(myGraph.edge.length-2, myGraph.edge);
			adjlist.showGraph();break;
	       }
	    else
	    	continue;
         }
	    System.out.println("邻接矩阵实现的广度优先遍历：");
	    while(j!=0)
	    {
	      System.out.println("请输入开始遍历的顶点：");
	      int v=input.nextInt();
	      if(v<=0||v>myGraph.verNum)
	      {
	    	  System.out.println("输入错误，请重新输入！");
	    	  continue;
	      }
	      else
	      {
	          myGraph.BFS_a(myGraph,v);
	          break;
	      }
	     }
	    System.out.println("邻接表实现的广度优先遍历：");
	    while(j!=0)
	    {
	        System.out.println("请输入开始遍历的顶点：");
	        int start=input.nextInt();
	        if(start<=0||start>adjlist.vertexNum)
	        {
	        	System.out.println("输入错误，请重新输入！");
		    	continue;
	        }
	        else
	        {
	        	adjlist.BFS_b(adjlist,start);
	        	break;
	        }
	    }
	    System.out.println("邻接矩阵实现的深度优先遍历：");
	    while(j!=0)
	    {
	      System.out.println("请输入开始遍历的顶点：");
	      int v=input.nextInt();
	      if(v<=0||v>myGraph.verNum)
	      {
	    	  System.out.println("输入错误，请重新输入！");
	    	  continue;
	      }
	      else
	      {
	          myGraph.DFS_a(myGraph,v);
	          break;
	      }
	     }
	    System.out.println();
	    System.out.println("邻接表实现的深度优先遍历：");
	    while(j!=0)
	    {
	        System.out.println("请输入开始遍历的顶点：");
	        int start=input.nextInt();
	        if(start<=0||start>adjlist.vertexNum)
	        {
	        	System.out.println("输入错误，请重新输入！");
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