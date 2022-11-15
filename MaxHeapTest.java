package hw3_1;

public class MaxHeapTest {
	public static void main(String[] args) {
		System.out.println("hw9_1 : ȫ����");

		// �Է��� ���ҵ��� ������ ������ �迭
		int[] dataArray = { 3, 2, 5, 7, 4, 8, -1, 0, 5, 9 };

		// �Է��� ���� ���� ���� �뷮�� ���� �ִ����� ����
		MyMaxHeapTest heap = new MyMaxHeapTest(dataArray.length);

		// ������ �迭�� ����� ���Ҹ� �ִ����� �ϳ��� ������ ��, �� ���� ���
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

//���� �迭�� ������ �ִ��� Ŭ����
class MyMaxHeapTest {
	private int[] array; // �ִ��� ���Ҹ� ������ �迭
	private int n; // �ִ����� ����� ���� ��

	// �ݺ����� print����
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