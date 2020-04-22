public class Stack{
	
	private int size;
	private int top;
	private int[] array;
	
	//Class constructor with one integer argument 
	public Stack(int Size) {
		
		size = Size;
		top = -1;
		array = new int[Size];
		
	}
	
	//Method that returns true if stack is empty and false otherwise
	public boolean isEmpty() {
		
		return top < 0;
	}
	
	//Method that pushes given value to the top of the stack 
	public boolean push(int x) {
		
		if(top >= size) {
			System.out.println("Stack Overflow");
			return false;
		}
		else {
			array[++top] = x;
			return true;
		}
		
	}
	
	//Method that removes and returns integer on top of the stack 
	public int pop() {
		if(top < 0) {
			System.out.println("Stack Underflow");
			return 0;
		}
		else {
			int x = array[top--];
			return x;
		}
	}
	
	//Method that returns integer on top of the stock 
	public int peek() {
		if(top < 0) {
			System.out.println("Stack Underflow");
			return 0;
		}
		else {
			int x = array[top];
			return x;
		}
	}
	
	//Method that returns the count of current elements in the stack 
	public int getElementCount() {
		return top + 1;
	}
	
	
	
	
	public static void main(String args[]) {
		
		Stack stack = new Stack(3);
		System.out.println(stack.isEmpty());
		stack.push(13);
		stack.push(26);
		stack.push(39);
		System.out.println(stack.pop() + " Removed from Top of Stack");
		stack.pop();
		stack.pop();
		stack.pop();
		stack.push(13);
		stack.push(26);
		System.out.println(stack.peek() + " Peeked from Top of Stack" );
		stack.pop();
		System.out.println(stack.peek() + " Peeked from Top of Stack" );
		stack.pop();
		System.out.println(stack.isEmpty());
		System.out.println(stack.getElementCount());
		stack.push(13);
		System.out.println(stack.getElementCount());

	}
}