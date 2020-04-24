/*
 * Implementation of Binary Search Tree 
 * Invariant: Left child of each node is a binary search tree with lesser values
 * Right child of each node is a binary search tree with greater values 
 */
public class binarySearchTree{
	
	public static Node root;
	
	class Node{
		int value;
		Node left;
		Node right;
		Node(int value){
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}
	
	
	public binarySearchTree() {
		this.root = null;
	}
	
	//Method that traverses the bst to look for the specified cases
	public boolean findValue(int value) {
		Node current = this.root;
		while(current != null) {
			if(value == current.value) {
				return true;
			}
			else if(value < current.value) {
				current = current.left;
			}
			else if( value > current.value ) {
				current = current.right;
			}
		}
		return false;
	}
	
	//Method that inserts the given value in the tree while maintaining the invariant
	public void insertValue(int value) {
		Node newNode = new Node(value);
		if(this.root == null) {
			this.root = newNode;
			return;
		}
		Node current = this.root, parent = null;
		while(true) {
			parent = current;
			if(value < current.value) {
				current = current.left;
				if(current == null) {
					parent.left = newNode;
					System.out.println("Inserted Node: " + value);
					return;
				}
			}
			else if(value > current.value) {
				current = current.right;
				if(current == null) {
					parent.right = newNode;
					System.out.println("Inserted Node: " + value);
					return;
				}
			}
		}
	}
	
	
	
	/*
	 * Method that deletes the given node while maintaining the invariant 
	 * Three Cases:
	 * Case 1: The node to delete has no children 
	 * Case 2: The node to delete has one child, left or right
	 * Case 3: The node to delete has 2 children 
	 */
	public boolean deleteNode(int value) {
		Node parent = root;
		Node current = root;
		boolean isLeftChild = true;
		while(value != current.value) {
			parent = current;
			if(value < current.value) {
				isLeftChild = true;
				current = current.left;
			}
			else {
				isLeftChild = false;
				current = current.right;
			}
			if(current == null) {
				System.out.println("Node to delete not found");
				return false;
			}
		}
		//Case 1
		if(current.right == null && current.left == null) {
			if(current == root) {
				root = null;
			}
			if(isLeftChild) {
				parent.left = null;
			}
			else {
				parent.right = null;
			}
		}
		//Case2
		else if(current.right == null) {
			if(current == root) {
				root = current.left;
			}
			if(isLeftChild) {
				parent.left = current.left;
			}
			else {
				parent.right = current.left;
			}
		}
		else if(current.left == null) {
			if(current == root) {
				root = current.right;
			}
			if(isLeftChild) {
				parent.left = current.right;
			}
			else {
				parent.right = current.right;
			}
		}
		//Case3
		else if(current.left != null && current.right != null) {
			Node successor = this.getSuccessor(current);
			if(current == root) {
				root = successor;
			}
			if(isLeftChild) {
				parent.left = successor;
			}
			else {
				parent.right = successor;
			}
			successor.left = current.left;
		}
		System.out.println();
		System.out.println();
		System.out.println("Deleted Node: " + value);
		return true;
	}
	
	//Depth First Inorder Traversal of the Tree for display
	public void displayTree(Node root) {
		if(root != null) {
			this.displayTree(root.left);
			System.out.print(" " + root.value);
			this.displayTree(root.right);
		}
	}
	
	
	
	//Private helper method that is used in Case 3 of deleting a node
	private Node getSuccessor(Node nodeToDelete) {
		Node successorParent = null;
		Node successor = null;
		Node current = nodeToDelete.right;
		while(current != null) {
			successorParent = successor;
			successor = current;
			current = current.left;
		}
		if(successor != nodeToDelete.right) {
			successorParent.left = successor.right;
			successor.right = nodeToDelete.right;
		}
		return successor;
	}
	
	
	public static void main(String args[]) {
		binarySearchTree bst = new binarySearchTree();
		bst.insertValue(20);
		bst.insertValue(15);
		bst.insertValue(25);
		bst.insertValue(10);
		bst.insertValue(18);
		bst.insertValue(12);
		bst.insertValue(17);
		bst.insertValue(19);
		bst.insertValue(16);
		System.out.println("Inorder Traveral of Tree");
		bst.displayTree(root);
		bst.deleteNode(15);
		System.out.println();
		System.out.println("Inorder Traveral of Tree");
		bst.displayTree(root);
		bst.deleteNode(10);
		System.out.println();
		System.out.println("Inorder Traveral of Tree");
		bst.displayTree(root);
		bst.deleteNode(25);
		System.out.println();
		System.out.println("Inorder Traveral of Tree");
		bst.displayTree(root);
	}
	
	
	
	
}