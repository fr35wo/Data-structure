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

	public MyArrayStack() { // 크기가 10인 공백 스택 생성
		top = -1;
		stackSize = 10;
		array = new char[10];
	}

	public boolean isEmpty() { // 스택이 비었는지를 검사
		return (top == -1);
	}

	public boolean isFull() { // 스택이 가득찼는지를 검사
		return (top == stackSize - 1);
	}

	public void push(char item) { // 스택에 item을 삽입

		if (isFull()) {
			stackSize = stackSize * 2;

		}

		char[] tmp = new char[stackSize];
		for (int i = 0; i < array.length; i++)
			tmp[i] = array[i];

		array = tmp;// tmp에 저장
		array[++top] = item;

	}

	public char pop() { // 스택 꼭데기 원소를 삭제하여 리턴
		if (isEmpty()) {
			throw new EmptyStackException(); // 예외 발생
		} else {
			return array[top--];
		}
	}

	public char peek() { // 스택 꼭데기 원소를 리턴
		if (isEmpty()) {
			throw new EmptyStackException(); // 예외 발생
		} else {
			return array[top]; // 스택의 top 원소를 리턴(삭제하지 않음 )
		}
	}

	int capacity() {

		return stackSize;
	}

}

public class MyArrayStackTest {
	public static void main(String[] args) {
		System.out.println("hw7_1 : 홍석현");
		MyArrayStack stack = new MyArrayStack();

		// 사용자로부터 한 줄의 문자열을 입력받음
		Scanner input = new Scanner(System.in);
		String line = input.nextLine();

		// 문자열의 문자를 하나씩 스택에 삽입
		for (int i = 0; i < line.length(); i++) {
			char ch = line.charAt(i);
			stack.push(ch);
		}

		// 스택의 용량을 알아내어 출력
		System.out.println(stack.capacity());

		// 스택에 텅 빌때까지 문자를 하나씩 삭제하여 순서대로 출력
		while (!stack.isEmpty()) {
			System.out.print(stack.pop());
		}

	}
}
