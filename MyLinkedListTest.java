package hw3_1;

class MyLinkedList {
	private Node head; // 리스트의 첫번째 노드를 가리키는 변수
	private int numItems; // 리스트 길이(원소 수)
// 연결 리스트 노드 구조

	private class Node {
		int data;
		Node link;
	}

// 공백 리스트를 생성
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
			while (temp.link != null) { // temp가 마지막 노드를 가리킬 때까지
				temp = temp.link;
			}
			temp.link = newNode;
		}
		numItems++;
	}
	
	//리스트의 길이를 리턴
	public int size() {
		return numItems;
	}
	// 리스트가 data를 포함하는지 여부를 리턴
	// contains - 정수값을 매개변수로 받아 리스트에 존재하는지 여부 리턴 
	public boolean contains(int data) {
		if (head == null) { // 공백 리스트인 경우 삭제 실패
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
	// 리스트의 첫번째 원소를 삭제하여 리턴
	public int removeFirst() {
		if (head == null) { // 공백 리스트인 경우 삭제 실패
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

	// 리스트의 마지막 원소를 삭제하여 리턴
	public int removeLast() {
	if(head == null) { // 공백 리스트인 경우 삭제 실패
	throw new java.util.NoSuchElementException();
	}
	else if(head.link == null) { // 리스트 원소가 하나인 경우
		int box1 = 0;
		box1 = head.data;
		head = null;
		numItems--;
		return box1;
	}
	else { // 리스트 원소가 둘 이상인 경우
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

	// 리스트 원소들을 하나의 문자열로 만들어 리턴
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
// MyLinkedList 객체 list 생성
		MyLinkedList list = new MyLinkedList();
		System.out.println("hw6_1 : 홍석현");
		
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
		
		System.out.println(list.size());
		
// list의 맨 앞 원소, 맨 뒤 원소를 삭제한 후, 두 원소의 합 출력, 리스트 출력
		System.out.println(list.removeFirst() + list.removeLast());
		System.out.println(list);
		
		System.out.println(list.removeFirst() + list.removeLast());
		System.out.println(list);
	}
}
