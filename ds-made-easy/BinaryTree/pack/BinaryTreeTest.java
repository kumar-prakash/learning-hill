package pack;

import pack.BinaryTree.BTNode;

public class BinaryTreeTest {
	static BinaryTree initTree() {
		BinaryTree tree = new BinaryTree(10);
		BTNode node1 = new BTNode(20);
		BTNode node2 = new BTNode(30);
		BTNode node3 = new BTNode(40);
		BTNode node4 = new BTNode(50);
		BTNode node5 = new BTNode(60);
		BTNode node6 = new BTNode(70);
		BTNode node7 = new BTNode(80);
		//node7.rightChild = new BTNode(100);
		
		tree.root.leftChild = node1;
		tree.root.rightChild = node2;
		
		node1.leftChild = node3;
		node1.rightChild = node4;
		
		node2.leftChild = node5;
		node2.rightChild = node6;
		
		node5.leftChild = node7;
		
		return tree;
	}
	
	static void preOrderTraversalTest() {
		BinaryTree tree = initTree();
		tree.preOrderTraversal(tree.root);
	}
	
	static void postOrderTraversalTest() {
		BinaryTree tree = initTree();
		tree.postOrdertraversal(tree.root);
	}
	
	static void inOrderTraversalTest() {
		BinaryTree tree = initTree();
		tree.inOrderTraversal(tree.root);
	}
	
	static void levelOrderTraversalTest() {
		BinaryTree tree = initTree();
		tree.levelOrderTraversal();
	}
	
	static void findMaxTest() {
		BinaryTree tree = initTree();
		System.out.println(tree.findMaxElement(tree.root));
	}
	
	static void hasElementTest() {
		BinaryTree tree = initTree();
		System.out.println(tree.hasElement(tree.root, 400));
	}
	
	static void insertElementTest() {
		BinaryTree tree = initTree();
		tree.insertElement(300, tree.root);
		tree.levelOrderTraversal();
	}
	
	static void findSizeTest() {
		BinaryTree tree = initTree();
		System.out.println(tree.findSize(tree.root));
	}
	
	static void levelOrderPrintTest() {
		BinaryTree tree = initTree();
		tree.printLevelOrder();
	}
	
	static void findHeightTest() {
		BinaryTree tree = initTree();
		System.out.println(tree.findHeight(tree.root));
	}
	
	static void isSameStructureTest() {
		BinaryTree tree1 = initTree();
		BinaryTree tree2 = initTree();
		//tree2.insertElement(500, tree2.root);
		System.out.println(BinaryTreeUtil.isSameStructure(tree1.root, tree2.root));
	}
	
	static void mirrorTest() {
		BinaryTree tree = initTree();
		tree.printLevelOrder();
		tree.mirror(tree.root);
		tree.printLevelOrder();
	}
	
	static void printAncestorTest() {
		BinaryTree tree = initTree();
		tree.printAncestors(tree.root, new BTNode(40));
	}
	
	static void printNodeAtKthDistanceTest() {
		BinaryTree tree = initTree();
		tree.printNodeAtKthDistance(tree.root, 2);
	}
	
	public static void main(String[] args) {
		preOrderTraversalTest();
		//postOrderTraversalTest();
		//inOrderTraversalTest();
		//levelOrderTraversalTest();
		//findMaxTest();
		//hasElementTest();
		//insertElementTest();
		//findSizeTest();
		//levelOrderPrintTest();
		//findHeightTest();
		//isSameStructureTest();
		//mirrorTest();
		//printAncestorTest();
		//printNodeAtKthDistanceTest();
	}
}
