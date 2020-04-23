/*
 * Implementation of queue which is a type of an array that 
 * follows the FIFO(first in first out) Invariant
 */
public class Queue {
	
	private int[] array;
	private int capacity;
	private int count;
	private int front;
	private int rear;
	
	public Queue(int size){
		this.array = new int[size];
		this.capacity = size;
		this.count = 0;
		this.front = 0;
		this.rear = -1;
	}
	
	public int size() {
		return this.count;
	}
	
	private boolean isFull() {
		return this.count == this.capacity; 
	}
	
	private boolean isEmpty() {
		return this.count == 0;
	}
	//Method that removes the element at the front of the queue 
	public void dequeue() {
		if(this.isEmpty()) {
			System.out.println("Queue Underflow");
		}
		else {
			this.front = (this.front + 1) % this.capacity;
			this.count--;
		}
	}
	//Method that adds the element at the back of the queue
	public void enqueue(int element) {
		if(this.isFull()) {
			System.out.println("Queue Overflow");
		}
		else {
			this.rear = (this.rear + 1) % this.capacity;
			this.array[this.rear] = element;
			this.count++;
		}
	}
	/*
	 * Method that returns the element at the front of the queue 
	 * without removing it
	 */
	public int peek() {
		if(this.isEmpty()) {
			System.out.println("Queue Underflow");
			return 0;
		}
		else {
			return this.array[this.front];
		}
	}
	
	public static void main(String args[]) {
		Queue queue = new Queue(5);
		queue.peek();
		queue.dequeue();
		queue.enqueue(2);
		queue.enqueue(7);
		queue.enqueue(8);
		System.out.println(queue.peek());
		queue.dequeue();
		System.out.println(queue.peek());
		queue.enqueue(14);
		queue.enqueue(26);
		queue.enqueue(54);
		queue.enqueue(13);
		queue.dequeue();
		System.out.println(queue.peek());
		queue.enqueue(13);
	}
	
}