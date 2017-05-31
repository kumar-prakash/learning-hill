package pack;

import java.util.HashSet;
import pack.LinkedList.Node;
public class LinkedListUtil {
    
    static int findMergingPointV1(LinkedList list1, LinkedList list2) {
	Node node1 = list1.head;
	
	boolean mergingPointFound = false;
	while(node1 != null) {
	    Node node2 = list2.head;
	    while(node2 !=null) {
		if(node2 == node1) {
		    mergingPointFound = true;
		    break;
		}
		node2 = node2.next;
	    }
	    if(mergingPointFound)
		break;
	    node1 = node1.next;
	}
	if(mergingPointFound)
	    return node1.data;
	else
	    return -1;
    }
    
    static int findMergingPointV2(LinkedList list1, LinkedList list2) {
	Node node = list1.head;
	HashSet<Node> nodeSet = new HashSet<Node>();
	while(node != null) {
	    nodeSet.add(node);
	    node = node.next;
	}
	
	node = list2.head;
	while(node != null) {
	    if(nodeSet.contains(node)) 
		break;
	    node = node.next;
	}
	return node.data;
    }
    
    static int findMergingPointV3(LinkedList list1, LinkedList list2) {
	int diff = list1.getSize() - list2.getSize();
	diff = diff < 0 ? diff * -1 : diff;
	Node node = list1.head;
	Node temp = list2.head;
	int counter = 0;
	while(node != null) {
	    node = node.next;
	    if(counter >= diff) {
		temp = temp.next;
	    }
	    if(temp == node) {
		return temp.data;
	    }
	    counter++;
	}
	return 0;
    }
    
    static int findMergingPointV4(LinkedList list1, LinkedList list2) {
	return 0;
    }
    
    // merge two sorted linkedList
    static LinkedList mergeList(LinkedList list1, LinkedList list2) {
	LinkedList list = new LinkedList();
	Node n1 = list1.head;
	Node n2 = list2.head;
	while(n1 != null && n2 != null) {
	    if(n1.data < n2.data) {
		list.addNode(n1.data);
		n1 = n1.next;
	    } else {
		list.addNode(n2.data);
		n2 = n2.next;
	    }
	}
	Node n = n1 == null ? n2 : n1;
	if(n != null) {
	    n = n.next;
	    while(n != null) {
		list.addNode(n.data);
		n = n.next;
	    }
	}
	
	return list;
    }
    
    //Swap a linked list pair wise
    static LinkedList swapList(LinkedList list) {
	Node node = list.head;
	while(node != null) {
	    if(node.next != null) {
		int temp = node.data;
		node.data = node.next.data;
		node.next.data = temp;
		node = node.next.next;
	    } else {
		break;
	    }
	}
	return list;
    }
}
