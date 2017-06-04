package pack;

import java.util.LinkedList;

public class BinaryTree {
	BTNode root;
	
	public BinaryTree(int data) {
		setRoot(data);
	}
	
	public void setRoot(int data) {
		root = new BTNode(data);
	}
	
	public void preOrderTraversal(BTNode node) {
		if(node != null) {
			System.out.println(node.data);
			preOrderTraversal(node.leftChild);
			preOrderTraversal(node.rightChild);
		}
	}
	
	public void postOrdertraversal(BTNode node) {
		if(node != null) {
			postOrdertraversal(node.leftChild);
			postOrdertraversal(node.rightChild);
			System.out.println(node.data);
		}
	}
	
	public void inOrderTraversal(BTNode node) {
		if(node != null) {
			inOrderTraversal(node.leftChild);
			System.out.println(node.data);
			inOrderTraversal(node.rightChild);
		}
	}
	
	public void levelOrderTraversal() {
		LinkedList<BTNode> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		while(!queue.isEmpty()) {
			BTNode node = queue.poll();
			if(node != null) {
				System.out.print(node.data + " ");
				queue.add(node.leftChild);
				queue.add(node.rightChild);
			}
		}
	}
	
	public int findMaxElement(BTNode node) {
		int max = node.data;
		if(node.leftChild != null) {
			int leftMax = findMaxElement(node.leftChild);
			if(leftMax > max)
				max = leftMax;
		}
		if(node.rightChild != null) {
			int rightMax = findMaxElement(node.rightChild);
			if(rightMax > max)
				max = rightMax;
		}
		return max;
	}
	
	public boolean hasElement(BTNode node, int data) {
		if(node.data == data) {
			return true;
		}
		if(node.leftChild != null)
			return hasElement(node.leftChild, data);
		if(node.rightChild != null)
			return hasElement(node.rightChild, data);
		return false;
	}
	
	public void insertElement(int data, BTNode node) {
		if(node.leftChild == null) {
			node.leftChild = new BTNode(data);
			return;
		}
		/*if(node.rightChild == null) {
			node.rightChild = new BTNode(data);
			return;
		}*/
		insertElement(data, node.leftChild);
		//insertElement(data, node.rightChild);
	}
	
	public int findSize(BTNode node) {
		if(node == null) {
			return 0;
		} else {
			return 1 + findSize(node.leftChild) + findSize(node.rightChild);
		}
	}
	
	public void printLevelOrder() {
		LinkedList<BTNode> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		while(!queue.isEmpty()) {
			BTNode node = queue.poll();
			if(node == null) {
				System.out.println("");
				if(!queue.isEmpty()) {
					queue.add(null);
				}
			} else {
				
				if(node.leftChild != null) {
					queue.add(node.leftChild);
				}
				if(node.rightChild != null) {
					queue.add(node.rightChild);
				}
				System.out.print(node.data + " ");
			}
			
		}
	}
	
	public int findHeight(BTNode node) {
		if(node.rightChild == null && node.leftChild == null) {
			return 0;
		}
		
		int leftHeight = 0;
		if(node.leftChild != null) {
			leftHeight = findHeight(node.leftChild);
		}
		int rightHeight = 0;
		if(node.rightChild != null) {
			rightHeight = findHeight(node.rightChild);
		}
		return 1 + (leftHeight > rightHeight ? leftHeight : rightHeight);
	}
	
	public void mirror(BTNode node) {
		if(node == null)
			return;
		// swap left and right
		BTNode temp = node.leftChild;
		node.leftChild = node.rightChild;
		node.rightChild = temp;
		mirror(node.leftChild);
		mirror(node.rightChild);
	}
	
	public boolean printAncestors(BTNode node, BTNode end) {
		if(node == null) {
			return false;
		}
		if(node.data == end.data) {
			return true;
		}
		if(printAncestors(node.leftChild, end)) {
			System.out.println(node);
			return true;
		}
		if(printAncestors(node.rightChild, end)) {
			System.out.println(node);
			return true;
		}
		return false;
	}
	
	public void printNodeAtKthDistance(BTNode node, int k) {
		if(k == 0 && node != null) {
			System.out.println(node);
			return;
		}
		printNodeAtKthDistance(node.leftChild, k - 1);
		printNodeAtKthDistance(node.rightChild, k - 1);
	}
	
	public int createTreFromPreOrder(int [] arr, BTNode node, int i) {
		if(i == 0) {			
			node = new BTNode(arr[i]);
		}
		if(arr[i] == 1) {
			
		}
		return 0;
	}
	
	
	static class BTNode {
		int data;
		BTNode leftChild;
		BTNode rightChild;
		
		public BTNode(int data) {
			this.data = data;
		}
		
		public String toString() {
			return String.valueOf(data);
		}
	}
	
	
	public String toString() {
		return root.toString();
	}
}
