package hw3_1;

class MatrixGraph {
	private int[][] matrix; // �������
	private int n; // vertex ����

	public MatrixGraph(int n) { // ������ n���̰�, ������ ���� �׷��� ����
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


class ListGraph {
	private class Node { // �ܼ� ���� ����Ʈ ��� ����
		int vertex;
		Node link;
	}

	private Node[] list; // ��������Ʈ
	private int n; // vertex ����

	public ListGraph(int n) { // ������ n���̰�, ������ ���� �׷��� ����
		list = new Node[n];
		this.n = n;
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

public class MyGraph {
	public static void main(String[] args) {
		System.out.println("lab10_1 : ȫ����");

		// (1) ������ 5�� ���� �׷��� MatrixGraph g1�� �����ϰ� ���� ���� ��, ���� ��� ���� ���
		MatrixGraph g1 = new MatrixGraph(5);
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
		ListGraph g2 = new ListGraph(5);
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
	}
}
