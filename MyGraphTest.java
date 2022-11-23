package hw3_1;

class MatrixGraphTest {
	private int[][] matrix; // �������
	private int n; // vertex ����

	public MatrixGraphTest(int n) { // ������ n���̰�, ������ ���� �׷��� ����
		matrix = new int[n][n];
		this.n = n;
	}

	public void insertEdge(int v1, int v2) { // �׷����� ���� <v1, v2> ����
		if (v1 < 0 || v1 >= n || v2 < 0 || v2 >= n)
			System.out.println("�׷����� ���� �����Դϴ�!");
		else
			matrix[v1][v2] = 1;
	}

	public void printAdjMatrix() { // ���� ��� ���
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public boolean hasEdge(int v1, int v2) {
		if(matrix[v1][v2] == 1) {
			return true;
		}
		else return false;
	}
	
	public int outDegree(int v) {
		int cnt = 0;
		
		for(int i=0;i<n;i++) {
			cnt = matrix[v][i] + cnt;
		}
		return cnt;
		
	}
}


class ListGraphTest {
	private class Node { // �ܼ� ���� ����Ʈ ��� ����
		int vertex;
		Node link;

	}
	
	private Node[] list; // ��������Ʈ
	private int n; // vertex ����
	
	private boolean visited[]; //�湮 ����Ʈ ���� ����
	
	public ListGraphTest(int n) { // ������ n���̰�, ������ ���� �׷��� ����
		list = new Node[n];
		this.n = n;
		visited = new boolean[n]; //�湮 ����Ʈ ���� ����
	}

	public void insertEdge(int v1, int v2) { // �׷����� ���� <v1, v2> ����
		if (v1 < 0 || v1 >= n || v2 < 0 || v2 >= n) {
			System.out.println("�׷����� ���� �����Դϴ�!");
		} else {
			// v1�� ���Ḯ��Ʈ �� �տ� vertex �ʵ尡 v2�� ��� ����
			Node newNode = new Node();
			newNode.vertex = v2;
			newNode.link = list[v1];
			list[v1] = newNode;
		}
	}
	
	public boolean hasEdge(int v1, int v2) {
		if (v1 < 0 || v1 >= n || v2 < 0 || v2 >= n) {
			return false;
		} 
		
		//Node temp = list[v1] �ϰ� temp ������ ã��
		Node temp = list[v1];
		if(temp == null) {
			return false;
		}
		else {
		while (temp != null) { // temp�� ������ ��带 ����ų ������
			
			if (temp.vertex == v2) {
				return true;
			} else
				temp = temp.link;
		}
		return false;
		}
	}
	
	public int outDegree(int v) {
		int cnt = 0;

		Node temp = list[v];
		
		
		if (temp == null) {
			return cnt;
		} 
		else {
			while (temp != null) { // temp�� ������ ��带 ����ų ������
				cnt++;
				temp = temp.link;
			}
		return cnt;
		}
	}
	
	
	// �׷��� Ž�� (���ȣ��)
	public void dfs(int v) {
		
		visited[v] = true;
		System.out.print(v+" ");
		
		Node temp = list[v];
		while (temp != null) {
			if (visited[temp.vertex] == false) {
				dfs(temp.vertex);
			}
			temp = temp.link;
		}
		
		for (int i = 0; i < n; i++) {
			if (visited[i] == false) {
				dfs(i);
			}
		}
		
	}

	
	
	public void printAdjList() { // ���� ����Ʈ�� ��� ���
		for (int i = 0; i < n; i++) {
			System.out.print("���� " + i + "�� ��������Ʈ");
			for (Node temp = list[i]; temp != null; temp = temp.link) {
				System.out.print(" -> " + temp.vertex);
			}
			System.out.println();
		}
	}

}
public class MyGraphTest {
	public static void main(String[] args) {
		System.out.println("hw10_1 : ȫ����");

		// (1) ������ 5�� ���� �׷��� MatrixGraph g1�� �����ϰ� ���� ���� ��, ���� ��� ���� ���
		MatrixGraphTest g1 = new MatrixGraphTest(5);
		g1.insertEdge(0, 4);
		g1.insertEdge(0, 3);
		g1.insertEdge(3, 2);
		g1.insertEdge(2, 4);
		g1.insertEdge(2, 0);
		g1.insertEdge(4, 3);
		g1.insertEdge(4, 1);
		System.out.println("�׷��� g1�� ������� : ");
		g1.printAdjMatrix();
		System.out.println();

		// (2) ������ 5�� ���� �׷��� ListGraph g2�� �����ϰ� ���� ���� ��, ���� ����Ʈ ���� ���
		ListGraphTest g2 = new ListGraphTest(5);
		g2.insertEdge(0, 4);
		g2.insertEdge(0, 3);
		g2.insertEdge(3, 2);
		g2.insertEdge(2, 4);
		g2.insertEdge(2, 0);
		g2.insertEdge(4, 3);
		g2.insertEdge(4, 1);
		System.out.println("�׷��� g2�� ��������Ʈ : ");
		g2.printAdjList();
		System.out.println();

		// (3) g1�� ���� <0, 1>, <1, 2>, <4, 1>�� �����ϴ��� ���θ� ���
		System.out.println(g1.hasEdge(0, 1));
		System.out.println(g1.hasEdge(1, 2));
		System.out.println(g1.hasEdge(4, 1));

		// (4) g1�� ���� 0, ���� 3�� out-degree�� ���
		System.out.println(g1.outDegree(0));
		System.out.println(g1.outDegree(3));
		System.out.println();
	
		//(5) g2�� ���� <0, 3>, <1, 2>, <4, 3>, <4, 2>�� �����ϴ��� ���θ� ���
		System.out.println(g2.hasEdge(0, 3));
		System.out.println(g2.hasEdge(1, 2));
		System.out.println(g2.hasEdge(4, 3));
		System.out.println(g2.hasEdge(4, 2));
	
	
		//(6) g2�� ���� 1, ���� 4�� out-degree�� ���
		System.out.println(g2.outDegree(1));
		System.out.println(g2.outDegree(4));
		System.out.println();
		
		//(7) ���� 0�� ������������ g2�� depth first search �Ͽ� �湮 ������� ���� ��ȣ�� ���  ******** ���� ����
	    g2.dfs(0);
	       
	}
}
