package hw3_1;

import java.util.LinkedList;

public class LinkedListTest {
	public static void main(String[] args) {
// ���� ���Ҹ� ������ LinkedList�� ����Ʈ ��ü list�� ����
		LinkedList<Integer> list = new LinkedList<Integer>();
		System.out.println("lab6_1 : ȫ����");
		System.out.println(list.contains(2));
// list�� �� �տ� 1, 2��, �� �ڿ� 3, 4�� ���ʴ�� ������ ��, ����Ʈ ���
		list.addFirst(1);
		list.addFirst(2);
		list.addLast(3);
		list.addLast(4);
		System.out.println(list);
// list�� 2, 4, 6�� �����ϴ��� ���� ���
		System.out.println(list.contains(2));
		System.out.println(list.contains(4));
		System.out.println(list.contains(6));
//list�� ���� ���
		System.out.println(list.size());
		
// list�� �� �� ����, �� �� ���Ҹ� ������ ��, �� ������ �� ���, ����Ʈ ���
		System.out.println(list.removeFirst() + list.removeLast());
		System.out.println(list);
		
// list�� �� �� ����, �� �� ���Ҹ� ������ ��, �� ������ �� ���, ����Ʈ ���
		System.out.println(list.removeFirst() + list.removeLast());
		System.out.println(list);
	}
}
