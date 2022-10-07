package hw3_1;
import java.util.Scanner;
import java.util.Stack;

public class StackTest {
	public static void main(String[] args) {
		System.out.println("lab7_1 : 홍석현");
		
		//문자 스택 객체 생성
		Stack<Character> s = new Stack<Character>(); // Integer 스택 생성
		
		// 사용자로부터 한 줄의 문자열을 입력받음
		Scanner input = new Scanner(System.in);
		String line = input.nextLine();
		
		//문자열의 문자를 하나씩 스택에 삽입
		for(int i=0;i<line.length();i++) {
			char ch = line.charAt(i);
			s.push(ch);
		}
		
		//스택의 용량을 알아내어 출력
		System.out.println(s.capacity());
		
		//스택에 텅 빌때까지 문자를 하나씩 삭제하여 순서대로 출력
		while(! s.isEmpty()) {
			System.out.print(s.pop());
		}
		
	}
}
