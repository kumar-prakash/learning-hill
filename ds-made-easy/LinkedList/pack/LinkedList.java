package pack;

import java.util.HashMap;
import java.util.HashSet;

public class LinkedList {
    Node head;
    Node tail;
    
    public void addNode(int data) {
	Node newNode = new Node(data);
	if(head == null)
	    head = newNode;
	else 
	    tail.next = newNode;
	tail = newNode;
    }
    
    public void addNode(Node node) {
	if(head == null)
	    head = node;
	else 
	    tail.next = node;
	tail = node;
    }
    
    public int getSize() {
	int size = 0;
	Node node = head;
	while(node != null) {
	    size++;
	    node = node.next;
	}
	
	return size;
    }
    
    public int getSize(Node node) {
	if(node != null) {
	    return getSize(node.next) + 1;
	} else {
	    return 0;
	}
    }
    
    public void traverse() {
	Node node = head;
	while(node != null) {
	    System.out.print(node.toString()+ ", ");
	    node = node.next;
	}
	System.out.println("");
    }
    
    public boolean search(int data) {
	Node node = head;
	while(node != null) {
	    if(data == node.data) {
		return true;
	    }
	    node = node.next;
	}
	return false;
    }
    
    public boolean searchRec(Node node, int data) {
	if(node != null) {
	    if(node.data == data) {
		return true;
	    } else {
		return searchRec(node.next, data);
	    }
	}
	return false;
    }
    
    public void swap(int x, int y) {
	Node n1 = null, n1Prev = null;
	Node n2 = null, n2Prev = null;
	Node node = head;
	Node prev = null;
	while(node != null) {
	    if(node.data == x) {
		n1 = node;
		n1Prev = prev;
	    }
	    if(node.data == y) {
		n2 = node;
		n2Prev = prev;
	    }
	    prev = node;
	    node = node.next;
	}
	
	Node temp = n1Prev.next; 
	n1Prev.next = n2Prev.next;
	n2Prev.next = temp;
	
	temp = n1.next;
	n1.next = n2.next;
	n2.next = temp;
	
    }
    
    public int getNth(int index) {
	Node n = head;
	int counter = 0;
	while(n != null) {
	    if(counter == index) {
		return n.data;
	    }
	    n = n.next;
	    counter++;
	}
	return -1;
    }
    
    public int getMiddle() {
	Node node = head;
	Node mid = head;
	while(node != null) {
	    if(node.next == null) {
		break;
	    }
	    mid = mid.next;
	    node = node.next.next;
	}
	return mid.data;
    }
    
    public int findNthFromLastV1(int n) {
	int data = 0;
	Node node = head;
	while(node != null) {
	    int left = 0;
	    Node temp = node;
	    while(temp != null) {
		left++;
		temp = temp.next;
	    }
	    if(n == left) {
		data = node.data;
	    }
	    node = node.next;
	}
	return data;
    }
    
    public int findNthFromLastV2(int n) {
	int data = 0;
	HashMap<Integer, Node> indexMap = new HashMap<>();
	Node node = head;
	int index = 0;
	while(node != null) {
	    indexMap.put(index, node);
	    index++;
	    node = node.next;
	}
	
	data = indexMap.get(index - n).data;
	return data;
    }
    
    public int findNthFromLastV3(int n) {
	int count = 0;
	Node node = head;
	Node nth = head;
	while(node != null) {
	    count++;
	    if(count > n) {
		nth = nth.next;
	    }
	    node = node.next;
	}
	
	return nth.data;
    }
    
    //Using brute force
    public boolean hasCycleV1() {
	Node node = head;
	boolean hasCycle = false;
	while(node != null && !hasCycle) {
	    Node temp = head;
	    while(temp != null) {
		if(temp == node)
		    break;
		if(node.next == temp) {
		    hasCycle = true;
		    break;
		}
		temp = temp.next;
	    }
	    node = node.next;
	}
	return hasCycle;
    }
    
    // Using hashset
    public boolean hasCycleV2() {
	HashSet<Node> visited = new HashSet();
	Node node = head;
	while(node != null) {
	    if(visited.contains(node)) {
		return true;
	    } else {
		visited.add(node);
	    }
	    node = node.next;
	}
	return false;
    }
    
    //Using floyd algorithm
    public boolean hasCycleV3() {
	Node slow = head;
	Node fast = head;
	while(fast != null) {
	    slow = slow.next;
	    if(fast.next != null) {
		fast = fast.next.next;
	    }
	    if(fast == slow) {
		System.out.println(fast);
		return true;
	    }
	}
	
	return false;
    }
    
    public void removeCycle() {
	Node slow = head;
	Node fast = head;
	boolean hasCycle = false;
	while(fast != null) {
	    slow = slow.next;
	    if(fast.next != null) {
		fast = fast.next.next;
	    }
	    if(fast == slow) {
		slow = head;
		hasCycle = true;
		break;
	    }
	}
	Node last = fast;
	if(hasCycle) {
	    while(true) {
		if(fast == slow) {
		    break;
		}
		last = fast;
		fast = fast.next;
		slow = slow.next;
	    }
	}
	last.next = null;
	//System.out.println(last);
    }
    
    public int findCycleLength() {
	int size = 0;
	Node fast = head;
	Node slow = head;
	boolean hasCycle = false;
	
	// find cycle
	while(fast != null) {
	    slow = slow.next;
	    if(fast.next != null) {
		fast = fast.next.next;
	    }
	    if(slow == fast) {
		hasCycle = true;
		break;
	    }
	}
	
	// remove cycle and find start point
	Node last = fast; 
	if(hasCycle) {
	    slow = head;
	    while(true) {
		last = fast;
		fast = fast.next;
		slow = slow.next;
		if(fast == slow) {
		    break;
		}
	    }
	}
	last.next = null;
	
	// find length from start point
	while(true) {
	    size++;
	    if(slow == last) {
		break;
	    }
	    slow = slow.next;
	}
	return size;
    }
    
    //Insert node in a sorted list
    public void insert(int data) {
	Node node = head;
	Node last = head;
	Node newNode = new Node(data);
	
	// if the added item is at first position
	if(head.data > data) {
	    newNode.next = head;
	    head = newNode;
	    return;
	}
	
	
	while(node != null) {
	    if(node.data > data) {
		break;
	    }
	    last = node;
	    node = node.next;
	}
	
	last.next = newNode;
	newNode.next = node;
    }
    
    // reverse a linked list
    public void reverseV1(){
	Node node = head;
	Node last = null;
	while(node != null) {
	    Node temp = node.next;
	    if(node == head) {
		node.next = null;
	    } else {
		node.next = last;
	    }
	    last = node;
	    node = temp;
	}
	
	head = last;
    }
    
 // reverse a linked list
    public void reverseV2(){
	Node temp = null;
	Node next = null;
	while(head != null) {
	    next = head.next;
	    head.next = temp;
	    temp = head;
	    head = next;
	}
	head = temp;
    }
    
    // print in reverse
    public void printReverse(Node node) {
	if(node != null) {
	    printReverse(node.next);
	    System.out.print(node + " ");
	}
    }
    
    static class Node {
	int data;
	Node next;
	
	public Node(int data) {
	    this.data = data;
	}
	
	@Override
	public String toString() {
	    return  String.valueOf(data) + "[" + this.hashCode() + "]";
	}
    }
}
