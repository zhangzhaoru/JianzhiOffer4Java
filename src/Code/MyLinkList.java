package Code;

/**
 * 
 * @Description 单链表
 * @author ZhangZhaoRu
 * @version
 * @date 2021年3月4日下午9:30:52
 *
 */
public class MyLinkList {
	private Node head = new Node(-1);
	private int length = 0;
	
	public int getLength() {
		return length;
	}
	
	public void add(Node node) {
		Node temp = head;
		for(int i = 0;i<length;i++) {
			temp = temp.next;
		}
		temp.next = node;
		length++;
	}

	public boolean delete(int index) {
		if (index >= length || index < 0) {
			return false;
		}
		Node temp = head;
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		if (temp.next != null) {
			length--;
		}
		temp.next = temp.next.next;
		return true;
	}

	public boolean insert(Node node, int index) {
		if (index < 0 || index >= length) {
			return false;
		}
		Node temp = head;
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		node.next = temp.next;
		temp.next = node;
		length++;
		return true;
	}

	public void disList() {
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}
		Node temp = head.next;
		while (temp != null) {
			if (temp.next != null) {
				System.out.print(temp.data + "->");
			} else {
				System.out.println(temp.data);
			}
//			System.out.println(temp.data+" ");
			temp = temp.next;
		}
	}

	public boolean update(Node node, int index) {
		if (head.next == null) {
			System.out.println("链表为空");
			return false;
		}
		if (index < 0 || index >= length) {
			System.out.println("传入角标异常");
			return false;
		}
		Node temp = head;
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		temp.next.data = node.data;
		return true;
	}

	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		
		MyLinkList myLinkList = new MyLinkList();
		myLinkList.add(node1);
		myLinkList.disList();
		myLinkList.add(node2);
		myLinkList.disList();
		myLinkList.add(node3);
		myLinkList.disList();
		myLinkList.add(node4);
		myLinkList.disList();
		myLinkList.add(node5);
		myLinkList.disList();
		System.out.println("Length: "+myLinkList.getLength());
	}
}

class Node {
	public int data;
	public Node next;

	public Node() {
	};

	public Node(int data) {
		this.data = data;
		this.next = null;
	}
}