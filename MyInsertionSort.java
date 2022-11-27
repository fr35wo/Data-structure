package hw3_1;
import java.util.Scanner;

public class MyInsertionSort {
	public static void main(String[] args) {
		System.out.println("hw11_1 : ȫ����");
		
		 //(1) �ܾ� ����(n)�� n���� �ܾ �Է¹޾� String �迭�� �����Ѵ�.
		 Scanner scanner = new Scanner(System.in);
		 int n = scanner.nextInt();
		 String[] array = new String[n];
		 
		 for(int i=0;i<n;i++) {
			 array[i] = scanner.next();
		 }
		
		 //(2) n���� �ܾ ���������� �������� �����Ѵ�.
		 insertionSort(array);
		
		 //(3) ���ĵ� ������� n���� �ܾ ����Ѵ�.
		 for(int i=0; i<n; i++) {
			 System.out.print(array[i] + " ");
		 }
		
	}
	
	public static void insertionSort(String[] array) {
		int i, j;
		String item;
		for (i = 1; i < array.length; i++) {
			item = array[i];
			
			// item�� ���Ե� ��ġ j�� ã��
			for (j = i; (j>0) && ( ( array[j-1].compareTo(item) ) >= 0 ) ; j--) {
				array[j] = array[j - 1];
			}
			array[j] = item;
		}
	}
	

}
