package hw3_1;
import java.util.Scanner;

public class MyInsertionSort {
	public static void main(String[] args) {
		System.out.println("hw11_1 : 홍석현");
		
		 //(1) 단어 개수(n)와 n개의 단어를 입력받아 String 배열에 저장한다.
		 Scanner scanner = new Scanner(System.in);
		 int n = scanner.nextInt();
		 String[] array = new String[n];
		 
		 for(int i=0;i<n;i++) {
			 array[i] = scanner.next();
		 }
		
		 //(2) n개의 단어를 사전순으로 오름차순 정렬한다.
		 insertionSort(array);
		
		 //(3) 정렬된 순서대로 n개의 단어를 출력한다.
		 for(int i=0; i<n; i++) {
			 System.out.print(array[i] + " ");
		 }
		
	}
	
	public static void insertionSort(String[] array) {
		int i, j;
		String item;
		for (i = 1; i < array.length; i++) {
			item = array[i];
			
			// item이 삽입될 위치 j를 찾음
			for (j = i; (j>0) && ( ( array[j-1].compareTo(item) ) >= 0 ) ; j--) {
				array[j] = array[j - 1];
			}
			array[j] = item;
		}
	}
	

}
