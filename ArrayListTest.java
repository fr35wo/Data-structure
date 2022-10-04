package hw3_1;
import java.util.ArrayList;

public class ArrayListTest {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList();
		
		System.out.println("lab5_1 : È«¼®Çö");
		
		for(int i=1;i<=10;i++) {
			list.add(i);
		}
		System.out.print(list);
		System.out.println();
		
		list.add(0,99);
		list.add(3,999);
		list.add(12,9999);
		System.out.print(list);
		System.out.println();
		
		System.out.println(list.get(12));
		list.remove(12);
		System.out.println(list.get(4));
		list.remove(4);
		System.out.println(list.get(0));
		list.remove(0);
		System.out.print(list);
		System.out.println();
		
	}
}
