package cs2232assignment2;

public class TestDLinkedList<I> {

	public static void main(String[] args) {
	DLinkedList<Integer, String, Integer> dList = new DLinkedList<>();
	System.out.println("Doubly Linked List: ");
	dList.addFirst(23456, "Jennifer", 90);
	dList.addLast(87654, "David", 100);
	dList.addBefore(23456, 89709, "Emily", 80);
	dList.addAfter(87654, 34565, "Kaitlyn", 40);
	dList.addBetween(98974, "Oliver", 30, dList.search(89709),dList.search(23456));
	dList.addAfter(23456, 98765, "Sandra", 20);
	dList.addBefore(23456, 26234, "Andre", 100);
	dList.display();
	System.out.println("There are "+dList.getSize()+" students in the list.");
	dList.removeAt(23456);
	dList.removeFirst();
	dList.removeLast();
	dList.remove(dList.search(98974));
	System.out.println();
	dList.display();
	System.out.println("There are "+dList.getSize()+" students in the list.");
	NodeD<Integer, String, Integer> Tyler = new NodeD<>(75456,"Tyler",80);
	dList.update(87654, 14252, "David", 99);
	dList.setHeader(Tyler);
	NodeD<Integer,String,Integer> Kendall = new NodeD<>(64664,"Kendall",67);
	dList.setTrailer(Kendall);
	System.out.println();
	dList.display();
	System.out.println("There are "+dList.getSize()+" students in the list.");
	System.out.println("The first name on the list is "+dList.getFirstStuName()+".");
	System.out.println("The first id on the list is "+dList.getFirstStuID()+".");
	System.out.println("The first score on the list is "+dList.getFirstStuScore()+".");
	System.out.println("The last name on the list is "+dList.getLastStuName()+".");
	System.out.println("The last id on the list is "+dList.getLastStuID()+".");
	System.out.println("The last score on the list is "+dList.getLastStuScore()+".");
	}

}
