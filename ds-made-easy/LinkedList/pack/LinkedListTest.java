package pack;

import pack.LinkedList.Node;
public class LinkedListTest {
    public static LinkedList initList() {
	LinkedList list = new LinkedList();
	list.addNode(10);
	list.addNode(20);
	list.addNode(25);
	list.addNode(14);
	list.addNode(13);
	list.addNode(30);
	return list;
    }
    
    public static LinkedList initSortList() {
	LinkedList list = new LinkedList();
	list.addNode(10);
	list.addNode(20);
	list.addNode(25);
	list.addNode(30);
	list.addNode(40);
	list.addNode(45);
	return list;
    }
    static void traverseTest() {
	LinkedList list = initList();
	list.traverse();
    }
    
    static void findSizetest() {
	LinkedList list = initList();
	System.out.println(list.getSize());
	System.out.println(list.getSize(list.head));
    }
    
    static void searchItTest() {
	LinkedList list = initList();
	System.out.println(list.search(80));
	System.out.println(list.searchRec(list.head, 20));
    }
    
    static void swapTest() {
	LinkedList list = initList();
	list.traverse();
	list.swap(20, 13);
	list.traverse();
    }
    
    static void findNthTest() {
	LinkedList list = initList();
	System.out.println(list.getNth(3));
    }
    
    static void findMiddleTest() {
	LinkedList list = initList();
	System.out.println(list.getMiddle());
    }
    
    static void findNthFromLastTest() {
	LinkedList list = initList();
	System.out.println(list.findNthFromLastV3(3));
    }
    
    static void hasCycleTest() {
	LinkedList list = initList();
	list.tail.next = list.head.next.next;
	//System.out.println(list.hasCycleV1());
	System.out.println(list.hasCycleV3());
    }
    
    static void removeCycleTest() {
	LinkedList list = initList();
	list.tail.next = list.head.next.next;
	list.removeCycle();
	list.traverse();
    }
    
    static void findCycleLengthTest() {
	LinkedList list = initList();
	list.tail.next = list.head.next.next;
	System.out.println(list.findCycleLength());
	//list.traverse();
    }
    
    static void insertTest() {
	LinkedList list = initSortList();
	list.traverse();
	list.insert(22);
	list.insert(5);
	list.insert(50);
	list.traverse();
    }
    
    static void reverseTest() {
	LinkedList list = initList();
	list.traverse();
	list.reverseV2();
	list.traverse();
    }
    
    static void findMergingPointtest() {
	LinkedList list1 = new LinkedList();
	LinkedList list2 = new LinkedList();
	Node node1 = new Node(10);
	Node node2 = new Node(20);
	Node node3 = new Node(30);
	Node node4 = new Node(40);
	Node node5 = new Node(50);
	Node node6 = new Node(15);
	Node node7 = new Node(25);
	list1.addNode(node1);
	list1.addNode(node2);
	list1.addNode(node3);
	list1.addNode(node4);
	list1.addNode(node5);
	
	list2.addNode(node6);
	list2.addNode(node7);
	list2.addNode(node4);
	list2.addNode(node5);
	
	list1.traverse();
	list2.traverse();
	System.out.println(LinkedListUtil.findMergingPointV3(list1, list2));
    }
    
    public static void printReverseTest() {
	LinkedList list = initList();
	list.printReverse(list.head);
    }
    
    public static void mergeListTest() {
	LinkedList list1 = new LinkedList();
	LinkedList list2 = new LinkedList();
	list1.addNode(10);
	list1.addNode(20);
	list1.addNode(30);
	list1.addNode(40);
	list1.addNode(50);
	
	list2.addNode(5);
	list2.addNode(15);
	list2.addNode(17);
	list2.addNode(25);
	
	list1.traverse();
	list2.traverse();
	LinkedListUtil.mergeList(list1, list2).traverse();
    }
    
    
    public static void swapListTest() {
	LinkedList list = initList();
	list.addNode(17);
	list.traverse();
	LinkedListUtil.swapList(list).traverse();
    }
    public static void main(String[] args) {
	//traverseTest();
	//findSizetest();
	//searchItTest();
	//swapTest();
	//findNthTest();
	//findNthFromLastTest();
	//hasCycleTest();
	//removeCycleTest();
	//findCycleLengthTest();
	//insertTest();
	//reverseTest();
	//findMergingPointtest();
	//printReverseTest();
	//mergeListTest();
	swapListTest();
    }
}

