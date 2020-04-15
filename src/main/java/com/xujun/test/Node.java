package com.xujun.test;

/**
 * @Author :Jun-Xu
 * @Date: 2020/03/30/ 22:01
 * @Description :
 */

class Node{
	Object data;
	Node next;
	public Node(Object data, Node next) {
		this.data = data;
		this.next = next;
	}

	public Node() {
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	static Node reverse(Node head){
		if(head.next==null || head.next.next==null){
			return head;
		}
		//前一个节点指针
		Node preNode = null;
		//当前节点指针
		Node curNode = head;
		//下一个节点指针
		Node nextNode = null;

		while (curNode != null){
			nextNode = curNode;//nextNode 指向下一个节点
			preNode=null;//将当前节点next域指向前一个节点
			preNode = curNode;//preNode 指针向后移动
			curNode = nextNode;//curNode指针向后移动
		}
		return preNode;
	}
	//递归实质上就是系统帮你压栈的过程，系统在压栈的时候会保留现场
	 static Node reverse2(Node head) {
		//递归
		if (null == head ||null  == head.next) {
			return head;
		}
		Node temp = head.next;
		Node newHead = reverse2(head.next);
		temp.next = head;
		head.next = null;
		return newHead;
	}

	public static void main(String[] args) {
		Node n1 = new Node();
		Node n2 = new Node();
		Node n3 = new Node();
		Node n4 = new Node();
		n1.data = 1;
		n2.data = 2;
		n3.data = 3;
		n4.data = 4;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		System.out.println(reverse(n1).data);
	}
	/**
	 * 递归，在反转当前节点之前先反转后续节点
	 */
	public static Node Reverse1(Node head) {
		// head看作是前一结点，head.getNext()是当前结点，reHead是反转后新链表的头结点
		if (head == null || head.getNext() == null) {
			return head;// 若为空链或者当前结点在尾结点，则直接还回
		}
		Node reHead = Reverse1(head.getNext());// 先反转后续节点head.getNext()
		head.getNext().setNext(head);// 将当前结点的指针域指向前一结点
		head.setNext(null);// 前一结点的指针域令为null;
		return reHead;// 反转后新链表的头结点
	}
}

