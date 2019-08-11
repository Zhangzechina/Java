package Adjacency_list;

import java.util.*;

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

// �ڽӱ���

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
		GraphArray = new Node[adj.length];
		vertexNum = a;
		edgeNum = a - 1;
		for (int i = 0; i < a; i++) {
			// ��ͷ�����в�����new&��ʼ����
			GraphArray[i] = new Node();
			GraphArray[i].CreateNode(i + 1, null);

			for (int j = 0; j < edgeNum; j++) {
				// ����Ϊǰ�巨
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

	// ��巨
	public void createGraph_b(int a, int[][] adj) {
		GraphArray = new Node[adj.length];
		vertexNum =a;
		edgeNum=a-1;
		// ��ͷ�����в�����new&��ʼ����
        for(int i = 0; i < a; i++) {
			GraphArray[i] = new Node();
			GraphArray[i].CreateNode(i + 1, null);
			// ȷ��λ�õĽ��middle
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

	// չʾ����
	public void showGraph() 
	{
	   System.out.println("���ڽӱ�Ϊ��");
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
		// ԭ�ڽӾ���
		int[][] adjMatrix = { { 0, 1, 0, 1, 0, 0, 0, 0 }, { 1, 0, 1, 0, 0, 0, 0, 0 }, { 0, 1, 0, 1, 1, 0, 0, 0 },
				{ 1, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0, 1, 1, 0 }, { 0, 0, 0, 0, 1, 0, 0, 1 },
				{ 0, 0, 0, 0, 1, 0, 0, 1 }, { 0, 0, 0, 0, 0, 1, 1, 0 } };
		// ԭ��������
		int verNum = adjMatrix.length;
		// ��ʼ���ڽӱ�
		Graph adjacencyList = new Graph();

		System.out.println("���������ѡ�ģ�A-ǰ�巨  B-��巨");
		Scanner input = new Scanner(System.in);
		String choice = input.nextLine();
		char c = choice.charAt(0);
		input.close();
		if (c == 'A') {
			System.out.println("ǰ�巨��");
			adjacencyList.createGraph_a(verNum, adjMatrix);
			adjacencyList.showGraph();
		} else if (c == 'B') {
			System.out.println("��巨��");
			adjacencyList.createGraph_b(verNum, adjMatrix);
			adjacencyList.showGraph();
		}

	}
}
