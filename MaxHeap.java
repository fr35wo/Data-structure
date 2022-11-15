package hw3_1;

public class MaxHeap{
	public static void main(String[] args) {
		System.out.println("lab9_1 : ȫ����");
			
		//�Է��� ���ҵ��� ������ ������ �迭
		int[] dataArray = {3,2,5,7,4,8,-1,0,5,9};
		
		//�Է��� ���� ���� ���� �뷮�� ���� �ִ����� ����
		MyMaxHeap heap = new MyMaxHeap(dataArray.length);
		
		//������ �迭�� ����� ���Ҹ� �ִ����� �ϳ��� ������ ��, �� ���� ���
		for(int item : dataArray) {
			heap.add(item);
			heap.print();
		}
		
		
		}
}

//���� �迭�� ������ �ִ��� Ŭ����
class MyMaxHeap {
	private int[] array;	//�ִ��� ���Ҹ� ������ �迭
	private int n;			//�ִ����� ����� ���� ��
	
	//�ݺ����� print����
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
