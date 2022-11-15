package hw3_1;

public class MaxHeap{
	public static void main(String[] args) {
		System.out.println("lab9_1 : 홍석현");
			
		//입력할 원소들을 저장한 데이터 배열
		int[] dataArray = {3,2,5,7,4,8,-1,0,5,9};
		
		//입력할 원소 수와 같은 용량의 공백 최대힙을 생성
		MyMaxHeap heap = new MyMaxHeap(dataArray.length);
		
		//데이터 배열에 저장된 원소를 최대힙에 하나씩 삽입한 후, 힙 내용 출력
		for(int item : dataArray) {
			heap.add(item);
			heap.print();
		}
		
		
		}
}

//정수 배열로 구현한 최대힙 클래스
class MyMaxHeap {
	private int[] array;	//최대힙 원소를 저장할 배열
	private int n;			//최대힙에 저장된 원소 수
	
	//반복문은 print에만
	public MyMaxHeap(int capacity) {
		n=0;
		array = new int[capacity];
	}
	
	public void add(int item) {
		array[n++] = item;
	}
	
	public void print() {
		for(int i=0;i<n;i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
}
