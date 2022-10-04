package hw3_1;

import java.util.LinkedList;

public class LinkedListTest {
	public static void main(String[] args) {
// 정수 원소를 저장할 LinkedList형 리스트 객체 list를 생성
		LinkedList<Integer> list = new LinkedList<Integer>();
		System.out.println("lab6_1 : 홍석현");
		System.out.println(list.contains(2));
// list의 맨 앞에 1, 2를, 맨 뒤에 3, 4를 차례대로 삽입한 후, 리스트 출력
		list.addFirst(1);
		list.addFirst(2);
		list.addLast(3);
		list.addLast(4);
		System.out.println(list);
// list에 2, 4, 6이 존재하는지 여부 출력
		System.out.println(list.contains(2));
		System.out.println(list.contains(4));
		System.out.println(list.contains(6));
//list의 길이 출력
		System.out.println(list.size());
		
// list의 맨 앞 원소, 맨 뒤 원소를 삭제한 후, 두 원소의 합 출력, 리스트 출력
		System.out.println(list.removeFirst() + list.removeLast());
		System.out.println(list);
		
// list의 맨 앞 원소, 맨 뒤 원소를 삭제한 후, 두 원소의 합 출력, 리스트 출력
		System.out.println(list.removeFirst() + list.removeLast());
		System.out.println(list);
	}
}
