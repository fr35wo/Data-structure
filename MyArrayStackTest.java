package hw3_1;

import java.util.EmptyStackException;
import java.util.Scanner;

interface CharStack {
	boolean isEmpty();

	void push(char item);

	char pop();

	char peek();
}

class MyArrayStack implements CharStack {
	private int top;
	private int stackSize;
	private char[] array;

	public MyArrayStack() { // ũ�Ⱑ 10�� ���� ���� ����
		top = -1;
		stackSize = 10;
		array = new char[10];
	}

	public boolean isEmpty() { // ������ ��������� �˻�
		return (top == -1);
	}

	public boolean isFull() { // ������ ����á������ �˻�
		return (top == stackSize - 1);
	}

	public void push(char item) { // ���ÿ� item�� ����

		if (isFull()) {
			stackSize = stackSize * 2;

		}

		char[] tmp = new char[stackSize];
		for (int i = 0; i < array.length; i++)
			tmp[i] = array[i];

		array = tmp;// tmp�� ����
		array[++top] = item;

	}

	public char pop() { // ���� ������ ���Ҹ� �����Ͽ� ����
		if (isEmpty()) {
			throw new EmptyStackException(); // ���� �߻�
		} else {
			return array[top--];
		}
	}

	public char peek() { // ���� ������ ���Ҹ� ����
		if (isEmpty()) {
			throw new EmptyStackException(); // ���� �߻�
		} else {
			return array[top]; // ������ top ���Ҹ� ����(�������� ���� )
		}
	}

	int capacity() {

		return stackSize;
	}

}

public class MyArrayStackTest {
	public static void main(String[] args) {
		System.out.println("hw7_1 : ȫ����");
		MyArrayStack stack = new MyArrayStack();

		// ����ڷκ��� �� ���� ���ڿ��� �Է¹���
		Scanner input = new Scanner(System.in);
		String line = input.nextLine();

		// ���ڿ��� ���ڸ� �ϳ��� ���ÿ� ����
		for (int i = 0; i < line.length(); i++) {
			char ch = line.charAt(i);
			stack.push(ch);
		}

		// ������ �뷮�� �˾Ƴ��� ���
		System.out.println(stack.capacity());

		// ���ÿ� �� �������� ���ڸ� �ϳ��� �����Ͽ� ������� ���
		while (!stack.isEmpty()) {
			System.out.print(stack.pop());
		}

	}
}
