package hw3_1;
import java.util.Scanner;
import java.util.Stack;

public class StackTest {
	public static void main(String[] args) {
		System.out.println("lab7_1 : ȫ����");
		
		//���� ���� ��ü ����
		Stack<Character> s = new Stack<Character>(); // Integer ���� ����
		
		// ����ڷκ��� �� ���� ���ڿ��� �Է¹���
		Scanner input = new Scanner(System.in);
		String line = input.nextLine();
		
		//���ڿ��� ���ڸ� �ϳ��� ���ÿ� ����
		for(int i=0;i<line.length();i++) {
			char ch = line.charAt(i);
			s.push(ch);
		}
		
		//������ �뷮�� �˾Ƴ��� ���
		System.out.println(s.capacity());
		
		//���ÿ� �� �������� ���ڸ� �ϳ��� �����Ͽ� ������� ���
		while(! s.isEmpty()) {
			System.out.print(s.pop());
		}
		
	}
}
