package hw3_1;

public class MaxHeapTest {
	public static void main(String[] args) {
		System.out.println("hw9_1 : 홍석현");

		// 입력할 원소들을 저장한 데이터 배열
		int[] dataArray = { 3, 2, 5, 7, 4, 8, -1, 0, 5, 9 };

		// 입력할 원소 수와 같은 용량의 공백 최대힙을 생성
		MyMaxHeapTest heap = new MyMaxHeapTest(dataArray.length);

		// 데이터 배열에 저장된 원소를 최대힙에 하나씩 삽입한 후, 힙 내용 출력
		for (int item : dataArray) {
			heap.add(item);
			heap.print();
		}

		for (int i = 0; i < dataArray.length; i++) {
			heap.remove();

		}
		heap.isEmpty();
	}
}

//정수 배열로 구현한 최대힙 클래스
class MyMaxHeapTest {
	private int[] array; // 최대힙 원소를 저장할 배열
	private int n; // 최대힙에 저장된 원소 수

	// 반복문은 print에만
	public MyMaxHeapTest(int capacity) {
		n = 0;
		array = new int[capacity];
	}

	public void add(int item) {
		array[n] = item;

		int p = n;

		while (p > 0 && array[(p - 1) / 2] < array[p]) {
			int tmp = array[(p - 1) / 2];
			array[(p - 1) / 2] = array[p];
			array[p] = tmp;
			p = (p - 1) / 2;
		}
		n++;

	}

	public void print() {
		for (int i = 0; i < n; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	public boolean isEmpty() {
		if (n == 0){
			return true;
		} else
			return false;
	}

	public int remove() {
		int max = array[0];
		array[0] = array[n - 1];
		n--;
		
		int pp = 0;
		while ((pp * 2) + 2 <= n && (array[(pp * 2) + 1] > array[pp] || array[(pp * 2) + 2] > array[pp])) {
			if (array[(pp * 2 + 1)] > array[(pp * 2) + 2]) {
				int box = array[(pp * 2) + 1];
				array[(pp * 2) + 1] = array[pp];
				array[pp] = box;
				pp = (pp * 2) + 1;
			} else {
				int box = array[(pp * 2) + 2];
				array[(pp * 2) + 2] = array[pp];
				array[pp] = box;
				pp = (pp * 2) + 2;
			}

		}
		System.out.println(max);
		return max;
	}

}