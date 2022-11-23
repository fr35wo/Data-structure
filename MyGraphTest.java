package hw3_1;

class MatrixGraphTest {
	private int[][] matrix; // 인접행렬
	private int n; // vertex 개수

	public MatrixGraphTest(int n) { // 정점이 n개이고, 간선이 없는 그래프 생성
		matrix = new int[n][n];
		this.n = n;
	}

	public void insertEdge(int v1, int v2) { // 그래프에 간선 <v1, v2> 삽입
		if (v1 < 0 || v1 >= n || v2 < 0 || v2 >= n)
			System.out.println("그래프에 없는 정점입니다!");
		else
			matrix[v1][v2] = 1;
	}

	public void printAdjMatrix() { // 인접 행렬 출력
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
	private class Node { // 단순 연결 리스트 노드 구조
		int vertex;
		Node link;

	}
	
	private Node[] list; // 인접리스트
	private int n; // vertex 개수
	
	private boolean visited[]; //방문 리스트 선택 과제
	
	public ListGraphTest(int n) { // 정점이 n개이고, 간선이 없는 그래프 생성
		list = new Node[n];
		this.n = n;
		visited = new boolean[n]; //방문 리스트 선택 과제
	}

	public void insertEdge(int v1, int v2) { // 그래프에 간선 <v1, v2> 삽입
		if (v1 < 0 || v1 >= n || v2 < 0 || v2 >= n) {
			System.out.println("그래프에 없는 정점입니다!");
		} else {
			// v1의 연결리스트 맨 앞에 vertex 필드가 v2인 노드 삽입
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
		
		//Node temp = list[v1] 하고 temp 돌려서 찾기
		Node temp = list[v1];
		if(temp == null) {
			return false;
		}
		else {
		while (temp != null) { // temp가 마지막 노드를 가리킬 때까지
			
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
			while (temp != null) { // temp가 마지막 노드를 가리킬 때까지
				cnt++;
				temp = temp.link;
			}
		return cnt;
		}
	}
	
	
	// 그래프 탐색 (재귀호출)
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

	
	
	public void printAdjList() { // 인접 리스트를 모두 출력
		for (int i = 0; i < n; i++) {
			System.out.print("정점 " + i + "의 인접리스트");
			for (Node temp = list[i]; temp != null; temp = temp.link) {
				System.out.print(" -> " + temp.vertex);
			}
			System.out.println();
		}
	}

}
public class MyGraphTest {
	public static void main(String[] args) {
		System.out.println("hw10_1 : 홍석현");

		// (1) 정점수 5인 방향 그래프 MatrixGraph g1을 생성하고 간선 삽입 후, 인접 행렬 내용 출력
		MatrixGraphTest g1 = new MatrixGraphTest(5);
		g1.insertEdge(0, 4);
		g1.insertEdge(0, 3);
		g1.insertEdge(3, 2);
		g1.insertEdge(2, 4);
		g1.insertEdge(2, 0);
		g1.insertEdge(4, 3);
		g1.insertEdge(4, 1);
		System.out.println("그래프 g1의 인접행렬 : ");
		g1.printAdjMatrix();
		System.out.println();

		// (2) 정점수 5인 방향 그래프 ListGraph g2를 생성하고 간선 삽입 후, 인접 리스트 내용 출력
		ListGraphTest g2 = new ListGraphTest(5);
		g2.insertEdge(0, 4);
		g2.insertEdge(0, 3);
		g2.insertEdge(3, 2);
		g2.insertEdge(2, 4);
		g2.insertEdge(2, 0);
		g2.insertEdge(4, 3);
		g2.insertEdge(4, 1);
		System.out.println("그래프 g2의 인접리스트 : ");
		g2.printAdjList();
		System.out.println();

		// (3) g1에 간선 <0, 1>, <1, 2>, <4, 1>가 존재하는지 여부를 출력
		System.out.println(g1.hasEdge(0, 1));
		System.out.println(g1.hasEdge(1, 2));
		System.out.println(g1.hasEdge(4, 1));

		// (4) g1의 정점 0, 정점 3의 out-degree를 출력
		System.out.println(g1.outDegree(0));
		System.out.println(g1.outDegree(3));
		System.out.println();
	
		//(5) g2에 간선 <0, 3>, <1, 2>, <4, 3>, <4, 2>가 존재하는지 여부를 출력
		System.out.println(g2.hasEdge(0, 3));
		System.out.println(g2.hasEdge(1, 2));
		System.out.println(g2.hasEdge(4, 3));
		System.out.println(g2.hasEdge(4, 2));
	
	
		//(6) g2의 정점 1, 정점 4의 out-degree를 출력
		System.out.println(g2.outDegree(1));
		System.out.println(g2.outDegree(4));
		System.out.println();
		
		//(7) 정점 0을 시작정점으로 g2를 depth first search 하여 방문 순서대로 정점 번호를 출력  ******** 선택 과제
	    g2.dfs(0);
	       
	}
}
