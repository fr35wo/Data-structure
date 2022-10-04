package hw3_1;
class MyArrayList {
	private int[] array; // ���Ҹ� ������ �迭
	private int numItems; // �迭�� ����� ���� ��(����Ʈ ����)
	private static final int DEFAULT_CAPACITY = 100; // �迭�� �⺻ �뷮
	public MyArrayList() { // ������ 1
		array = new int[DEFAULT_CAPACITY];
		numItems = 0;
	}
	
	public MyArrayList(int capacity) { // ������ 2
		array = new int[capacity];
		numItems = 0;
	}
	
	public void add(int item) { // ����Ʈ�� �� �ڿ� item ����
		if(numItems >= array.length) {
			System.out.println("�迭�� �������� ���� �����߽��ϴ�."); // ���� ó��
		}
		else {
			array[numItems++] = item;
		}
	}
	
	public void add(int index, int item) {
		int n = numItems; //numItem�� ũ�⸦ ������ ����
		numItems++;
		for(int i=n;i>=index;i--) {
			array[i+1] = array[i];
		}					
		array[index] = item;
	}
	
	public void get(int item) {
		System.out.println(item);
	}
	
	public void remove(int item) {
		int box = 0; // i�� ������ ����
		for(int i=0;i<=numItems;i++) {
			if(item == array[i]) {
				box = i;
				
			}
		}
		for(int i=box;i<=numItems;i++) {
			array[i] = array[i+1];
		}
		numItems--;
		
	}
	
	@Override
	public String toString() {
	String result = "";
	for(int i = 0; i < numItems; i++) {
	result += array[i] + " ";
	}
	return result;
	}
	
	
}


public class MyArray {
	public static void main(String[] args) {
		MyArrayList list = new MyArrayList();
		
		System.out.println("hw5_1 : ȫ����");
		
		for(int i=1;i<=10;i++) {
			list.add(i);
		}
		System.out.print(list);
		System.out.println();
		
		list.add(0,99);
		list.add(3,999);
		list.add(12,9999);
		System.out.print(list);
		System.out.println();
		
		list.get(9999);
		list.remove(9999);
		
		
		list.get(3);
		list.remove(3);
			
		list.get(99);
		list.remove(99);
		
		System.out.print(list);
		
	}
}
