public class LinkedList{
	
	Node head;
	
	 static class Node{
		
		 int value;
		 Node next;
		 
		 Node(int value) {
			 this.value = value;
			 this.next = null;
		 }
	}
	 
	 
	//Method that inserts a new node with the specified value at the end of the ll 
	public static LinkedList insert(LinkedList list, int value) {
			
		Node newNode = new Node(value);
			
		if(list.head == null) {
			list.head = newNode;
		}
		else {
			Node current = list.head;
			while(current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
		return list;
	}
		
	//Method that traverses and prints out all the values in the ll	
	public static void printList(LinkedList list) {
		Node current = list.head;
		while(current != null) {
			System.out.print(current.value + "->");
			current = current.next;
		}
	}
	
	
	//Method that removes a node from the ll based on given value  
	public static LinkedList deleteByValue(LinkedList list, int value) {
		
		Node current = list.head , prev = null;
		
		if(current != null && current.value == value) {
			
			list.head = current.next;
			
			return list;
		}
		
		while(current != null && current.value != value) {
			prev = current;
			current = current.next;
		}
		
		if(current != null) {
			prev.next = current.next;
		}
		else {
			System.out.println("Key not found");
		}
		
		return list;
		
	}
	
	//Method that removes a node from the ll based on given position
	public static LinkedList deleteByPos(LinkedList list, int index) {
		
		Node current = list.head, prev = null;
		
		if(index == 0) {
			list.head = list.head.next;
			return list;
		}
		
		int counter = 0;
		while(current != null) {
			if(counter == index) {
				prev.next = current.next;
				break;
			}
			else {
				prev = current;
				current = current.next;
				counter++;
			}
		}
		if(current == null) {
			System.out.println("Index out of bounds");
		}
		return list;
		
	}
	
		
				 	 
			
	public static void main(String args[]) {
		LinkedList list = new LinkedList();
		System.out.println(list.head == null);
		list = list.insert(list, 1);
		list = list.insert(list, 2);
		list = list.insert(list, 3);
		list = list.insert(list, 4);
		list = list.insert(list, 5);
		list.printList(list);
		list = list.deleteByValue(list,5);
		System.out.println();
		list.printList(list);
		list = list.deleteByValue(list, 1);
		System.out.println();
		list.printList(list);
		list = list.insert(list,6);
		list = list.insert(list, 8);
		list = list.insert(list, 10);
		System.out.println();
		list.printList(list);
		list = list.deleteByPos(list,0);
		list = list.deleteByPos(list, 0);
		System.out.println();
		list.printList(list);
		list = list.deleteByPos(list,2);
		System.out.println();
		list.printList(list);
		System.out.println();
		list = list.deleteByPos(list,3);
			
	}
	
	
	
}