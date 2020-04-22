import java.util.Stack;
import java.lang.Math;

public class minStack{
	/* Minimum Stack is a type of stack that keeps track of the 
	 * minimum value in the stack at all times to be able to return it 
	 * in O(1) time
	 */
	
	private Stack<int[]> stack = new Stack<>();
	
	public minStack() {}
	
	//Method that checks and updates the minimum as the last element of the array at each push
	public void push(int x) {
		if(stack.isEmpty()) {
			stack.push( new int[]{x,x} );
		}
		else {
			int currentMin = stack.peek()[1];
			stack.push( new int[]{ x, Math.min(x,currentMin) } );
		}
	}
	
	
	public void pop() {
		stack.pop();
	}
	
	public int top() {
		return stack.peek()[0];
	}
	
	public int getMin() {
		return stack.peek()[1];
	}
	
	
	public static void main(String args[]) {
		minStack minStack = new minStack();
		minStack.push(10);
		minStack.push(55);
		minStack.push(-30);
		minStack.push(500);
		minStack.push(-20);
		minStack.push(1000);
		System.out.println(minStack.getMin() + " is the minimum value in the stack");
	}
}


