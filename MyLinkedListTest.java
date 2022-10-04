package hw3_1;

class MyLinkedList {
	private Node head; // ����Ʈ�� ù��° ��带 ����Ű�� ����
	private int numItems; // ����Ʈ ����(���� ��)
// ���� ����Ʈ ��� ����

	private class Node {
		int data;
		Node link;
	}

// ���� ����Ʈ�� ����
	MyLinkedList() {
		head = null;
		numItems = 0;
	}
	public void addFirst(int data) {
		Node newNode = new Node();
		newNode.data = data;
		newNode.link = head;
		head = newNode;
		numItems++;
	}

	public void addLast(int data) {
		Node newNode = new Node();
		newNode.data = data;
		if (head == null) {
			head = newNode;
		} else {
			Node temp = head;
			while (temp.link != null) { // temp�� ������ ��带 ����ų ������
				temp = temp.link;
			}
			temp.link = newNode;
		}
		numItems++;
	}
	
	//����Ʈ�� ���̸� ����
	public int size() {
		return numItems;
	}
	// ����Ʈ�� data�� �����ϴ��� ���θ� ����
	// contains - �������� �Ű������� �޾� ����Ʈ�� �����ϴ��� ���� ���� 
	public boolean contains(int data) {
		if (head == null) { // ���� ����Ʈ�� ��� ���� ����
			return false;
		} else {
		
		Node temp1 = head;
		 
		while (temp1 != null) {
		
		if(temp1.data == data) {
			return true;				
		}
		else 
			temp1 = temp1.link;		
		}
		return false;
		
	}
	}
	// ����Ʈ�� ù��° ���Ҹ� �����Ͽ� ����
	public int removeFirst() {
		if (head == null) { // ���� ����Ʈ�� ��� ���� ����
			throw new java.util.NoSuchElementException();
		} else {
			Node temp4 = head;
			int box = 0 ;
			box = temp4.data;
			head = temp4.link;
			numItems--;
			return box;
			
		}
	}

	// ����Ʈ�� ������ ���Ҹ� �����Ͽ� ����
	public int removeLast() {
	if(head == null) { // ���� ����Ʈ�� ��� ���� ����
	throw new java.util.NoSuchElementException();
	}
	else if(head.link == null) { // ����Ʈ ���Ұ� �ϳ��� ���
		int box1 = 0;
		box1 = head.data;
		head = null;
		numItems--;
		return box1;
	}
	else { // ����Ʈ ���Ұ� �� �̻��� ���
		Node temp2 = head;
		Node temp3 = head.link;
		while(temp3.link != null) {
			temp2 = temp3;
			temp3 = temp3.link;
		}
		temp2.link = null;
		numItems--;
		return temp3.data;
	}
	
	
	}

	// ����Ʈ ���ҵ��� �ϳ��� ���ڿ��� ����� ����
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer("(");
		Node temp5 = head;
		if (numItems > 0) {
			for (int i = 0; i < numItems - 1; i++) {
				result.append(temp5.data + ", ");
				temp5 = temp5.link;
			}
			result.append(temp5.data);
		}
		result.append(")");
		return result.toString();
	}

}


public class MyLinkedListTest {
	public static void main(String[] args) {
// MyLinkedList ��ü list ����
		MyLinkedList list = new MyLinkedList();
		System.out.println("hw6_1 : ȫ����");
		
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
		
		System.out.println(list.size());
		
// list�� �� �� ����, �� �� ���Ҹ� ������ ��, �� ������ �� ���, ����Ʈ ���
		System.out.println(list.removeFirst() + list.removeLast());
		System.out.println(list);
		
		System.out.println(list.removeFirst() + list.removeLast());
		System.out.println(list);
	}
}
