import java.util.Arrays;
/* 
 * A type of binary tree where the value of the left and right child node is 
 * greater than the value of their parent node implemented using an array 
 */
public class minHeap{
	
	private int[] heap;
	private int size;
	private int maxsize;
	
	public minHeap(int maxsize) {
		this.maxsize = maxsize;
		this.heap = new int[this.maxsize+1];
		this.size = 0;
		this.heap[0] = Integer.MIN_VALUE;
	}
	//Return value of given node's parent node 
	private int getParent(int pos) {
		return pos / 2 ;
	}
	//Return value of given node's right child 
	private int getRightChild(int pos) {
		return 2 * pos;
	}
	//Return value of given node's left child 
	private int getLeftChild(int pos) {
		return (2 * pos) + 1;
	}
	//Method to check whether the given node is a leaf node or not
	private boolean isLeaf(int pos) {
		if(pos >= this.size/2 && pos <= this.size) {
			return true;
		}
		else {
			return false;
		}
	}
	//Swap values between the given node positions 
	private void swapNodes(int apos, int bpos) {
		int temp = this.heap[apos];
		this.heap[apos] = this.heap[bpos];
		this.heap[bpos] = temp;
	}
	
	/*
	 * Recursive method that ensures the invariant of the minimum heap always holds
	 * It swaps the value of the parent node with the value of it's smallest child 
	 * if the value of the parent node is greater than it's child and the recursively 
	 * calls the method till the heap invariant is maintained throughout 
	 */
	private void minHeapify(int pos) {
		if(!this.isLeaf(pos)) {
			
			if( this.heap[pos] > this.heap[this.getLeftChild(pos)] ||
					this.heap[pos] > this.heap[this.getRightChild(pos)] ) {
						
						if( this.heap[this.getLeftChild(pos)] < this.heap[this.getRightChild(pos)] ) {
							this.swapNodes(pos,this.getLeftChild(pos));
							this.minHeapify(this.getLeftChild(pos));
						}
						else {
							this.swapNodes(pos, this.getRightChild(pos));
							this.minHeapify(this.getRightChild(pos));
						}
					}
		}
		
	}
	
	/*
	 * We always add a new value at the end/leaf of the heap and then use a method
	 * called bubbling up where we keep swapping the new value with it's parent value
	 * till the parent value is no longer greater than the inserted value and the 
	 * minimum heap invariant continues to hold 
	 */
	public void insertNode(int element) {
		if(this.size >= this.maxsize) {
			System.out.println("Heap Overflow");
		}
		else {
			this.heap[++this.size] = element;
			int current = this.size;
			while( this.heap[current] < this.heap[this.getParent(current)] ) {
				this.swapNodes(current, this.getParent(current));
				current = this.getParent(current);
			}
		}
	}
	
	//Prints the heap to console in a more readable manner
	public void printMinHeap() {
		System.out.println(Arrays.toString(this.heap));
		for(int i = 1 ; i <= this.size/2 ; i++) {
			System.out.println("Parent: " + this.heap[i] 
								+ " Left Child: " + this.heap[2*i]
								+ " Right Child: " + this.heap[2*i+1]);
			System.out.println();
		}
	}
	
	
	public void runMinHeapify() {
		for(int i = this.size/2 ; i <= 1 ; i-- ) {
			this.minHeapify(i);
		}
	}
	
	/*
	 * Method that returns the value at the top of the heap and also ensures that 
	 * the heap invariant is maintained 
	 */
	public int popMin() {
		int minElement = this.heap[1];
		this.heap[1] = this.heap[this.size--];
		this.minHeapify(1);
		return minElement;
	}
	//Method that returns the value at the top of the heap
	public int peekMin() {
		return this.heap[1];
	}
	
	
	public static void main(String args[]) {
		minHeap heap = new minHeap(11);
		heap.insertNode(19);
		heap.insertNode(33);
		heap.insertNode(45);
		heap.insertNode(22);
		heap.insertNode(24);
		heap.insertNode(76);
		heap.insertNode(56);
		heap.insertNode(69);
		heap.insertNode(13);
		heap.insertNode(128);
		heap.insertNode(420);
		heap.printMinHeap();
		heap.runMinHeapify();
		heap.printMinHeap();
		System.out.println("Removed minimum value from heap: " + heap.popMin());
		System.out.println("New Minimum in heap: " + heap.peekMin());
	}
	
}