package com.xujun.test.Linked;

/**
 * @Author :Jun-Xu
 * @Date: 2020/03/31/ 1:00
 * @Description :链表的测试类
 */
public class LinkedDemo {
	public static void main(String[] args) {
		Node head = new Node(3);
		Node node1 = new Node(2);
		Node node2 = new Node(5);
		Node node3 = new Node(9);
		//head表示链表的头
		head.setNext(node1);
		node1.setNext(node2);
		node2.setNext(node3);
		//打印反转前的链表
		Node h = head;
		printLinked(h);
		System.out.println("++++++++++开始反转++++++++++");
		//调用反转
		//遍历反转
		h = reverseOne(head);
		printLinked(h);

		//递归反转
		h = reverseTwo(head);
		printLinked(h);
	}

	//递归，在反转当前结点之前先反转后续结点
	public static Node reverseTwo(Node head) {
		//边缘判断
		//head看作是前一结点，head.getNext()是当前结点，reHead是反转后新链表的头节点
		if(null != head || null != head.getNext()){
			return head;// 若为空链或者当前结点在尾结点，则直接还回
		}
		Node reHead = reverseTwo(head.getNext());//先反转后续节点head.getNext
		head.getNext().setNext(head);//当前结点的指针域指向前一结点
		head.setNext(null);//前一结点的指针域为null
		return reHead;//反转后新链表的头结点
	}

	//遍历，将当前节点的下一个节点缓存后更改当前节点指针
	public static Node reverseOne(Node head) {
		//先做一个边缘判断
		if(null == head || null == head.getNext()){
			return head;
		}
		//上一结点
		Node preNode = head;
		//当前结点
		Node curNode = head.getNext();
		//临时结点，用于保存当前结点的指针域（即下一节点）
		Node temp;
		while (null != curNode){//当前结点为null，说明位于尾结点
			temp = curNode.getNext();
			curNode.setNext(preNode);

			//指针往下移动
			preNode = curNode;
			curNode = temp;
		}
		//将原链表的头节点指针域置为null
		head.setNext(null);
		//返回新链表的头结点，即原链表的尾节点
		return preNode;
	}

	//遍历打印链表
	public static void printLinked(Node head){
		while (null != head){
			System.out.println(head.getData()+" ");
			head = head.getNext();
		}
	}


}

