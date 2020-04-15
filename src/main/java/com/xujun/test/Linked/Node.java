package com.xujun.test.Linked;

/**
 * @Author :Jun-Xu
 * @Date: 2020/03/31/ 0:58
 * @Description :定义链表的节点类
 */
public class Node {
	private Object data;//数据域
	private Node next;//指针域

	//data + next = node  数据加指针组成节点
	public Node(Object data) {
		//super();
		this.data = data;
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
}
