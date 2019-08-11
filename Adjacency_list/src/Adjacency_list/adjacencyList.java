package Adjacency_list;

import java.util.*;

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

// 邻接表类

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
		GraphArray = new Node[adj.length];
		vertexNum = a;
		edgeNum = a - 1;
		for (int i = 0; i < a; i++) {
			// 对头结点进行操作（new&初始化）
			GraphArray[i] = new Node();
			GraphArray[i].CreateNode(i + 1, null);

			for (int j = 0; j < edgeNum; j++) {
				// 以下为前插法
				if (adj[i][j] == 1 && GraphArray[i].next == null) {
					Node aaa = new Node();
					aaa.data = 'V'+""+ (j + 1);
					aaa.next = null;
					GraphArray[i].next = aaa;
				} else if (adj[i][j] == 1 && GraphArray[i].next != null) {
					Node aaa = new Node();
					aaa.data = 'V' + "" + (j + 1);
					aaa.next = GraphArray[i].next;
					GraphArray[i].next = aaa;
				}
			}
		}
	}

	// 后插法
	public void createGraph_b(int a, int[][] adj) {
		GraphArray = new Node[adj.length];
		vertexNum =a;
		edgeNum=a-1;
		// 对头结点进行操作（new&初始化）
        for(int i = 0; i < a; i++) {
			GraphArray[i] = new Node();
			GraphArray[i].CreateNode(i + 1, null);
			// 确定位置的结点middle
			Node middle = GraphArray[i];
			for (int j = 0; j <=edgeNum; j++) {
				if (adj[i][j] == 1 && middle != null) {
					Node bbb = new Node();
					bbb.data = 'V' + "" + (j + 1);
					bbb.next = null;
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
		for(int i=0; i<vertexNum;i++)
		{
			System.out.print(GraphArray[i].data);
			Node curNode = GraphArray[i];
			for (int j = 0; j <= edgeNum; j++) 
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
}

public class adjacencyList {

	public static void main(String[] args) {
		// 原邻接矩阵
		int[][] adjMatrix = { { 0, 1, 0, 1, 0, 0, 0, 0 }, { 1, 0, 1, 0, 0, 0, 0, 0 }, { 0, 1, 0, 1, 1, 0, 0, 0 },
				{ 1, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0, 1, 1, 0 }, { 0, 0, 0, 0, 1, 0, 0, 1 },
				{ 0, 0, 0, 0, 1, 0, 0, 1 }, { 0, 0, 0, 0, 0, 1, 1, 0 } };
		// 原来顶点数
		int verNum = adjMatrix.length;
		// 初始化邻接表
		Graph adjacencyList = new Graph();

		System.out.println("请输入你的选的：A-前插法  B-后插法");
		Scanner input = new Scanner(System.in);
		String choice = input.nextLine();
		char c = choice.charAt(0);
		input.close();
		if (c == 'A') {
			System.out.println("前插法：");
			adjacencyList.createGraph_a(verNum, adjMatrix);
			adjacencyList.showGraph();
		} else if (c == 'B') {
			System.out.println("后插法：");
			adjacencyList.createGraph_b(verNum, adjMatrix);
			adjacencyList.showGraph();
		}

	}
}
