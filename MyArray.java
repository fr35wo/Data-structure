package hw3_1;
class MyArrayList {
	private int[] array; // 원소를 저장할 배열
	private int numItems; // 배열에 저장된 원소 수(리스트 길이)
	private static final int DEFAULT_CAPACITY = 100; // 배열의 기본 용량
	public MyArrayList() { // 생성자 1
		array = new int[DEFAULT_CAPACITY];
		numItems = 0;
	}
	
	public MyArrayList(int capacity) { // 생성자 2
		array = new int[capacity];
		numItems = 0;
	}
	
	public void add(int item) { // 리스트의 맨 뒤에 item 삽입
		if(numItems >= array.length) {
			System.out.println("배열이 가득차서 삽입 실패했습니다."); // 에러 처리
		}
		else {
			array[numItems++] = item;
		}
	}
	
	public void add(int index, int item) {
		int n = numItems; //numItem의 크기를 저장할 변수
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
		int box = 0; // i를 저장할 변수
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
		
		System.out.println("hw5_1 : 홍석현");
		
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
