package pack;

import pack.BinaryTree.BTNode;;
public class BinaryTreeUtil {
	public static boolean isSameStructure(BTNode node1, BTNode node2) {
		if(node1 == null && node2 == null) {
			return true;
		}
		if(node1 == null && node2 != null) {
			return false;
		}
		if(node1 != null && node2 == null) {
			return false;
		}
		
		if(isSameStructure(node1.leftChild, node2.leftChild) && isSameStructure(node1.rightChild, node2.rightChild)) {
			return true;
		} else {
			return false;
		}
	}
}
